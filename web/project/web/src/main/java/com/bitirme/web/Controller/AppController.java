package com.bitirme.web.Controller;

import com.bitirme.web.Entity.*;
import com.bitirme.web.Repository.CihazRepository;
import com.bitirme.web.Repository.SinifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private SinifRepository sinifRepo;

    @Autowired
    private CihazRepository cihazRepo;

    //====== CONTROLLER FUNCTIONS
    @GetMapping("/")
    public String empty(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/index")
    public String index(){
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/ogrenci-panel")
    public String ogrenciPanel(){
        return "ogrenci-panel";
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
    public String sinifIslemleri(Model model){
        List<Sinif> sinifList=sinifRepo.findAll();
        model.addAttribute("siniflar",sinifList);
        return "sinif-islemleri";
    }
    @GetMapping("/ders-islemleri")
    public String dersIslemleri(){
        return "ders-islemleri";
    }

    @GetMapping("/cihaz-islemleri")
    public String cihazIslemleri(Model model){
        //Sinif listesi olustur
        List<Sinif>sinifList=sinifRepo.findAll();
        model.addAttribute("siniflar",sinifList);

        //Cihaz listesi olustur
        List<Cihaz>cihazList=cihazRepo.findAll();
        model.addAttribute("cihazlar",cihazList);
        return "cihaz-islemleri";
    }

    @GetMapping("/akademisyen-islemleri")
    public String akademisyenIslemleri(Model model){
        model.addAttribute("Akademisyen",new Akademisyen());
        return "akademisyen-islemleri";
    }
}
