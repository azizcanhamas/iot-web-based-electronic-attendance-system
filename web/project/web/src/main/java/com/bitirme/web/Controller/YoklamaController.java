package com.bitirme.web.Controller;

import com.bitirme.web.Entity.Yoklama;
import com.bitirme.web.Repository.DersRepository;
import com.bitirme.web.Repository.OgrenciRepository;
import com.bitirme.web.Repository.YoklamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class YoklamaController {

    @Autowired
    private YoklamaRepository yoklamaRepo;

    @Autowired
    private OgrenciRepository ogrenciRepo;

    @Autowired
    private DersRepository dersRepo;

    @GetMapping("/yokYaz")
    public String yokYaz(Yoklama yoklama){
        yoklama.setDersTarihi(yoklama.getDersTarihi().replace("-","/"));
        Yoklama resultYoklama=yoklamaRepo.findByDersKoduAndDersTarihiAndOgrenciNo(yoklama.getDersKodu(),yoklama.getDersTarihi(),yoklama.getOgrenciNo());
        resultYoklama.setKatilmaDurumu("KATILMADI");
        yoklamaRepo.save(resultYoklama);
        return "redirect:/yoklama-islemleri";
    }

    @GetMapping("/varYaz")
    public String varYaz(Yoklama yoklama){
        yoklama.setDersTarihi(yoklama.getDersTarihi().replace("-","/"));
        Yoklama resultYoklama=yoklamaRepo.findByDersKoduAndDersTarihiAndOgrenciNo(yoklama.getDersKodu(),yoklama.getDersTarihi(),yoklama.getOgrenciNo());
        resultYoklama.setKatilmaDurumu("KATILDI");
        yoklamaRepo.save(resultYoklama);
        return "redirect:/yoklama-islemleri";
    }

    @GetMapping("/devamSorgula")
    public String devamSorgula(Model model, Yoklama yoklama){
        List<Yoklama> yoklamaList=yoklamaRepo.findByDersKoduAndOgrenciNo(yoklama.getDersKodu(),yoklama.getOgrenciNo());
        List<List<String>>viewList=new ArrayList<>();
        for(int i=0;i<yoklamaList.size();i++){
            List<String> tmpList=new ArrayList<>();
            tmpList.add(yoklamaList.get(i).getOgrenciNo());
            String nameAndSurname=ogrenciRepo.getOgrenciAdiSoyadi(yoklamaList.get(i).getOgrenciNo());
            tmpList.add(nameAndSurname.split(",")[0]);
            tmpList.add(nameAndSurname.split(",")[1]);
            tmpList.add(dersRepo.getDersAdiByDersKodu(yoklamaList.get(i).getDersKodu()));
            tmpList.add(yoklamaList.get(i).getDersTarihi());
            tmpList.add(yoklamaList.get(i).getKatilmaDurumu());

            viewList.add(tmpList);
        }
        model.addAttribute("dersler",dersRepo.findAll());
        model.addAttribute("devamSorgu",viewList);
        return "yoklama-islemleri";
    }

}
