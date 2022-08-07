package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.MunicipioRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.Municipio;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface MunicipioService {

    Optional<ArrayList<Municipio>> getAll() throws Exception;
    
    Integer update(Integer idMunicipio, MunicipioRequest request) throws Exception;
    
    Integer insert(MunicipioRequest request) throws Exception;

    Optional<Municipio> findById(Integer idMunicipio) throws Exception;

    Boolean deleteById(Integer idMunicipio) throws Exception;
}