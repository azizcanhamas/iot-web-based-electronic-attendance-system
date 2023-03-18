#include <SPI.h> 
#include <MFRC522.h>

//const byte YESIL_LED = 3;
//const byte KIRMIZI_LED = 2;

MFRC522 rfid(0,16);//RFID Chip Select ve Reset pinlerinin ayarlarını yapıyoruz. 
byte Kart[4] = {19, 53, 19, 17}; // {53, 122, 201, 226} buraya kendi okuttuğunuz kartın ID numarasını yazmalısınız. 
boolean Yetki; 
void setup() 
{ 
  Serial.begin(9600); 
  //pinMode(KIRMIZI_LED, OUTPUT); 
  //pinMode(YESIL_LED, OUTPUT);
  SPI.begin();
  rfid.PCD_Init(); 
} 
void loop()
{ 
  Yetki = true;
  if ( rfid.PICC_IsNewCardPresent())
  { 
    if ( rfid.PICC_ReadCardSerial())
    { Serial.print("Okunan Kart ID: ");
     Serial.print(rfid.uid.uidByte[0]); 
     Serial.print(",");
     Serial.print(rfid.uid.uidByte[1]); 
     Serial.print(","); 
     Serial.print(rfid.uid.uidByte[2]); 
     Serial.print(","); 
     Serial.println(rfid.uid.uidByte[3]);
    } 
    for (int i = 0; i < 4; i++)   
      if (rfid.uid.uidByte[i] != Kart[i]){
          Yetki = false;      
          break;
      }    
        
    if (Yetki == true) 
    { 
      Serial.println("Yetki Onaylandi…"); 
      //digitalWrite(YESIL_LED, HIGH); 
      delay(1000); 
      //digitalWrite(YESIL_LED, LOW);
    } 
    else 
    {
      Serial.println("Yetki Onaylanmadi…"); 
      //digitalWrite(KIRMIZI_LED, HIGH);
      delay(1000);
      //digitalWrite(KIRMIZI_LED, LOW);
    } 
    rfid.PICC_HaltA(); 
  } 
}