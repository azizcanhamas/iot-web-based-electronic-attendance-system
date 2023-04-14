package com.bitirme.web.Controller;

import com.bitirme.web.Entity.Cihaz;
import com.bitirme.web.Repository.CihazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CihazController {

    @Autowired
    private CihazRepository cihazRepo;

    @GetMapping("/cihazEkle")
    public String cihazEkle(@RequestParam("cihazToken") String cihazToken,@RequestParam("sinifKodu") String sinifKodu){
        Cihaz c=new Cihaz();
        c.setCihazToken(new BCryptPasswordEncoder().encode(cihazToken));
        c.setSinifKodu(sinifKodu);
        cihazRepo.save(c);
        return "redirect:/cihaz-islemleri";
    }

    @GetMapping("/cihazSil")
    public String cihazSil(@RequestParam("sinifKodu") String sinifKodu){
        cihazRepo.deleteBySinifKodu(sinifKodu);
        return "redirect:/cihaz-islemleri";
    }

    @GetMapping("/cihazGuncelle")
    public String cihazGuncelle(@RequestParam("eskiSinif") String eskiSinif,@RequestParam("yeniSinif") String yeniSinif){
        Cihaz c= cihazRepo.findBySinifKodu(eskiSinif);
        if(c!=null){
            c.setSinifKodu(yeniSinif);
            cihazRepo.save(c);
        }
        return "redirect:/cihaz-islemleri";
    }

}
