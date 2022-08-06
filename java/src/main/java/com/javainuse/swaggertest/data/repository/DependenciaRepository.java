package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.Dependencia;
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
            "from PessoaDocumento d " +
            "where d.id = :id ")
    Optional<Dependencia> findById(@Param("idDependencia") String id);

    




}