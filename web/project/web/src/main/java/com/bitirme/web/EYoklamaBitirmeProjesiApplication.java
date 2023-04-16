package com.bitirme.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//Planli isler icin Scheduling'i aktif et.
@EnableScheduling
@SpringBootApplication
public class EYoklamaBitirmeProjesiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EYoklamaBitirmeProjesiApplication.class, args);
	}

}
