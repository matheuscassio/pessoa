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
public interface MunicipioRepository extends CrudRepository <Municipio, Long> {

    @Query(value = " " +
            "select m " +
            "from Municipio m ")
    Optional<ArrayList<Municipio>> listAll();

    @Query(value = " " +
            "select m "+
            "from Municipio m " +
            "where m.id = :id ")
    Optional<Municipio> findById(@Param("id") String id);

    @Modifying
    @Query(value = " " +
            "update Municipio m "+
            "set m.nomeMunicipio = :nomeMunicipio, " +
            "where m.id = :id")
    Optional<Municipio> update(
            @Param("nomeMunicipio") String nomeMunicipio);

    @Query(value = " " +
            "INSERT INTO tb_Municipio (nm_Municipio) " +
            "VALUES (:nomeMunicipio) ", nativeQuery = true)
    Optional<Municipio> insert(
            @Param("nomeMunicipio") String nomeMunicipio);


}
