package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.PessoaDocumentoRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.PessoaDocumento;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface PessoaDocumentoService {

    Optional<ArrayList<PessoaDocumento>> getAll() throws Exception;
    
    Integer update(Integer idPessoaDocumento, PessoaDocumentoRequest request) throws Exception;
    
    Integer insert(PessoaDocumentoRequest request) throws Exception;

    Optional<PessoaDocumento> findById(Integer idPessoaDocumento) throws Exception;

    Boolean deleteById(Integer idPessoaDocumento) throws Exception;

	
}