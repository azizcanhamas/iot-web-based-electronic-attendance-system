package com.bitirme.web.Controller.APIController;


import com.bitirme.web.Entity.CihazIstekleri;
import com.bitirme.web.Repository.CihazIstekleriRepository;
import com.bitirme.web.Repository.CihazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DeviceAPI {

    @Autowired
    private CihazRepository cihazRepo;

    @Autowired
    private CihazIstekleriRepository cihazIstekleriRepo;

    @GetMapping("/api")
    public Map<String,String> varYaz(CihazIstekleri cihazIstek){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        cihazIstek.setIstekZamani(now.format(dtf));
        cihazIstek.setSinifKodu(cihazRepo.getSinifKoduByCihazToken(cihazIstek.getCihazToken()));

        cihazIstekleriRepo.save(cihazIstek);
        HashMap<String, String> map = new HashMap<>();
        map.put("message","Yoklama alındı!");
        return map;
    }


}
