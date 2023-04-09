package com.bitirme.web.Controller;

import com.bitirme.web.Entity.Ogrenci;
import com.bitirme.web.Repository.OgrenciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class OgrenciController {

    @Autowired
    private OgrenciRepository ogrenciRepo;

    @PostMapping("/ogrenciEkle")
    public ResponseEntity ogrenciEkle(Ogrenci ogrenci){
//        Ogrenci ogr=new Ogrenci();
//        ogr.setOgrenciNo(ogrenci.get("ogrenciNo"));
//        ogr.setTckn(ogrenci.get("tckn"));
//        ogr.setAd(ogrenci.get("ad"));
//        ogr.setSoyad(ogrenci.get("soyad"));
//        ogr.setDogumTarihi(ogrenci.get("dogumTarihi"));
//        ogr.setDogumYeri(ogrenci.get("dogumYeri"));

//        ogr.setCinsiyet('E');
//        ogr.setSinifi('2');

//        ogr.setCinsiyet(ogrenci.get("cinsiyet").charAt(0));
//        ogr.setSinifi(ogrenci.get("sinifi").charAt(0));
//        ogr.setRfidKodu(ogrenci.get("rfidKodu"));
//        ogr.setParola(ogrenci.get("parola"));

        ogrenciRepo.save(ogrenci);
        return new ResponseEntity("Başarılı!", HttpStatus.OK);
    }

}
