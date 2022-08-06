package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.PessoaContatoRequest;
import com.javainuse.swaggertest.data.playloads.request.PessoaDocumentoRequest;
import org.springframework.stereotype.Component;

import com.javainuse.swaggertest.data.models.PessoaContato;
import com.javainuse.swaggertest.data.models.PessoaDocumento;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Component
public interface PessoaDocumentoService {

Optional<ArrayList<PessoaDocumento>> getAll() throws Exception;
    
    Optional<PessoaDocumento> update(Integer idPessoaDocumento, PessoaContatoRequest request) throws Exception;
    
    Optional deleteByid(Integer idPessoaDocumento, PessoaContatoRequest request)throws Exception;
    
    Optional<PessoaContato> insert(PessoaDocumentoRequest request) throws Exception;

}