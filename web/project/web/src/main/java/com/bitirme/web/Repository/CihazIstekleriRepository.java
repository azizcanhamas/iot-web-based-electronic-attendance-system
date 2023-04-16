package com.bitirme.web.Repository;

import com.bitirme.web.Entity.CihazIstekleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CihazIstekleriRepository extends JpaRepository<CihazIstekleri,Long> {

    @Query("select ci from CihazIstekleri ci where rfidKodu=:rfidKodu and dersKodu=:dersKodu")
    public CihazIstekleri findByRFIDandDersKodu(String rfidKodu,String dersKodu);

}
