package com.bitirme.web;

import com.bitirme.web.Entity.Ogrenci;
import com.bitirme.web.Repository.OgrenciRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootTest
class EYoklamaBitirmeProjesiAzizCanHamasogluApplicationTests {

	@Autowired
	private OgrenciRepository ogrenciRepo;

	@Test
	void contextLoads() {
		Ogrenci ogrenci=new Ogrenci();
		ogrenci.setTckn("11111111111");
		ogrenci.setAd("Aziz Can");
		ogrenci.setSoyad("Hamaşoğlu");
		ogrenci.setDogumTarihi("10-10-2003");
		ogrenci.setDogumYeri("Antakya/HATAY");
		ogrenci.setCinsiyet('E');
		ogrenci.setSinifi('4');
		ogrenciRepo.save(ogrenci);

	}

}
