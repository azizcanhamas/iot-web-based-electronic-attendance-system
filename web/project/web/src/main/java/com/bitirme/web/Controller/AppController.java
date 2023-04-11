package com.bitirme.web.Controller;

import com.bitirme.web.Entity.Ogrenci;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String empty(){
        return "ogrenci-login";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/index")
    public String index(){
        return "redirect:/home";
    }

    @GetMapping("/akademisyen-login")
    public String akademisyenLogin(){
        return "akademisyen-login";
    }

    @GetMapping("/ogrenci-login")
    public String ogrenciLogin(){
        return "ogrenci-login";
    }


    @GetMapping("/ogrenci-islemleri")
    public String ogrenciIslemleri(Model model){
        model.addAttribute("Ogrenci",new Ogrenci());
        return "ogrenci-islemleri";
    }

    @GetMapping("/devam-islemleri")
    public String devamIslemleri(){
        return "devam-islemleri";
    }

    @GetMapping("/sinif-islemleri")
    public String sinifIslemleri(){
        return "sinif-islemleri";
    }
    @GetMapping("/ders-islemleri")
    public String dersIslemleri(){
        return "ders-islemleri";
    }
    @GetMapping("/cihaz-islemleri")
    public String cihazIslemleri(){
        return "cihaz-islemleri";
    }

    @GetMapping("/profil")
    public String profil(){
        return "profil";
    }
}
