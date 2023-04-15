package com.bitirme.web.Entity;


import javax.persistence.*;

@Entity
@Table(name="DersOgrencileri")
public class DersOgrencileri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ders_kodu")
    private String dersKodu;

    @Column(name="ogrenci_no")
    private String ogrenciNo;

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

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }
}
