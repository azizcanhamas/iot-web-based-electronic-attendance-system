package com.bitirme.web.Repository;

import com.bitirme.web.Entity.Akademisyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface AkademisyenRepository  extends JpaRepository<Akademisyen,Long> {
    @Query("SELECT a FROM Akademisyen a WHERE a.personelNo = ?1")
    public Akademisyen findByPersonelNo(String personelNo);

    @Transactional
    @Modifying
    @Query("DELETE FROM Akademisyen a WHERE a.personelNo = ?1")
    public void deleteByPersonelNo(String personelNo);

    @Query("select a.unvan, a.ad, a.soyad from Akademisyen a where a.personelNo=?1")
    public List<String> getPersonelNameandSurname(String personelNo);
}
