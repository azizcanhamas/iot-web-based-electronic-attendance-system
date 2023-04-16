package com.bitirme.web.Scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class YoklamaScheduling {

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

    @Scheduled(cron = "0,15,30,45 * ? * *") //Saati 0,15,30,45 gece calis
    public void yoklamaKontrol(){


    }

}
