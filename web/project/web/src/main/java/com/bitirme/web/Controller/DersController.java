package com.bitirme.web.Controller;

import com.bitirme.web.Entity.Ders;
import com.bitirme.web.Repository.DersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DersController {

    @Autowired
    private DersRepository dersRepo;

    @GetMapping("/dersEkle")
    public String dersEkle(Ders ders){
        dersRepo.save(ders);
        return "ders-islemleri";
    }

}
