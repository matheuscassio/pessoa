package com.javainuse.swaggertest.repositories;

import com.javainuse.swaggertest.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PessoaRepository extends CrudRepository <Pessoa, Long> {

    Optional<Pessoa> findByHash(final String hash);

    //ArrayList<Pessoa> listarPessoas();

    ArrayList<Optional <Pessoa>> findByNomeMae(final String nome);

}
