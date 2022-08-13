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
public interface PessoaContatoRepository extends CrudRepository <PessoaContato, Integer> {

    @Query(value = " " +
            "select pc " +
            "from PessoaContato pc ")
    Optional<ArrayList<PessoaContato>> listAll();

    @Query(value = " " +
            "select pc "+
            "from PessoaContato pc " +
            "where pc.id = :id ")
    Optional<PessoaContato> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = " " +
            "update PessoaContato pc "+
            "set pc.nomeContato = :nomeContato, " +
            "    pc.descricaoContato = :descricaoContato " +
            "where pc.id = :id")
    Integer update(
            @Param("id") Integer id,
            @Param("nomeContato") String nomeContato,
            @Param("descricaoContato") String descricaoContato);
    
    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_pessoa_contato (id_Pessoa, nm_Contato, ds_Contato) " +
            "VALUES (:idPessoa, :nomeContato, :descricaoContato) ", nativeQuery = true)
    Integer insert(
            @Param("idPessoa") Integer idPessoa,
            @Param("nomeContato") String nomeContato,
            @Param("descricaoContato") String descricaoContato);


}