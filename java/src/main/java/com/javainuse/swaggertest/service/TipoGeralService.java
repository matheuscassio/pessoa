package com.javainuse.swaggertest.service;


import com.javainuse.swaggertest.data.playloads.request.TipoGeralRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.TipoGeral;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface TipoGeralService {

    Optional<ArrayList<TipoGeral>> getAll() throws Exception;
    
    Integer update(Integer idTipoGeral, TipoGeralRequest request) throws Exception;
    
    Integer insert(TipoGeralRequest request) throws Exception;

    Optional<TipoGeral> findById(Integer idTipoGeral) throws Exception;

    Boolean deleteById(Integer idTipoGeral) throws Exception;
}

