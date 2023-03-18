// ================================== OLED SETUP SECTION START ====================================
//OLED icin gerekli olan kutuphanelerin import edilmesi
#include <SPI.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SH110X.h>

//OLED'in I2C adresini tutan degisken
#define i2c_Address 0x3c 

// OLED olculerini tutan genislik ve yukseklik degiskenleri (piksel cinsinden)
#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 64

// OLED'in RESET pininin NodeMCU'ya baglandigi pin numarasi
// NOT: NodeMCU RESET butonunun pinini kullanmak icin '-1' verin.
#define OLED_RESET -1

Adafruit_SH1106G display = Adafruit_SH1106G(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);
// ================================ OLED SETUP SECTION END ======================================

// ================================ BITMAP'S START ======================================

//logoyu tutan HEX array
const unsigned char fuBitmap [] PROGMEM = {
	// 'logo, 50x50px
	0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 
	0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x1f, 0xff, 0xff, 0xff, 
	0xff, 0xfe, 0x00, 0x1f, 0xff, 0xff, 0xff, 0xff, 0xfe, 0x00, 0x1c, 0x00, 0x00, 0x30, 0x00, 0x0e, 
	0x00, 0x1c, 0x00, 0x00, 0x30, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x00, 0x30, 0x00, 0x0e, 0x00, 0x1c, 
	0x00, 0x00, 0x30, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x00, 0x30, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x00, 
	0x30, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x00, 0x30, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x00, 0x30, 0x00, 
	0x0e, 0x00, 0x1c, 0x00, 0x00, 0x30, 0x00, 0x0e, 0x00, 0x1c, 0x01, 0xfe, 0x30, 0x00, 0x0e, 0x00, 
	0x1c, 0x01, 0xfe, 0x30, 0x00, 0x0e, 0x00, 0x1c, 0x01, 0xfe, 0x30, 0x00, 0x0e, 0x00, 0x1c, 0x01, 
	0xfe, 0x30, 0x00, 0x0e, 0x00, 0x1c, 0x01, 0xfe, 0x30, 0x00, 0x0e, 0x00, 0x1c, 0x01, 0xfe, 0x3f, 
	0xff, 0xfe, 0x00, 0x1c, 0x01, 0xfe, 0x3f, 0xff, 0xfe, 0x00, 0x1c, 0x00, 0x00, 0x00, 0x00, 0x0e, 
	0x00, 0x1c, 0x00, 0x00, 0x00, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x00, 0x00, 0x00, 0x0e, 0x00, 0x1c, 
	0x00, 0x00, 0x00, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x00, 0x00, 0x00, 0x0e, 0x00, 0x1f, 0xff, 0xfe, 
	0x3f, 0xe0, 0x0e, 0x00, 0x1f, 0xff, 0xfe, 0x3f, 0xe0, 0x0e, 0x00, 0x1c, 0x00, 0x06, 0x3f, 0xe0, 
	0x0e, 0x00, 0x1c, 0x00, 0x06, 0x3f, 0xe0, 0x0e, 0x00, 0x1c, 0x00, 0x06, 0x3f, 0xe0, 0x0e, 0x00, 
	0x1c, 0x00, 0x06, 0x3f, 0xe0, 0x0e, 0x00, 0x1c, 0x00, 0x06, 0x3f, 0xe0, 0x0e, 0x00, 0x1c, 0x00, 
	0x06, 0x3f, 0xe0, 0x0e, 0x00, 0x1c, 0x00, 0x06, 0x00, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x06, 0x00, 
	0x00, 0x0e, 0x00, 0x1c, 0x00, 0x06, 0x00, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x06, 0x00, 0x00, 0x0e, 
	0x00, 0x1c, 0x00, 0x06, 0x00, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x06, 0x00, 0x00, 0x0e, 0x00, 0x1c, 
	0x00, 0x06, 0x00, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x06, 0x00, 0x00, 0x0e, 0x00, 0x1c, 0x00, 0x06, 
	0x00, 0x00, 0x0e, 0x00, 0x1f, 0xff, 0xff, 0xff, 0xff, 0xfe, 0x00, 0x1f, 0xff, 0xff, 0xff, 0xff, 
	0xfe, 0x00, 0x1f, 0xff, 0xff, 0xff, 0xff, 0xfe, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 
	0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00
};

static const unsigned char loadingBitmap [] PROGMEM = {
	0x00, 0x00, 0x03, 0xf0, 0x00, 0x80, 0x00, 0x00, 0x00, 0x3f, 0xff, 0x01, 0x80, 0x00, 0x00, 0x01, 
	0xff, 0xff, 0xe3, 0x80, 0x00, 0x00, 0x07, 0xff, 0xff, 0xff, 0x80, 0x00, 0x00, 0x0f, 0xff, 0xff, 
	0xff, 0x80, 0x00, 0x00, 0x3f, 0xff, 0xff, 0xff, 0x80, 0x00, 0x00, 0x7f, 0xff, 0xff, 0xff, 0x80, 
	0x00, 0x00, 0xff, 0xfe, 0x3f, 0xff, 0x80, 0x00, 0x01, 0xff, 0xe0, 0x03, 0xff, 0x80, 0x00, 0x03, 
	0xff, 0x00, 0x01, 0xff, 0x80, 0x00, 0x07, 0xfe, 0x00, 0x03, 0xff, 0x80, 0x00, 0x07, 0xfc, 0x00, 
	0x07, 0xff, 0x80, 0x00, 0x0f, 0xf8, 0x00, 0x00, 0x00, 0x08, 0x00, 0x0f, 0xf0, 0x00, 0xe0, 0x00, 
	0x3c, 0x00, 0x1f, 0xe0, 0x00, 0xe0, 0x00, 0x7c, 0x00, 0x1f, 0xc0, 0x00, 0xe0, 0x00, 0xfe, 0x00, 
	0x3f, 0xc0, 0x73, 0xfb, 0x80, 0xfe, 0x00, 0x3f, 0xc0, 0x7f, 0xff, 0xc0, 0xff, 0x00, 0x3f, 0x80, 
	0x7f, 0xff, 0x80, 0x7f, 0x00, 0x3f, 0x80, 0x3f, 0xff, 0x00, 0x7f, 0x00, 0x7f, 0x80, 0x3f, 0xff, 
	0x00, 0x7f, 0x80, 0x7f, 0x00, 0x7e, 0x1f, 0x80, 0x3f, 0x80, 0x7f, 0x00, 0x7c, 0x0f, 0x80, 0x3f, 
	0x80, 0x7f, 0x03, 0xfc, 0x0f, 0xf0, 0x3f, 0x80, 0x7f, 0x03, 0xfc, 0x0f, 0xf0, 0x3f, 0x80, 0x7f, 
	0x03, 0xfc, 0x0f, 0xf0, 0x3f, 0x80, 0x7f, 0x00, 0x7e, 0x1f, 0x80, 0x3f, 0x80, 0x7f, 0x80, 0x7f, 
	0xff, 0x00, 0x7f, 0x80, 0x7f, 0x80, 0x3f, 0xff, 0x00, 0x7f, 0x80, 0x3f, 0x80, 0x7f, 0xff, 0x80, 
	0x7f, 0x00, 0x3f, 0xc0, 0x7f, 0xff, 0x80, 0xff, 0x00, 0x3f, 0xc0, 0x77, 0xf3, 0x80, 0xff, 0x00, 
	0x1f, 0xc0, 0x60, 0xe1, 0x01, 0xfe, 0x00, 0x1f, 0xe0, 0x00, 0xe0, 0x01, 0xfe, 0x00, 0x1f, 0xe0, 
	0x00, 0xe0, 0x03, 0xfc, 0x00, 0x0f, 0xc0, 0x00, 0x00, 0x07, 0xfc, 0x00, 0x0f, 0x80, 0x00, 0x00, 
	0x0f, 0xf8, 0x00, 0x07, 0x00, 0x3c, 0x00, 0x1f, 0xf8, 0x00, 0x00, 0x1f, 0xf8, 0x00, 0x3f, 0xf0, 
	0x00, 0x00, 0x3f, 0xf0, 0x00, 0xff, 0xe0, 0x00, 0x00, 0x1f, 0xf0, 0x03, 0xff, 0xc0, 0x00, 0x00, 
	0x1f, 0xff, 0xff, 0xff, 0x80, 0x00, 0x00, 0x1f, 0xff, 0xff, 0xff, 0x00, 0x00, 0x00, 0x1f, 0xff, 
	0xff, 0xfe, 0x00, 0x00, 0x00, 0x1f, 0xff, 0xff, 0xf8, 0x00, 0x00, 0x00, 0x1f, 0xff, 0xff, 0xe0, 
	0x00, 0x00, 0x00, 0x1e, 0xff, 0xff, 0xc0, 0x00, 0x00, 0x00, 0x0c, 0x3f, 0xfe, 0x00, 0x00, 0x00, 
	0x00, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00
};

// ================================ BITMAP'S END ======================================


// =============================== RFID SETUP SECTION START =====================================
#include <MFRC522.h>
MFRC522 rfid(0,16);//RFID Chip Select ve Reset pinlerinin ayarlarını yapıyoruz. 
byte Kart[4] = {19, 53, 19, 17}; // Buraya kendi okuttuğunuz kartın ID numarasını yazmalısınız. 
boolean Yetki;
// ================================= RFID SETUP SECTION END =====================================

void setup(){
  //OLED ekrani baslat.
  oledStart();
  delay(5000);

  //RFID'yi baslat.
  rfidStart();
  delay(5000);
}

void rfidStart(){
  display.clearDisplay();
  display.drawBitmap(39,0,loadingBitmap,50,50,1);
  
  //Ekrana "RFID baslatiliyor." yaz.
  display.setTextSize(1);
  display.setTextColor(SH110X_WHITE);
  display.setCursor(10, 56); //imleci (10,56) koordinatina tasi.
  display.println("RFID baslatiliyor.");
  display.display();


  SPI.begin();
  rfid.PCD_Init();
}

void oledStart(){
  //Display'e 0x3C adresinden I2C protokolu ile baglan.
  display.begin(i2c_Address, true);
  //Display buffer'ini temizle.
  display.clearDisplay();
  delay(2000);

  //Logoyu ekranda goster.
  display.drawBitmap(39,0,fuBitmap,50,50,1);

  //Ekrana "Firat Universitesi" yaz.
  display.setTextSize(1);
  display.setTextColor(SH110X_WHITE);
  display.setCursor(10, 56); //imleci (10,56) koordinatina tasi.
  display.println("Firat Universitesi");
  display.display();
}


void loop() {


  

  //RFID looping
  Yetki = true;
  if ( rfid.PICC_IsNewCardPresent()){ 
    if ( rfid.PICC_ReadCardSerial()){
      for (int i = 0; i < 4; i++){   
        if (rfid.uid.uidByte[i] != Kart[i]){
            Yetki = false;      
            break;
        }
      }
      if(Yetki==false){
        Serial.println("Giris izni verilmedi!");
      }
      else{
        Serial.println("Giris yapabilirsiniz!");
      }
    }
  }
}