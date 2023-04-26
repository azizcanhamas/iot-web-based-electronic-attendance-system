package com.bitirme.web.Repository;

import com.bitirme.web.Entity.Ders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

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

    @Query("select d from Ders d where d.sinifKodu=:sinifKodu and d.dersGunu=:dersGunu and d.dersSaati LIKE :dersSaati%")
    public Ders getCurrentLesson(String sinifKodu,String dersGunu,String dersSaati);

    @Query("select d from Ders d where dersGunu=:dersGunu")
    public List<Ders> findByDersGunu(String dersGunu);
}
