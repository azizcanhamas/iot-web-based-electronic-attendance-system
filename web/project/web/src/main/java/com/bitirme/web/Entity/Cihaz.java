package com.bitirme.web.Entity;

import javax.persistence.*;

@Entity
@Table(name="Cihaz")
public class Cihaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sinif_kodu")
    private String sinifKodu;

    @Column(name="cihaz_token")
    private String cihazToken;

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

    public String getCihazToken() {
        return cihazToken;
    }

    public void setCihazToken(String cihazToken) {
        this.cihazToken = cihazToken;
    }
}
