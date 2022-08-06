package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.PessoaContato;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface PessoaContatoRepository extends CrudRepository <PessoaContato, Long> {

    @Query(value = " " +
            "select pc " +
            "from PessoaContato pc ")
    Optional<ArrayList<PessoaContato>> listAll();

    @Query(value = " " +
            "select pc "+
            "from PessoaContato pc " +
            "where pc.id = :id ")
    Optional<PessoaContato> findById(@Param("id") String hash);

    @Modifying
    @Query(value = " " +
            "update PessoaContato pc "+
            "set pc.nomeContato = :nomeContato, " +
            "    pc.descricaoContato = :descricaoContato " +
            "where pc.id = :id")
    Optional<PessoaContato> update(
            @Param("nomeContato") String nomeContato,
            @Param("descricaoContato") String descricaoContato);
           

    @Query(value = " " +
            "INSERT INTO tb_Pessoa_Contato (nm_Contato, ds_Contato) " +
            "VALUES ( :nomeContato, :descricaoContato) ", nativeQuery = true)
    Optional<PessoaContato> insert(
            @Param("nomeContato") String nomeContato,
            @Param("descricaoContato") Date descricaoContato);


}