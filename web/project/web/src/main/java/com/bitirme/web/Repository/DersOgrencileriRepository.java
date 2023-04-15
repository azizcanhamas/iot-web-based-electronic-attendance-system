package com.bitirme.web.Repository;

import com.bitirme.web.Entity.DersOgrencileri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DersOgrencileriRepository  extends JpaRepository<DersOgrencileri,Long> {

    @Modifying
    @Transactional
    @Query("delete from DersOgrencileri do where do.ogrenciNo=:ogrenciNo and do.dersKodu=:dersKodu")
    void deleteByOgrenciNo(String ogrenciNo,String dersKodu);


    @Query("select count(*) from DersOgrencileri do where do.ogrenciNo=:ogrenciNo")
    public String getCountByOgrenciNo(String ogrenciNo);
}
