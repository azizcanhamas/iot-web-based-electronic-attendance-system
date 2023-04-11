package com.bitirme.web.Repository;

import com.bitirme.web.Entity.Sinif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface SinifRepository extends JpaRepository<Sinif,Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Sinif s WHERE s.sinifKodu = ?1")
    public void deleteBySinifKodu(String sinifKodu);
}
