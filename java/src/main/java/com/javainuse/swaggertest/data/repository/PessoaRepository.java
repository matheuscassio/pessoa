package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.Pessoa;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface PessoaRepository extends CrudRepository <Pessoa, Long> {

    @Query(value = " " +
            "select p " +
            "from Pessoa p ")
    Optional<ArrayList<Pessoa>> listAll();

    @Query(value = " " +
            "select p "+
            "from Pessoa p " +
            "where p.hash = :hash ")
    Optional<Pessoa> findByHash(@Param("hash") String hash);

    @Modifying
    @Query(value = " " +
            "update Pessoa p "+
            "set p.dataNascimento = :dataNascimento, " +
            "    p.nomeGenitor = :nomeGenitor " +
            "where p.hash = :hash")
    Integer update(
            @Param("hash") String hash,
            @Param("nomeGenitor") String nomeGenitor,
            @Param("dataNascimento") Date dataNascimento);

    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_pessoa (dt_nascimento, nm_Genitor) " +
            "VALUES (:dataNascimento, :nomeGenitor) ", nativeQuery = true)
    Integer insert(
            @Param("nomeGenitor") String nomeMae,
            @Param("dataNascimento") Date dataNascimento);


}
