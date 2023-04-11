package com.bitirme.web.Controller;

import com.bitirme.web.Entity.Sinif;
import com.bitirme.web.Repository.SinifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class SinifController {

    @Autowired
    private SinifRepository sinifRepo;

    @GetMapping("/sinifEkle")
    public String sinifEkle(Sinif sinif){
        sinifRepo.save(sinif);
        return "redirect:/sinif-islemleri";
    }

    @GetMapping("/sinifSil")
    public String sinifSil(@RequestParam String sinifKodu){
        sinifRepo.deleteBySinifKodu(sinifKodu);
        return "redirect:/sinif-islemleri";
    }

}
