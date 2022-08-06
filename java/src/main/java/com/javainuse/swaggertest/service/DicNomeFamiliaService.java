package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.DicNomeFamiliaRequest;
import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.DicNomeFamilia;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface DicNomeFamiliaService {

    Optional<ArrayList<DicNomeFamilia>> getAll() throws Exception;

    Integer update(Integer idDicNomeFamilia, DicNomeFamiliaRequest request) throws Exception;

    Boolean deleteByHash(Integer idDicNomeFamilia) throws Exception;

    Integer insert(Integer idDicNomeFamilia, DicNomeFamiliaRequest request) throws Exception;

	Integer insert(DicNomeFamiliaRequest request) throws Exception;

}