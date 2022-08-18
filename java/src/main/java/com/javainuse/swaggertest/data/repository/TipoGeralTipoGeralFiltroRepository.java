package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.TipoGeralTipoGeralFiltro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TipoGeralTipoGeralFiltroRepository extends CrudRepository <TipoGeralTipoGeralFiltro, Integer> {

    @Query(value = " " +
            "select ttf "+
            "from TipoGeralTipoGeralFiltro ttf " +
            "where ttf.idTipoGeralTipoGeralFiltro = :idTipoGeralTipoGeralFiltro ")
    Optional<TipoGeralTipoGeralFiltro> findById(@Param("idTipoGeralTipoGeralFiltro") Integer idTipoGeralTipoGeralFiltro);

    @Modifying
    @Query(value = " " +
            "update TipoGeralTipoGeralFiltro ttf "+
            "set ttf.tipoGeral.id = :idTipoGeral, " +
            "    ttf.tipoGeralFiltro.id = :idTipoGeralFiltro " +
            "where ttf.idTipoGeralTipoGeralFiltro = :idTipoGeralTipoGeralFiltro")
    Integer update(
            @Param("idTipoGeralTipoGeralFiltro") Integer idTipoGeralTipoGeralFiltro,
            @Param("idTipoGeral") Integer idTipoGeral,
            @Param("idTipoGeralFiltro") Integer idTipoGeralFiltro);

    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_TipoGeral_TipoGeral_Filtro (idTipoGeral, idTipoGeralFiltro) " +
            "VALUES (:idTipoGeral, :idTipoGeralFiltro) ", nativeQuery = true)
    Integer insert(
            @Param("idTipoGeral") Integer idTipoGeral,
            @Param("idTipoGeralFiltro") Integer idTipoGeralFiltro);


}
