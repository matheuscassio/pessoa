package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.TipoGeralTipoGeralFiltro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TipogeralTipogeralFiltroRepository extends CrudRepository <TipoGeralTipoGeralFiltro, Integer> {

    @Query(value = " " +
            "select d "+
            "from TipoGeralTipoGeralFiltro ttf " +
            "where ttf.idTipogeralTipogeralFiltro = :idTipogeralTipogeralFiltro ")
    Optional<TipoGeralTipoGeralFiltro> findById(@Param("idTipogeralTipogeralFiltro") Integer idTipogeralTipogeralFiltro);

    @Modifying
    @Query(value = " " +
            "update TipoGeralTipoGeralFiltro ttf "+
            "set ttf.tipoGeral.id = :idTipoGeral," +
            "    ttf.tipoGeralFiltro.id = :idTipoGeral," +
            "where ttf.idTipogeralTipogeralFiltro = :idTipogeralTipogeralFiltro")
    Integer update(
            @Param("idTipogeralTipogeralFiltro") Integer idTipogeralTipogeralFiltro,
            @Param("idTipoGeral") Integer idTipoGeral,
            @Param("idTipogeralFiltro") Integer idTipogeralFiltro);

    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_Tipogeral_Tipogeral_Filtro (id_Tipo_Geral, id_Tipogeral_Filtro) " +
            "VALUES (:idTipoGeral, :idTipogeralFiltro) ", nativeQuery = true)
    Integer insert(
            @Param("idTipoGeral") Integer idPessoa,
            @Param("idTipogeralFiltro") Integer idPessoaDependente);


}
