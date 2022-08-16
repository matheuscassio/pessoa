package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.TipogeralFiltro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface TipogeralFiltroRepository extends CrudRepository <TipogeralFiltro, Integer> {

    @Query(value = " " +
            "select tf " +
            "from TipogeralFiltro tf ")
    Optional<ArrayList<TipogeralFiltro>> listAll();

    @Query(value = " " +
            "select tf"+
            "from TipogeralFiltro tf " +
            "where tf.id = :id ")
    Optional<TipogeralFiltro> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = " " +
            "update TipogeralFiltro tf "+
            "set tf.nomeFiltro = :nomeFiltro " +
            "set tf.textoParametro = :textoParametro " +
            "where tf.id = :idTipogeralFiltro")
    Integer update(
            @Param("idTipogeralFiltro") Integer idTipogeralFiltro,
            @Param("nomeFiltro") String nomeFiltro,
    		@Param("textoParametro") String textoParametro);

    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_Tiogeral_Filtro (nm_Filtro) " +
            "VALUES (:nomeFiltro) ", nativeQuery = true)
    Integer insert(@Param("nomeFiltro") String nomeFiltro,
    		@Param("textoParametro") String textoParametro);


}
