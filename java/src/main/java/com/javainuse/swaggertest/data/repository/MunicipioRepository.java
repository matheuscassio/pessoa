package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.Municipio;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface MunicipioRepository extends CrudRepository <Municipio, Integer> {

    @Query(value = " " +
            "select m " +
            "from Municipio m ")
    Optional<ArrayList<Municipio>> listAll();

    @Query(value = " " +
            "select m "+
            "from Municipio m " +
            "where m.id = :id ")
    Optional<Municipio> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = " " +
            "update Municipio m "+
            "set m.nomeMunicipio = :nomeMunicipio " +
            "where m.id = :idMunicipio")
    Integer update(
            @Param("idMunicipio") Integer idMunicipio,
            @Param("nomeMunicipio") String nomeMunicipio);

    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_municipio (nm_Municipio) " +
            "VALUES (:nomeMunicipio) ", nativeQuery = true)
    Integer insert(@Param("nomeMunicipio") String nomeMunicipio);


}
