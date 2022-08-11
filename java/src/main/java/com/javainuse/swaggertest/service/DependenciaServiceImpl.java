package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.Dependencia;
import com.javainuse.swaggertest.data.models.Municipio;
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

	@Override
	public Integer update(Integer idDependencia, Dependencia request) throws Exception {
		Optional<Dependencia> dependenciaAlterada = this.dependenciaRepository.findById(idDependencia);
		if (dependenciaAlterada.isPresent()) {
			return this.dependenciaRepository.update(idDependencia, request);
		} else return 0;
	}

	@Override
	public Boolean deleteById(Integer idDependencia) throws Exception {
		return null;
	}

	@Override
	public Optional<Dependencia> findById(Integer idDependencia) throws Exception {
		return Optional.empty();
	}

	@Override
	public Integer insert(DependenciaRequest request) throws Exception {
		return null;
	}

}