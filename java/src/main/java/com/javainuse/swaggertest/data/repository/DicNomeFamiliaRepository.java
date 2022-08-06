package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.DicNomeFamilia;

import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface DicNomeFamiliaRepository extends CrudRepository <DicNomeFamilia, Long> {

    @Query(value = " " +
            "select dmf " +
            "from DicNomeFamilia dmf ")
    Optional<ArrayList<DicNomeFamilia>> listAll();

    @Query(value = " " +
            "select dmf "+
            "from DicNomeFamilia pd " +
            "where dmf.id = :id ")
    Optional<DicNomeFamilia> findById(@Param("idDicNomeFamilia") String id);

    @Modifying
    @Query(value = " " +
            "update DicNomeFamilia dmf "+
            "set dmf.textoNomeFamilia= :textoNomeFamilia, " +
            "where dmf.id = :id")
    Integer update(
            @Param("id") String id,
            @Param("textoNomeFamilia") String textoNomeFamilia);

    @Query(value = " " +
            "INSERT INTO tb_dicNomeFamilia (tx_NomeFamilia) " +
            "VALUES (:textoNomeFamilia) ", nativeQuery = true)
    Integer insert(
    		 @Param("textoNomeFamilia") String valorDocumento);




}