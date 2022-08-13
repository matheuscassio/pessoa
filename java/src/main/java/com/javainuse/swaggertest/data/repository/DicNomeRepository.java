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
            "select dn " +
            "from DicNome dn ")
    Optional<ArrayList<DicNome>> listAll();

    @Query(value = " " +
            "select dn "+
            "from DicNome dn " +
            "where dn.id = :idDicNome ")
    Optional<DicNome> findById(@Param("idDicNome") Integer id);

    @Modifying
    @Query(value = " " +
            "update DicNome dn "+
            "set dn.nome = :dicNome " +
            "where dn.id = :id")
    Integer update(
            @Param("id") Integer id,
            @Param("dicNome") String dicNome);

    @Query(value = " " +
            "INSERT INTO tb_dicNome (nome) " +
            "VALUES (:textoDicNome) ", nativeQuery = true)
    Integer insert(
    		 @Param("textoDicNome") String textoDicNome);


}
