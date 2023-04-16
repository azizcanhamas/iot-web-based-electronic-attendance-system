package com.bitirme.web.Repository;

import com.bitirme.web.Entity.DersOgrencileri;
import com.bitirme.web.Entity.Yoklama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DersOgrencileriRepository  extends JpaRepository<DersOgrencileri,Long> {

    @Modifying
    @Transactional
    @Query("delete from DersOgrencileri do where do.ogrenciNo=:ogrenciNo and do.dersKodu=:dersKodu")
    void deleteByOgrenciNo(String ogrenciNo,String dersKodu);


    @Query("select count(*) from DersOgrencileri do where do.ogrenciNo=:ogrenciNo")
    public String getCountByOgrenciNo(String ogrenciNo);

    @Query("select do from DersOgrencileri do where do.dersKodu=:dersKodu and do.ogrenciNo=:ogrenciNo")
    public List<DersOgrencileri> findByDersKoduAndOgrenciNo(String dersKodu, String ogrenciNo);

    @Query("select do from DersOgrencileri do where do.ogrenciNo=:ogrenciNo")
    public List<DersOgrencileri> findByOgrenciNo(String ogrenciNo);

    @Query("select do from DersOgrencileri do where do.dersKodu=:dersKodu")
    public List<DersOgrencileri> findByDersKodu(String dersKodu);

}
