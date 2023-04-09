package com.bitirme.web.Repository;


import com.bitirme.web.Entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OgrenciRepository extends JpaRepository<Ogrenci,Long> {
}
