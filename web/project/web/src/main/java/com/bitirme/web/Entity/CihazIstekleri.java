package com.bitirme.web.Entity;


import javax.persistence.*;

@Entity
@Table(name="CihazIstekleri")
public class CihazIstekleri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cihaz_token")
    private String cihazToken;

    @Column(name = "rfid_kodu")
    private String rfidKodu;

    @Column(name="istek_zamani")
    private String istekZamani;

    @Column(name="sinif_kodu")
    private String sinifKodu;

    @Column(name="ders_kodu")
    private String dersKodu;

    @Column(name="personel_no")
    private String personelNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCihazToken() {
        return cihazToken;
    }

    public void setCihazToken(String cihazToken) {
        this.cihazToken = cihazToken;
    }

    public String getRfidKodu() {
        return rfidKodu;
    }

    public void setRfidKodu(String rfidKodu) {
        this.rfidKodu = rfidKodu;
    }

    public String getIstekZamani() {
        return istekZamani;
    }

    public void setIstekZamani(String istekZamani) {
        this.istekZamani = istekZamani;
    }

    public String getSinifKodu() {
        return sinifKodu;
    }

    public void setSinifKodu(String sinifKodu) {
        this.sinifKodu = sinifKodu;
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public String getPersonelNo() {
        return personelNo;
    }

    public void setPersonelNo(String personelNo) {
        this.personelNo = personelNo;
    }
}
