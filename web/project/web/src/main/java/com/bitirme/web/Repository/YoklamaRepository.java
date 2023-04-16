package com.bitirme.web.Repository;

import com.bitirme.web.Entity.Yoklama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface YoklamaRepository extends JpaRepository<Yoklama,Long> {

    @Query("select y from Yoklama y where y.dersKodu=:dersKodu and y.dersTarihi LIKE :dersTarihi% and y.ogrenciNo=:ogrenciNo")
    public Yoklama findByDersKoduAndDersTarihiAndOgrenciNo(String dersKodu,String dersTarihi,String ogrenciNo);

    @Query("select y from Yoklama y where y.dersKodu=:dersKodu and y.ogrenciNo=:ogrenciNo")
    public List<Yoklama> findByDersKoduAndOgrenciNo(String dersKodu,String ogrenciNo);

    @Query("select count(*) from Yoklama y where y.ogrenciNo=:ogrenciNo and y.katilmaDurumu='YOK'")
    public String getDevamsizlikSayisiByOgrenciNo(String ogrenciNo);

    @Query("select count(*) from Yoklama y where y.ogrenciNo=:ogrenciNo and y.katilmaDurumu='YOK' and y.dersKodu=:dersKodu")
    public int getDevamsizlikSayisiByOgrenciNoAndDersKodu(String ogrenciNo,String dersKodu);
}
