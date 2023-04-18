package com.stc.petlove.repositories;

import com.stc.petlove.entities.LoaiThuCung;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoaiThuCungRepository extends MongoRepository<LoaiThuCung,String> {
    @Query(value = "{'maLoaiThuCung': ?0}", exists = true)
    Boolean kiemtraMaLoaiThuCung(String maLoaiThuCung);
}
