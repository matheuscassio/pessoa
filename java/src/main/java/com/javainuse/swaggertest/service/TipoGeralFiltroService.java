package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.TipoGeralFiltroRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.TipoGeralFiltro;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface TipoGeralFiltroService {

    Optional<ArrayList<TipoGeralFiltro>> getAll() throws Exception;
    
    Integer update(Integer idTipogeralFiltro, TipoGeralFiltroRequest request) throws Exception;
    
    Integer insert(TipoGeralFiltroRequest request) throws Exception;

    Optional<TipoGeralFiltro> findById(Integer idTipogeralFiltro) throws Exception;

    Boolean deleteById(Integer idTipogeralFiltro) throws Exception;
}