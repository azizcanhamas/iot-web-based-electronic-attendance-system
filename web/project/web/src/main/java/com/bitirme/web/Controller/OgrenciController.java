package com.bitirme.web.Controller;

import com.bitirme.web.Entity.Ogrenci;
import com.bitirme.web.Repository.OgrenciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OgrenciController {

    @Autowired
    private OgrenciRepository ogrenciRepo;

    @PostMapping("/ogrenciEkle")
    public String ogrenciEkle(Ogrenci ogrenci){
        ogrenciRepo.save(ogrenci);
        return "ogrenci-islemleri";
    }

    // Guncelleme islemi icin ogrencinin var olup olmadigi sorgulanir
    // ve varsa kullaniciya bilgiler return edilir.
    @PostMapping("/ogrenciGuncelle")
    public String ogrenciGuncelle(@RequestParam String ogrenciNo, Model model){
        Ogrenci ogr=ogrenciRepo.findByOgrenciNo(ogrenciNo);
        if(ogr!=null) model.addAttribute("ogrUpdate",ogr);
        return "ogrenci-islemleri";
    }

    // Var olan bir ogrencinin yeni bilgilerinin update edilmesi
    @PostMapping("/ogrenciGuncelleUpdate/{ogrenciNo}")
    public String ogrenciGuncelleUpdate(Ogrenci ogrenci, @PathVariable String ogrenciNo){
        Ogrenci ogr=ogrenciRepo.findByOgrenciNo(ogrenciNo);

        if(ogrenci.getAd()!=null)
            ogr.setAd(ogrenci.getAd());
        if (ogrenci.getSoyad()!=null)
            ogr.setSoyad(ogrenci.getSoyad());
        if(ogrenci.getDogumTarihi()!=null)
            ogr.setDogumTarihi(ogrenci.getDogumTarihi());

        if(ogrenci.getParola()!=null)
            ogr.setParola(ogrenci.getParola());
        if (ogrenci.getRfidKodu()!=null)
            ogr.setRfidKodu(ogrenci.getRfidKodu());
        ogrenciRepo.save(ogr);
        return "redirect:/ogrenci-islemleri";
    }


    @GetMapping("/ogrenciDelete")
    public String ogrenciDelete(@RequestParam String ogrenciNo){
        ogrenciRepo.deleteByOgrenciNo(ogrenciNo);
        return "ogrenci-islemleri";
    }

    @GetMapping("/ogrenciSorgula")
    public String ogrenciSorgula(@RequestParam String ogrenciNo, Model model){
        Ogrenci ogr=ogrenciRepo.findByOgrenciNo(ogrenciNo);
        model.addAttribute("ogrenciSorgu",ogr);
        return "ogrenci-islemleri";
    }

}
