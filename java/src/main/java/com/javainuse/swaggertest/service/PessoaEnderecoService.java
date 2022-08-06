package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.PessoaEnderecoRequest;
import org.springframework.stereotype.Component;

import com.javainuse.swaggertest.data.models.PessoaEndereco;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface PessoaEnderecoService {

    Optional<ArrayList<PessoaEndereco>> getAll() throws Exception;
    
    Integer update(Integer idPessoaEndereco, PessoaEnderecoRequest request) throws Exception;
    
    Integer insert(PessoaEnderecoRequest request) throws Exception;

    Optional<PessoaEndereco> findById(Integer idPessoaEndereco) throws Exception;

    Boolean deleteById(Integer idPessoaEndereco) throws Exception;

}