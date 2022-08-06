package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.PessoaNome;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface PessoaNomeRepository extends CrudRepository <PessoaNome, Long> {

    @Query(value = " " +
            "select pn " +
            "from PessoaNome pn ")
    Optional<ArrayList<PessoaNome>> listAll();

    @Query(value = " " +
            "select pn "+
            "from PessoaNome pn " +
            "where pn.id = :id ")
    Optional<PessoaNome> findById(@Param("id") String id);

    @Modifying
    @Query(value = " " +
            "update PessoaNome pn "+
            "set pn.nomePessoa = :nomePessoa, " +
            "where pn.id = :id")
    Optional<PessoaNome> update(
            @Param("nomePessoa") String nomePessoa);

    @Query(value = " " +
            "INSERT INTO tb_Pessoa_Nome (nomePessoa) " +
            "VALUES (:nomePessoa) ", nativeQuery = true)
    Optional<PessoaNome> insert(
            @Param("nomePessoa") String nomePessoa);


}