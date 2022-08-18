package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.TipoGeralFiltro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface TipoGeralFiltroRepository extends CrudRepository <TipoGeralFiltro, Integer> {

    @Query(value = " " +
            "select tf " +
            "from TipoGeralFiltro tf ")
    Optional<ArrayList<TipoGeralFiltro>> listAll();

    @Query(value = " " +
            "select tf "+
            "from TipoGeralFiltro tf " +
            "where tf.id = :id ")
    Optional<TipoGeralFiltro> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = " " +
            "update TipoGeralFiltro tf "+
            "set tf.nomeFiltro = :nomeFiltro " +
            "where tf.id = :idTipogeralFiltro")
    Integer update(
            @Param("idTipogeralFiltro") Integer idTipogeralFiltro,
            @Param("nomeFiltro") String nomeFiltro);

    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_Tiogeral_Filtro (nm_Filtro) " +
            "VALUES (:nomeFiltro) ", nativeQuery = true)
    Integer insert(@Param("nomeFiltro") String nomeFiltro);


}
