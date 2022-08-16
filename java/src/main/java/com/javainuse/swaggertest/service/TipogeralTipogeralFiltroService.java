
package com.javainuse.swaggertest.service;

import org.springframework.stereotype.Component;

import com.javainuse.swaggertest.data.models.TipogeralTipogeralFiltro;
import com.javainuse.swaggertest.data.playloads.request.TipogeralTipogeralFiltroRequest;
import java.util.Optional;

@Component
public interface TipogeralTipogeralFiltroService {

    Integer update(Integer idTipogeralTipogeralFiltro, TipogeralTipogeralFiltroRequest request) throws Exception;

    Boolean deleteById(Integer idTipogeralTipogeralFiltro) throws Exception;

    Optional<TipogeralTipogeralFiltro> findById(Integer idTipogeralTipogeralFiltro) throws Exception;

    Integer insert(TipogeralTipogeralFiltroRequest tipogeralTipogeralFiltro) throws Exception;

}


