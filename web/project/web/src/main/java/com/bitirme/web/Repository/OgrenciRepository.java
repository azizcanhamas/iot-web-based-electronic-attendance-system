package com.bitirme.web.Repository;


import com.bitirme.web.Entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface OgrenciRepository extends JpaRepository<Ogrenci,Long> {
    @Query("SELECT o FROM Ogrenci o WHERE o.ogrenciNo = ?1")
    public Ogrenci findByOgrenciNo(String ogrenciNo);

    @Transactional
    @Modifying
    @Query("DELETE FROM Ogrenci o WHERE o.ogrenciNo = ?1")
    public void deleteByOgrenciNo(String ogrenciNo);

    @Query("select count(*) from Ogrenci")
    public int getOgrenciSayisi();

    @Query("select o.ad,o.soyad from Ogrenci o where o.ogrenciNo=:ogrenciNo")
    public String getOgrenciAdiSoyadi(String ogrenciNo);

    @Query("select o.sinifi from Ogrenci o where o.ogrenciNo=:ogrenciNo")
    public String getSinifByOgrenciNo(String ogrenciNo);

}
