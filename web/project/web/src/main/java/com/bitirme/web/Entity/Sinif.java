package com.bitirme.web.Entity;

import javax.persistence.*;

@Entity
@Table(name="Sinif")
public class Sinif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sinif_kodu")
    private String sinifKodu;

    @Column(name="sinif_adi")
    private String sinifAdi;

    @Column(name="sinif_kapasitesi")
    private String sinifKapasitesi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSinifKodu() {
        return sinifKodu;
    }

    public void setSinifKodu(String sinifKodu) {
        this.sinifKodu = sinifKodu;
    }

    public String getSinifAdi() {
        return sinifAdi;
    }

    public void setSinifAdi(String sinifAdi) {
        this.sinifAdi = sinifAdi;
    }

    public String getSinifKapasitesi() {
        return sinifKapasitesi;
    }

    public void setSinifKapasitesi(String sinifKapasitesi) {
        this.sinifKapasitesi = sinifKapasitesi;
    }
}
