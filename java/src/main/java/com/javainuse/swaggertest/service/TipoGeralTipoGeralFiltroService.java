
package com.javainuse.swaggertest.service;

import org.springframework.stereotype.Component;

import com.javainuse.swaggertest.data.models.TipoGeralTipoGeralFiltro;
import com.javainuse.swaggertest.data.playloads.request.TipoGeralTipoGeralFiltroRequest;
import java.util.Optional;

@Component
public interface TipoGeralTipoGeralFiltroService {

    Integer update(Integer idTipogeralTipogeralFiltro, TipoGeralTipoGeralFiltroRequest request) throws Exception;

    Boolean deleteById(Integer idTipogeralTipogeralFiltro) throws Exception;

    Optional<TipoGeralTipoGeralFiltro> findById(Integer idTipogeralTipogeralFiltro) throws Exception;

    Integer insert(TipoGeralTipoGeralFiltroRequest tipogeralTipogeralFiltro) throws Exception;

}


