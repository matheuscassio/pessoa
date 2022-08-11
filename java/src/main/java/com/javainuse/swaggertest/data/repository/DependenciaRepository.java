package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.Dependencia;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface DependenciaRepository extends CrudRepository <Dependencia, Long> {

    @Query(value = " " +
            "select d " +
            "from Dependencia d ")
    Optional<ArrayList<Dependencia>> listAll();

    @Query(value = " " +
            "select d "+
            "from Dependencia d " +
            "where d.id = :id ")
    Optional<Dependencia> findById(@Param("idDependencia") String id);

    @Modifying
    @Query(value = " " +
            "update Dependencia m "+
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