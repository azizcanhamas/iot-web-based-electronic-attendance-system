package com.bitirme.web.Controller;

import com.bitirme.web.Entity.*;
import com.bitirme.web.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private AkademisyenRepository akaRepo;

    @Autowired
    private DersRepository dersRepo;

    @Autowired
    private OgrenciRepository ogrenciRepo;

    @Autowired
    private DersOgrencileriRepository dersOgrencileriRepo;

    @Autowired
    private YoklamaRepository yoklamaRepo;

    //====== CONTROLLER FUNCTIONS
    @GetMapping("/")
    public String empty(){
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("dersSayisi",dersRepo.getDersSayisi());
        model.addAttribute("ogrenciSayisi",ogrenciRepo.getOgrenciSayisi());
        model.addAttribute("akademisyenSayisi",akaRepo.getAkademisyenSayisi());
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
    public String ogrenciPanel(Model model){
        String aldiginizDersSayisi=dersOgrencileriRepo.getCountByOgrenciNo(SecurityContextHolder.getContext().getAuthentication().getName());
        String devamsizlikYapilanDersSayisi=yoklamaRepo.getDevamsizlikSayisiByOgrenciNo(SecurityContextHolder.getContext().getAuthentication().getName());
        String sinifiniz=ogrenciRepo.getSinifByOgrenciNo(SecurityContextHolder.getContext().getAuthentication().getName());

        model.addAttribute("aldiginizDersSayisi",aldiginizDersSayisi);
        model.addAttribute("devamsizlikYapilanDersSayisi",devamsizlikYapilanDersSayisi);
        model.addAttribute("sinifiniz",sinifiniz);

        return "ogrenci-panel";
    }

    @GetMapping("/ogrenci-profil")
    public String ogrenciProfil(){
        return "ogrenci-profil";
    }

    @GetMapping("/ogrenci-islemleri")
    public String ogrenciIslemleri(Model model){
        model.addAttribute("Ogrenci",new Ogrenci());
        return "ogrenci-islemleri";
    }

    @GetMapping("/yoklama-islemleri")
    public String yoklamaIslemleri(Model model){
        List<Ders> dersList=dersRepo.findAll();
        model.addAttribute("dersler",dersList);
        return "yoklama-islemleri";
    }

    @GetMapping("/sinif-islemleri")
    public String sinifIslemleri(Model model){
        List<Sinif> sinifList=sinifRepo.findAll();
        model.addAttribute("siniflar",sinifList);
        return "sinif-islemleri";
    }
    @GetMapping("/ders-islemleri")
    public String dersIslemleri(Model model){
        List<Akademisyen> akaList=akaRepo.findAll();
        model.addAttribute("akademisyenler",akaList);

        List<Sinif> sinifList=sinifRepo.findAll();
        model.addAttribute("siniflar",sinifList);

        List<Ders> dersList=dersRepo.findAll();
        model.addAttribute("dersler",dersList);

        List<Ders>dersTablo=dersList;
        String[]gunler={"","Pazartesi","Salı","Çarşamba","Perşembe","Cuma"};
        for (Ders i:dersTablo) {
            List<String> teacher=akaRepo.getPersonelNameandSurname(i.getPersonelNo());
            String[]splited=teacher.get(0).split(",");
            i.setPersonelNo(splited[0]+" "+splited[1]+" "+splited[2]);
            i.setDersGunu(gunler[Integer.parseInt(i.getDersGunu())]);
        }
        model.addAttribute("dersTablo",dersTablo);
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
