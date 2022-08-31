package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.DicNomeFamilia;


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
            "select dnf " +
            "from DicNomeFamilia dnf ")
    Optional<ArrayList<DicNomeFamilia>> listAll();

    @Query(value = " " +
            "select dnf "+
            "from DicNomeFamilia dnf " +
            "where dnf.id = :idDicNomeFamilia ")
    Optional<DicNomeFamilia> findById(@Param("idDicNomeFamilia") Integer idDicNomeFamilia);

    @Modifying
    @Query(value = " " +
            "update DicNomeFamilia dnf "+
            "set dnf.nomeFamilia = :textoNomeFamilia " +
            "where dnf.id = :id ")
    Integer update(
            @Param("id") Integer id,
            @Param("textoNomeFamilia") String textoNomeFamilia);

    @Query(value = " " +
            "INSERT INTO tb_dicNomeFamilia (tx_Nome_Familia) " +
            "VALUES (:textoNomeFamilia) ", nativeQuery = true)
    Integer insert(
    		 @Param("textoNomeFamilia") String textoNomeFamilia);




}