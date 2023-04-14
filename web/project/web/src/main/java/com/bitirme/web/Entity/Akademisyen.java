package com.bitirme.web.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Akademisyen")
public class Akademisyen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "personelNo")
    private String personelNo;
    @Column(name = "tckn")
    private String tckn;
    @Column(name = "ad")
    private String ad;
    @Column(name = "soyad")
    private String soyad;
    @Column(name = "unvan")
    private String unvan;
    @Column(name = "dogum_tarihi")
    private String dogumTarihi;
    @Column(name = "dogum_yeri")
    private String dogumYeri;
    @Column(name = "cinsiyet")
    private char cinsiyet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonelNo() {
        return personelNo;
    }

    public void setPersonelNo(String personelNo) {
        this.personelNo = personelNo;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public char getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(char cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
}
