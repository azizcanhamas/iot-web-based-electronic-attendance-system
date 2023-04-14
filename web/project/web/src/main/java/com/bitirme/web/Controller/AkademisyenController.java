package com.bitirme.web.Controller;

import com.bitirme.web.Entity.Akademisyen;
import com.bitirme.web.Entity.Ogrenci;
import com.bitirme.web.Entity.User;
import com.bitirme.web.Repository.AkademisyenRepository;
import com.bitirme.web.Repository.OgrenciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AkademisyenController {

    @Autowired
    private AkademisyenRepository akademisyenRepo;

    @PostMapping("/akademisyenEkle")
    public String akademisyenEkle(Akademisyen akademisyen){
        akademisyenRepo.save(akademisyen);
        return "akademisyen-islemleri";
    }

    // Guncelleme islemi icin akademisyenin var olup olmadigi sorgulanir
    // ve varsa kullaniciya bilgiler return edilir.
    @PostMapping("/unvanGuncelle")
    public String unvanGuncelle(@RequestParam String personelNo, Model model){
        Akademisyen aka=akademisyenRepo.findByPersonelNo(personelNo);
        if(aka!=null) model.addAttribute("akaUpdate",aka);
        return "akademisyen-islemleri";
    }

    // Var olan bir akademisyenin yeni bilgilerinin update edilmesi
    @PostMapping("/unvanGuncelleUpdate/{personelNo}")
    public String unvanGuncelleUpdate(@PathVariable String personelNo,@RequestParam(name="unvan")String unvan){
        Akademisyen aka=akademisyenRepo.findByPersonelNo(personelNo);
        aka.setUnvan(unvan);
        akademisyenRepo.save(aka);
        return "redirect:/akademisyen-islemleri";
    }

    @GetMapping("/akademisyenDelete")
    public String akademisyenDelete(@RequestParam String personelNo){
        akademisyenRepo.deleteByPersonelNo(personelNo);
        return "akademisyen-islemleri";
    }

    @GetMapping("/akademisyenSorgula")
    public String akademisyenSorgula(@RequestParam String personelNo, Model model){
        Akademisyen aka=akademisyenRepo.findByPersonelNo(personelNo);
        model.addAttribute("akademisyenSorgu",aka);
        return "akademisyen-islemleri";
    }

}
