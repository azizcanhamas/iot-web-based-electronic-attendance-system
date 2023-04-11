package com.bitirme.web.Entity;


import javax.persistence.*;

@Entity
@Table(name = "Ogrenci")
public class Ogrenci{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ogrenciNo")
    private String ogrenciNo;
    @Column(name = "tckn")
    private String tckn;
    @Column(name = "ad")
    private String ad;
    @Column(name = "soyad")
    private String soyad;
    @Column(name = "dogum_tarihi")
    private String dogumTarihi;
    @Column(name = "dogum_yeri")
    private String dogumYeri;
    @Column(name = "cinsiyet")
    private char cinsiyet;
    @Column(name = "sinifi")
    private char sinifi;
    @Column(name = "parola")
    private String parola;
    @Column(name = "rfid_kodu")
    private String rfidKodu;

    //Spring Security icin role tanimlamasi
    @Column(name="role")
    private String role;

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public char getSinifi() {
        return sinifi;
    }

    public void setSinifi(char sinifi) {
        this.sinifi = sinifi;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getRfidKodu() {
        return rfidKodu;
    }

    public void setRfidKodu(String rfidKodu) {
        this.rfidKodu = rfidKodu;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

