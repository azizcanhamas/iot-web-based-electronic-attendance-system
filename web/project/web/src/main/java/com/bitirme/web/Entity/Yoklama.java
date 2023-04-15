package com.bitirme.web.Entity;


import javax.persistence.*;

@Entity
@Table(name="Yoklama")
public class Yoklama {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ogrenci_no")
    private String ogrenciNo;

    @Column(name = "ders_kodu")
    private String dersKodu;

    @Column(name = "ders_tarihi")
    private String dersTarihi;

    @Column(name = "katilma_durumu")
    private String katilmaDurumu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public String getDersTarihi() {
        return dersTarihi;
    }

    public void setDersTarihi(String dersTarihi) {
        this.dersTarihi = dersTarihi;
    }

    public String getKatilmaDurumu() {
        return katilmaDurumu;
    }

    public void setKatilmaDurumu(String katilmaDurumu) {
        this.katilmaDurumu = katilmaDurumu;
    }
}
