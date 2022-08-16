package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.PessoaSituacao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface PessoaSituacaoRepository extends CrudRepository <PessoaSituacao, Integer> {

    @Query(value = " " +
            "select ps " +
            "from PessoaSituacao ps ")
    Optional<ArrayList<PessoaSituacao>> listAll();

    @Query(value = " " +
            "select ps "+
            "from PessoaSituacao ps " +
            "where ps.id = :id ")
    Optional<PessoaSituacao> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = " " +
            "update PessoaSituacao ps "+
            "set ps.dataSituacao = :dataSituacao," +
            "where ps.id = :id")
    Integer update(
            @Param("id") Integer id,
            @Param("dataSituacao") String dataSituacao);
    
    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_pessoa_situacao (dt_Situacao) " +
            "VALUES (:dataSituacao) ", nativeQuery = true)
    Integer insert(
             @Param("dataSituacao") String dataSituacao);




}
