package com.javainuse.swaggertest.data.repository;

import com.javainuse.swaggertest.data.models.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository <Pessoa, Long> {

    //Optional<Pessoa> findByHash(final String hash);
    //ArrayList<Pessoa> listarPessoas();
    //ArrayList<Optional <Pessoa>> findByNomeMae(final String nome);

}
