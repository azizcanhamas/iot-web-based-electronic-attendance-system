package com.bitirme.web.Repository;

import com.bitirme.web.Entity.Cihaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CihazRepository extends JpaRepository<Cihaz,Long> {

    @Transactional
    @Modifying
    @Query("delete from Cihaz c where c.sinifKodu=?1")
    public void deleteBySinifKodu(String sinifKodu);

    @Query("SELECT c FROM Cihaz c WHERE c.sinifKodu = ?1")
    public Cihaz findBySinifKodu(String sinifKodu);

    @Query("SELECT c.sinifKodu FROM Cihaz c WHERE c.cihazToken = ?1")
    public String getSinifKoduByCihazToken(String sinifKodu);


}
