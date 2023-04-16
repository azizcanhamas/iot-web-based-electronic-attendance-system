package com.bitirme.web.Repository;

import com.bitirme.web.Entity.Ders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;

public interface DersRepository extends JpaRepository<Ders,Long> {

    @Modifying
    @Transactional
    @Query("delete from Ders d where d.dersKodu=?1")
    public void deleteByDersKodu(String dersKodu);


    @Query("select d from Ders d where d.dersKodu=?1")
    public Ders findByDersKodu(String dersKodu);

    @Query("select count(*) from Ders")
    public int getDersSayisi();

    @Query("select d.dersAdi from Ders d where d.dersKodu=:dersKodu")
    public String getDersAdiByDersKodu(String dersKodu);


    @Query("select d from Ders d where sinifKodu=:sinifKodu and dersGunu=:dersGunu and dersSaati=:dersSaati")
    public Ders getCurrentLesson(String sinifKodu,String dersGunu,String dersSaati);
}
