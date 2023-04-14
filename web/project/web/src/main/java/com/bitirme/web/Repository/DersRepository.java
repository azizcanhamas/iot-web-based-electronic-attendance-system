package com.bitirme.web.Repository;

import com.bitirme.web.Entity.Ders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DersRepository extends JpaRepository<Ders,Long> {

    @Modifying
    @Transactional
    @Query("delete from Ders d where d.dersKodu=?1")
    public void deleteByDersKodu(String dersKodu);


    @Query("select d from Ders d where d.dersKodu=?1")
    public Ders findByDersKodu(String dersKodu);

    @Query("select count(*) from Ders")
    public int getDersSayisi();
}
