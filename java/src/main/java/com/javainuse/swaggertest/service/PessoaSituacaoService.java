package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.PessoaSituacaoRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.PessoaSituacao;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface PessoaSituacaoService {

    Optional<ArrayList<PessoaSituacao>> getAll() throws Exception;
    
    Integer update(Integer idPessoaSituacao, PessoaSituacaoRequest request) throws Exception;
    
    Integer insert(PessoaSituacaoRequest request) throws Exception;

    Optional<PessoaSituacao> findById(Integer idPessoaSituacao) throws Exception;

    Boolean deleteById(Integer idPessoaSituacao) throws Exception;

	
}