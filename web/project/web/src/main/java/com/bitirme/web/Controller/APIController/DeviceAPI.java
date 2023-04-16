package com.bitirme.web.Controller.APIController;


import com.bitirme.web.Entity.Cihaz;
import com.bitirme.web.Entity.CihazIstekleri;
import com.bitirme.web.Entity.Ders;
import com.bitirme.web.Repository.CihazIstekleriRepository;
import com.bitirme.web.Repository.CihazRepository;
import com.bitirme.web.Repository.DersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class DeviceAPI {

    @Autowired
    private CihazRepository cihazRepo;

    @Autowired
    private CihazIstekleriRepository cihazIstekleriRepo;

    @Autowired
    private DersRepository dersRepo;

    @GetMapping("/api")
    public Map<String,String> varYaz(CihazIstekleri cihazIstek) throws ParseException {

        System.out.println(cihazIstek.getCihazToken());
        System.out.println(cihazIstek.getRfidKodu());

        List<Cihaz> c=cihazRepo.findAll();
        HashMap<String, String> map = new HashMap<>();
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        for(Cihaz tmp:c){
            if(encoder.matches(cihazIstek.getCihazToken(),
                    tmp.getCihazToken())){
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                cihazIstek.setIstekZamani(now.format(dtf));
                cihazIstek.setSinifKodu(tmp.getSinifKodu());
                cihazIstek.setCihazToken(tmp.getCihazToken());

                //dersKodu
                String gunNumber= String.valueOf(LocalDate.now().getDayOfWeek().getValue());
                String saat= String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
                Ders d=dersRepo.getCurrentLesson(tmp.getSinifKodu(),gunNumber,saat+":00");
                cihazIstek.setDersKodu(d.getDersKodu());

                //personelNo
                cihazIstek.setPersonelNo(d.getPersonelNo());

                //sinifKodu
                cihazIstek.setSinifKodu(tmp.getSinifKodu());

                cihazIstekleriRepo.save(cihazIstek);
                map.put("message","Yoklama alındı!");
                return map;
            }
        }
        map.put("message","Tanimsiz cihaz!");
        return map;
    }


}
