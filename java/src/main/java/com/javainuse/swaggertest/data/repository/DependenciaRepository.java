package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.Dependencia;
import com.javainuse.swaggertest.data.models.TipoGeral;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DependenciaRepository extends CrudRepository <Dependencia, Integer> {

    /*@Query(value = " " +
            "select d " +
            "from Dependencia d ")
    Optional<ArrayList<Dependencia>> listAll();*/

    @Query(value = " " +
            "select d "+
            "from Dependencia d " +
            "where d.id = :id ")
    Optional<Dependencia> findById(@Param("idDependencia") Integer id);

    @Modifying
    @Query(value = " " +
            "update Dependencia d "+
            "set d.tipoDependicia = :tipoDependencia " +
            "where d.id = :idDependencia")
    Integer update(
            @Param("idDependencia") Integer idDependencia,
            @Param("tipoDependencia") Integer tipoGeral);

    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_dependencia (tipoDepencia) " +
            "VALUES (:tipoDependencia) ", nativeQuery = true)
    Integer insert(@Param("tipoDependencia") Integer tipoDependencia);


}