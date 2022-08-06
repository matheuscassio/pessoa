package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.PessoaContatoRequest;
import com.javainuse.swaggertest.data.playloads.request.TipoGeralRequest;
import org.springframework.stereotype.Component;

import com.javainuse.swaggertest.data.models.PessoaContato;
import com.javainuse.swaggertest.data.models.TipoGeral;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Component
public interface TipoGeralService {

    Optional<ArrayList<TipoGeral>> getAll() throws Exception;
    
    Optional<TipoGeral> update(Integer idTipoGeral, TipoGeralRequest request) throws Exception;
    
    Optional deleteByid(Integer idTipoGeral, TipoGeralRequest request)throws Exception;
    
    Optional<TipoGeral> insert(TipoGeralRequest request) throws Exception;
 
}

