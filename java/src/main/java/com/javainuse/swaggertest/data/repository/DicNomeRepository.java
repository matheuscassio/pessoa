package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.DicNome;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface DicNomeRepository extends CrudRepository <DicNome, Long> {

    @Query(value = " " +
            "select dm " +
            "from DicNome dm ")
    Optional<ArrayList<DicNome>> listAll();

    @Query(value = " " +
            "select dm "+
            "from DicNome dm" +
            "where dm.id = :id ")
    Optional<DicNome> findById(@Param("idDicNome") String id);

    @Modifying
    @Query(value = " " +
            "update DicNome dm "+
            "set dm.DicNome= :textoDicNome, " +
            "where pd.id = :id")
    Integer update(
            @Param("id") String id,
            @Param("textoNome") String textoNome);

    @Query(value = " " +
            "INSERT INTO tb_dicNome (tx_DicNome, ) " +
            "VALUES (:textoDicNome, ) ", nativeQuery = true)
    Integer insert(
    		 @Param("textoDocumento") String textoDocumento);


}
