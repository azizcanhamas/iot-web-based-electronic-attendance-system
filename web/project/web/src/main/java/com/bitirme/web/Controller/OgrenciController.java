package com.bitirme.web.Controller;

import com.bitirme.web.Entity.Ogrenci;
import com.bitirme.web.Entity.User;
import com.bitirme.web.Repository.OgrenciRepository;
import com.bitirme.web.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/ogrenciEkle")
    public String ogrenciEkle(Ogrenci ogrenci,@RequestParam(value="password",name = "password") String password){
        User user=new User();
        user.setRole("USER");
        user.setUsername(ogrenci.getOgrenciNo());
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        userRepo.save(user);
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
    public String ogrenciGuncelleUpdate(Ogrenci ogrenci, @PathVariable String ogrenciNo, String parola){
        Ogrenci ogr=ogrenciRepo.findByOgrenciNo(ogrenciNo);
        User user=userRepo.findByUsername(ogrenciNo);
        if(ogrenci.getAd()!=null)
            ogr.setAd(ogrenci.getAd());
        if (ogrenci.getSoyad()!=null)
            ogr.setSoyad(ogrenci.getSoyad());
        if(ogrenci.getDogumTarihi()!=null)
            ogr.setDogumTarihi(ogrenci.getDogumTarihi());

        if(parola!=null){
            user.setPassword(new BCryptPasswordEncoder().encode(parola));
        }
        if (ogrenci.getRfidKodu()!=null)
            ogr.setRfidKodu(ogrenci.getRfidKodu());
        ogrenciRepo.save(ogr);
        userRepo.save(user);
        return "redirect:/ogrenci-islemleri";
    }

    @GetMapping("/ogrenciDelete")
    public String ogrenciDelete(@RequestParam String ogrenciNo){
        ogrenciRepo.deleteByOgrenciNo(ogrenciNo);
        userRepo.deleteByUsername(ogrenciNo);
        return "ogrenci-islemleri";
    }

    @GetMapping("/ogrenciSorgula")
    public String ogrenciSorgula(@RequestParam String ogrenciNo, Model model){
        Ogrenci ogr=ogrenciRepo.findByOgrenciNo(ogrenciNo);
        model.addAttribute("ogrenciSorgu",ogr);
        return "ogrenci-islemleri";
    }

}
