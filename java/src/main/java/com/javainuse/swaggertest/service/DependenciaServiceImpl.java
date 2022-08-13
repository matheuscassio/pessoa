package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.Dependencia;
import com.javainuse.swaggertest.data.playloads.request.DependenciaRequest;
import com.javainuse.swaggertest.data.repository.DependenciaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DependenciaServiceImpl implements DependenciaService {

    private final DependenciaRepository dependenciaRepository ;

	@Override
	public Integer update(Integer idDependencia, DependenciaRequest request) throws Exception {
		Optional<Dependencia> dependenciaAlterada = this.dependenciaRepository.findById(idDependencia);
		if (dependenciaAlterada.isPresent()) {
			return this.dependenciaRepository.update(idDependencia, request);
		} else return 0;
	}

    @Override
    public Boolean deleteById(Integer idDependencia) throws Exception {
        Optional<Dependencia> dependencia = this.dependenciaRepository.findById(idDependencia);
        if (dependencia.isPresent()) {
            this.dependenciaRepository.delete(dependencia.get());
            return true;
        } else return false;
    }

	@Override
	public Optional<Dependencia> findById(Integer idDependencia) throws Exception {
		return Optional.empty();
	}
	
	@Override
	public Integer insert(DependenciaRequest request) throws Exception {
		return this.dependenciaRepository.insert(request.getIdPessoa(), request.getIdPessoaDependente(), request.getIdTipoDependente());
	}

}