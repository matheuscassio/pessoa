package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.Dependencia;
import com.javainuse.swaggertest.data.playloads.request.DependenciaRequest;
import com.javainuse.swaggertest.data.repository.DependenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class DependenciaServiceImpl implements DependenciaService {

    private final DependenciaRepository dependenciaRepository ;

    public Optional<ArrayList<Dependencia>> getAll() throws Exception {
        return this.dependenciaRepository.listAll();
    }

	@Override
	public Integer update(String id, Dependencia request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}