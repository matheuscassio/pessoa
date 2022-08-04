package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    @Query(value = " " +
            "update Pessoa p "+
            "set p.dataNascimento = :dataNascimento, " +
            "    p.nomeMae = :nomeMae " +
            "where p.hash = :hash")
    Optional<Pessoa> updatePessoa(
            @Param("nomeMae") String nomeMae,
            @Param("dataNascimento") String dataNascimento);

}
