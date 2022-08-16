package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.TipogeralFiltroRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.TipogeralFiltro;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface TipogeralFiltroService {

    Optional<ArrayList<TipogeralFiltro>> getAll() throws Exception;
    
    Integer update(Integer idTipogeralFiltro, TipogeralFiltroRequest request) throws Exception;
    
    Integer insert(TipogeralFiltroRequest request) throws Exception;

    Optional<TipogeralFiltro> findById(Integer idTipogeralFiltro) throws Exception;

    Boolean deleteById(Integer idTipogeralFiltro) throws Exception;
}