package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.PessoaRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.Pessoa;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface PessoaService {

    Optional<ArrayList<Pessoa>> getAll() throws Exception;

    Optional<Pessoa> findByHash(String hash) throws Exception;

    Integer update(String hash, PessoaRequest request) throws Exception;

    Boolean deleteByHash(String hash) throws Exception;

    Integer insert(PessoaRequest request) throws Exception;

}
