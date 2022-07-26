package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.PessoaContatoRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.PessoaContato;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface PessoaContatoService {

    Optional<ArrayList<PessoaContato>> getAll() throws Exception;
    
    Integer update(Integer idPessoaContato, PessoaContatoRequest request) throws Exception;

    Boolean deleteById(Integer idPessoaContato) throws Exception;

    Integer insert(PessoaContatoRequest request) throws Exception;

    Optional<PessoaContato> findById(Integer idPessoaContato) throws Exception;

}