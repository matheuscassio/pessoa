package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.PessoaContatoRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.PessoaContato;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Component
public interface PessoaContatoService {

    Optional<ArrayList<PessoaContato>> getAll() throws Exception;
    
    Optional<PessoaContato> update(Integer idPessoaContato, PessoaContatoRequest request) throws Exception;
    
    Optional deleteByid(Integer idPessoaContato, PessoaContatoRequest request)throws Exception;
    
    Optional<PessoaContato> insert(PessoaContatoRequest request) throws Exception;
 
}