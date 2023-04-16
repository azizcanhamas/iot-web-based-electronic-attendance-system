package com.bitirme.web.Controller;

import com.bitirme.web.Entity.Ders;
import com.bitirme.web.Entity.DersOgrencileri;
import com.bitirme.web.Repository.DersOgrencileriRepository;
import com.bitirme.web.Repository.DersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DersController {

    @Autowired
    private DersRepository dersRepo;

    @Autowired
    private DersOgrencileriRepository dersOgrencileriRepo;

    @GetMapping("/dersEkle")
    public String dersEkle(Ders ders){
        dersRepo.save(ders);
        return "redirect:/ders-islemleri";
    }

    @GetMapping("/dersSil")
    public String dersSil(@RequestParam("dersKodu") String dersKodu){
        dersRepo.deleteByDersKodu(dersKodu);
        return "redirect:/ders-islemleri";
    }

    @GetMapping("/dersSinifiGuncelle")
    public String dersSinifiGuncelle(@RequestParam("dersKodu") String dersKodu,@RequestParam("sinifKodu") String sinifKodu){
        Ders d=dersRepo.findByDersKodu(dersKodu);
        d.setSinifKodu(sinifKodu);
        dersRepo.save(d);
        return "redirect:/ders-islemleri";
    }

    @GetMapping("/dersTarihiGuncelle")
    public String dersTarihiGuncelle(@RequestParam("dersKodu")String dersKodu,
                                     @RequestParam("dersGunu")String dersGunu,
                                     @RequestParam("dersSaati")String dersSaati){
        Ders d= dersRepo.findByDersKodu(dersKodu);
        //d.setDersGunu(dersGunu);
        //d.setDersSaati(dersSaati);
        dersRepo.save(d);
        return "redirect:/ders-islemleri";
    }


    //Kayitli bir derse kayitli bir ogrenciyi eklemek icin
    //Kayit islemi DersOgrencileri tablosuna gerceklesmektedir.
    @GetMapping("/derseOgrenciEkle")
    public String derseOgrenciEkle(DersOgrencileri dersOgrencileri){
        dersOgrencileriRepo.save(dersOgrencileri);
        return "redirect:/ders-islemleri";
    }

    @GetMapping("/derstenOgrenciCikar")
    public String derstenOgrenciCikar(DersOgrencileri dersOgrencileri){
        dersOgrencileriRepo.deleteByOgrenciNo(dersOgrencileri.getOgrenciNo(),dersOgrencileri.getDersKodu());
        return "redirect:/ders-islemleri";
    }

}
