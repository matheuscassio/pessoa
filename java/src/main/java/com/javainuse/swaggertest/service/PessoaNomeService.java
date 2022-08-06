package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.PessoaNomeRequest;
import org.springframework.stereotype.Component;

import com.javainuse.swaggertest.data.models.PessoaNome;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Component
public interface PessoaNomeService {

    Optional<ArrayList<PessoaNome>> getAll() throws Exception;
    
    Optional<PessoaNome> update(Integer idPessoaNome, PessoaNomeRequest request) throws Exception;
    
    Optional<PessoaNome> insert(PessoaNomeRequest request) throws Exception;

    Boolean deleteById(Integer idPessoaNome) throws Exception;

    Optional<PessoaNome> findById(Integer idPessoaNome) throws Exception;
}
