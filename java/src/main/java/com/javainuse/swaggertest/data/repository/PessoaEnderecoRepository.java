package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.PessoaEndereco;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface PessoaEnderecoRepository extends CrudRepository <PessoaEndereco, Integer> {

    @Query(value = " " +
            "select pe " +
            "from PessoaEndereco pe ")
    Optional<ArrayList<PessoaEndereco>> listAll();

    @Query(value = " " +
            "select pe "+
            "from PessoaEndereco pe " +
            "where pe.id = :id")
    Optional<PessoaEndereco> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = " " +
            "update PessoaEndereco pe "+
            "set pe.nomeLogadouro = :nomeLogadouro, " +
            "    pe.nomeComplemento = :nomeComplemento, " +
            "    pe.nomeNumero = :nomeNumero, " +
            "    pe.nomeBairro = :nomeBairro, " +
            "    pe.nomeCep= :nomeCep " +
            "where pe.id = :id")
    Optional<PessoaEndereco> update(
            @Param("nomeLogadouro") Integer id,
            @Param("nomeLogadouro") String nomeLogadouro,
            @Param("nomeComplemento") String nomeComplemento,
            @Param("nomeNumero") String nomeNumero,
            @Param("nomeBairro") String nomeBairro,
            @Param("nomeCep") String nomeCep);

    @Query(value = " " +
            "INSERT INTO tb_pessoa_enderco (nm_Logadouro, nm_Complemento, nm_Numero, nm_Bairro, nm_CEP) " +
            "VALUES (:dataNascimento, :nomeLogadouro, :nomeComplemento, :nomeNumero, :nomeBairro, :nomeCep) ", nativeQuery = true)
    Optional<PessoaEndereco> insert(
    		@Param("nomeLogadouro") String nomeLogadouro,
            @Param("nomeComplemento") String nomeComplemento,
            @Param("nomeNumero") String nomeNumero,
            @Param("nomeBairro") String nomeBairro,
            @Param("nomeCep") String nomeCep);


}