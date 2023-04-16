package com.bitirme.web.Scheduling;

import com.bitirme.web.Entity.*;
import com.bitirme.web.Repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

@Component
public class YoklamaScheduling {

    @Autowired
    private DersRepository dersRepo;

    @Autowired
    private DersOgrencileriRepository dersOgrencileriRepo;

    @Autowired
    private YoklamaRepository yoklamaRepo;

    @Autowired
    private CihazIstekleriRepository cihazIstekleriRepo;

    @Autowired
    private OgrenciRepository ogrenciRepo;

    private static final Logger logger= LoggerFactory.getLogger(YoklamaScheduling.class);

    /*
    * fixed-rate    : Belli araliklarla calismasini saglar.
    * fixed-delay   : Metodun calismasi tamamlandiktan sonra beklenecek sure.
    * initial-delay : Uygulama ayaga kalktiktan kac saniye sonra metot calismaya baslasin.
    * cron          : Belli bir kaliba gore calistirir. (bkz: cron expression generator)
    *       cron= saniye, dakika, saat, ayın günü, ay, haftanın günü
    *               (0 0 * * * *)       = Her saat başı çalış.
    *               (0 0 8,11 * * *)    = Her gün 8'de ve 11'de çalış.
    *               (0 0/30 8-10 * * *) = Saat 8:00 ile 10:00 arası 30'dakikada bir çalış.
    * */

    //(Dakika,saniye) = (0,0),(15,0),(30,0),(45,0) oldugunda calisir.
    // Sistem 15 dakikada bir tum dersler icin yoklama aliyor.
    @Scheduled(cron = "0 0,15,30,45 * * * *")
    public void yoklamaKontrol(){
        String gunNumber;
        int dersDakikasi,sistemDakikasi;
        //Ilk 15 dakikasi gecen dersleri "Ders" tablosundan bul.
        gunNumber= String.valueOf(LocalDate.now().getDayOfWeek().getValue());
        //Sistem gununde islenecek olan dersleri bul.
        List<Ders> dersListToday=dersRepo.findByDersGunu(gunNumber);

        for (Ders d:dersListToday){
            dersDakikasi=Integer.parseInt(d.getDersSaati().split(":")[1]);
            sistemDakikasi= Calendar.getInstance().get(Calendar.MINUTE);
            if(Math.abs(sistemDakikasi-dersDakikasi)>=15){
                List<DersOgrencileri> dersOgrencileri=dersOgrencileriRepo.findByDersKodu(d.getDersKodu());
                for (DersOgrencileri dersOgrenci:dersOgrencileri) {
                    //Her bir ogrencinin yoklanmasi icin bos bir nesne olustur.
                    Yoklama yoklama=new Yoklama();
                    yoklama.setOgrenciNo(dersOgrenci.getOgrenciNo());
                    yoklama.setDersKodu(dersOgrenci.getDersKodu());

                    //Yoklama alinma tarihini olustur.
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    yoklama.setDersTarihi(now.format(dtf));

                    // Ogrenci numarasi ile ogrencinin RFID bilgisini sorgula ve karti okutup okutmadigini bul.
                    String ogrenciRFID=ogrenciRepo.getRFIDbyOgrenciNo(dersOgrenci.getOgrenciNo());
                    CihazIstekleri ci=cihazIstekleriRepo.findByRFIDandDersKodu(ogrenciRFID,dersOgrenci.getDersKodu());

                    // Kart okutulduysa KATILDI olarak isaretle.
                    if(ci!=null)
                        yoklama.setKatilmaDurumu("KATILDI");
                    else yoklama.setKatilmaDurumu("KATILMADI");
                    yoklamaRepo.save(yoklama);
                }
            }
        }
    }
}
