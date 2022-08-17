package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.TipoGeral;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface TipoGeralRepository extends CrudRepository <TipoGeral, Integer> {

    @Query(value = " " +
            "select tg " +
            "from TipoGeral tg ")
    Optional<ArrayList<TipoGeral>> listAll();

    @Query(value = " " +
            "select tg "+
            "from TipoGeral tg " +
            "where tg.id = :id ")
    Optional<TipoGeral> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = " " +
            "update TipoGeral tg "+
            "set tg.nomeTipoGeral = :nomeTipoGeral, " +
            "    tg.nomeFiltro = :nomeFiltro " +
            "    tg.situacaoPadrao = :situacaoPadrao " +
            "    tg.textoParametro = :textoParametro " +
            "where tg.id = :id")
    
    Integer update(
            @Param("id") Integer id,
            @Param("nomeTipoGeral") String nomeTipoGeral,
            @Param("nomeFiltro") String nomeFiltro,
    		@Param("situacaoPadrao") String situacaoPadrao,
    		@Param("textoParametro") String textoParametro);
    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_tipogeral (nm_Tipo_Geral, nm_Filtro, st_Padrao, tx_Parametro) " +
            "VALUES (:nomeTipoGeral, :nomeFiltro, :situacaoPadrao, :textoParametro) ", nativeQuery = true)
    Integer insert(
            @Param("nomeTipoGeral") String nomeTipoGeral,
            @Param("nomeFiltro") String nomeFiltro,
    		@Param("situacaoAtivo") String situacaoPadrao,
    		@Param("nomeFiltro") String textoParametro);


}
