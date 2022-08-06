package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.DependenciaRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.Dependencia;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface DependenciaService {

    Optional<ArrayList<Dependencia>> getAll() throws Exception;

    Integer update(String id, Dependencia request) throws Exception;

    Boolean deleteByID(String id) throws Exception;


}