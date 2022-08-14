package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.Dependencia;
import com.javainuse.swaggertest.data.playloads.request.DependenciaRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DependenciaRepository extends CrudRepository <Dependencia, Integer> {

    @Query(value = " " +
            "select d "+
            "from Dependencia d " +
            "where d.idDependencia = :idDependencia ")
    Optional<Dependencia> findById(@Param("idDependencia") Integer idDependencia);

    @Modifying
    @Query(value = " " +
            "update Dependencia d "+
            "set d.pessoa.id = :idPessoa," +
            "    d.pessoaDependente.id = :idPessoaDependente," +
            "    d.tipoDependencia.id = :idTipoDependencia " +
            "where d.idDependencia = :idDependencia")
    Integer update(
            @Param("idDependencia") Integer idDependencia,
            @Param("idPessoa") Integer idPessoa,
            @Param("idPessoaDependente") Integer idPessoaDependente,
            @Param("idTipoDependencia") Integer idTipoDependencia);

    @Modifying
    @Query(value = " " +
            "INSERT INTO tb_dependencia (id_Pessoa, id_Pessoa_Dependente, id_Tipo_Depencia) " +
            "VALUES (:idPessoa, :idPessoaDependente, :idTipoDependencia) ", nativeQuery = true)
    Integer insert(
            @Param("idPessoa") Integer idPessoa,
            @Param("idPessoaDependente") Integer idPessoaDependente,
            @Param("idTipoDependencia") Integer idTipoDependencia);


}
