package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.DicNomeRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.DicNome;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface DicNomeService {

    Optional<ArrayList<DicNome>> getAll() throws Exception;

    Optional<DicNome> findById(Integer idDicNome) throws Exception;

    Integer update(Integer idDicNome, DicNomeRequest request) throws Exception;

    Boolean deleteById(Integer idDicNome) throws Exception;

    Integer insert(DicNomeRequest request) throws Exception;

}