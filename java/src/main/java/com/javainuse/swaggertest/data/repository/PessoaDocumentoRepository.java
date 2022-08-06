package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.PessoaDocumento;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface PessoaDocumentoRepository extends CrudRepository <PessoaDocumento, Integer> {

    @Query(value = " " +
            "select pd " +
            "from PessoaDocumento pd ")
    Optional<ArrayList<PessoaDocumento>> listAll();

    @Query(value = " " +
            "select pd "+
            "from PessoaDocumento pd " +
            "where pd.id = :id ")
    Optional<PessoaDocumento> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = " " +
            "update PessoaDocumento pd "+
            "set pd.valorDocumento= :valorDocumento, " +
            "    pd.dataEmissao = :dataEmissao, " +
            "    pd.nomeOrgaoEmissor = :nomeOrgaoEmissor, " +
            "    pd.descricaoSerie= :descricaoSerie " +
            "where pd.id = :id")
    Integer update(
            @Param("id") Integer id,
            @Param("valorDocumento") String valorDocumento,
            @Param("dataEmissao") String dataEmissao,
    		@Param("nomeOrgaoEmissor") String nomeOrgaoEmissor,
    		@Param("descricaoSerie") String descricaoSerie);
    
    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_pessoa_documento (vr_Documento, dt_Emissao, nm_OrgaoEmissor, ds_Serie) " +
            "VALUES (:valorDocumento, :dataEmissao, :nomeOrgaoEmissor, :descricaoSerie) ", nativeQuery = true)
    Integer insert(
    		 @Param("valorDocumento") String valorDocumento,
             @Param("dataEmissao") String dataEmissao,
			 @Param("nomeOrgaoEmissor") String nomeOrgaoEmissor,
			 @Param("descricaoSerie") String descricaoSerie);




}
