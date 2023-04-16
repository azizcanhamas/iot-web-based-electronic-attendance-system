package com.bitirme.web.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Ders")
public class Ders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ders_kodu")
    private String dersKodu;

    @Column(name="ders_adi")
    private String dersAdi;

    @Column(name="personel_no")
    private String personelNo;

    @Column(name="ders_kredi")
    private String dersKredi;

    @Column(name="haftalik_saat")
    private String haftalikSaat;

    @Column(name="sinif_kodu")
    private String sinifKodu;


    @Column(name="ders_gunu")
    private String dersGunu;

    @Column(name="ders_saati")
    private String dersSaati;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public String getPersonelNo() {
        return personelNo;
    }

    public void setPersonelNo(String personelNo) {
        this.personelNo = personelNo;
    }

    public String getDersKredi() {
        return dersKredi;
    }

    public void setDersKredi(String dersKredi) {
        this.dersKredi = dersKredi;
    }

    public String getHaftalikSaat() {
        return haftalikSaat;
    }

    public void setHaftalikSaat(String haftalikSaat) {
        this.haftalikSaat = haftalikSaat;
    }

    public String getSinifKodu() {
        return sinifKodu;
    }

    public void setSinifKodu(String sinifKodu) {
        this.sinifKodu = sinifKodu;
    }

    public String getDersGunu() {
        return dersGunu;
    }

    public void setDersGunu(String dersGunu) {
        this.dersGunu = dersGunu;
    }

    public String getDersSaati() {
        return dersSaati;
    }

    public void setDersSaati(String dersSaati) {
        this.dersSaati = dersSaati;
    }
}
