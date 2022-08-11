package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.DicNome;
import com.javainuse.swaggertest.data.playloads.request.DependenciaRequest;
import com.javainuse.swaggertest.data.playloads.request.DicNomeFamiliaRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.Dependencia;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface DependenciaService {

    Integer update(Integer idDependencia, Dependencia request) throws Exception;

    Boolean deleteById(Integer idDependencia) throws Exception;

    Optional<Dependencia> findById(Integer idDependencia) throws Exception;

    Integer insert(DependenciaRequest request) throws Exception;

}