package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.TipogeralTipogeralFiltro;
import com.javainuse.swaggertest.data.playloads.request.TipogeralTipogeralFiltroRequest;
import com.javainuse.swaggertest.data.repository.TipogeralTipogeralFiltroRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TipogeralTipogeralFiltroServiceImpl implements TipogeralTipogeralFiltroService {

    private final TipogeralTipogeralFiltroRepository tipogeralTipogeralFiltroRepository ;

	@Override
	public Integer update(Integer idTipogeralTipogeralFiltro, TipogeralTipogeralFiltroRequest request) throws Exception {
		Optional<TipogeralTipogeralFiltro> tipogeralTipogeralFiltroAlterada = this.tipogeralTipogeralFiltroRepository.findById(idTipogeralTipogeralFiltro);
		if (tipogeralTipogeralFiltroAlterada.isPresent()) {
			return this.tipogeralTipogeralFiltroRepository.update(idTipogeralTipogeralFiltro, request.getIdTipoGeral(), request.getIdTipogeralFiltro());
		} else return 0;
	}

    @Override
    public Boolean deleteById(Integer idTipogeralTipogeralFiltro) throws Exception {
        Optional<TipogeralTipogeralFiltro> tipogeralTipogeralFiltro = this.tipogeralTipogeralFiltroRepository.findById(idTipogeralTipogeralFiltro);
        if (tipogeralTipogeralFiltro.isPresent()) {
            this.tipogeralTipogeralFiltroRepository.delete(tipogeralTipogeralFiltro.get());
            return true;
        } else return false;
    }

	@Override
	public Optional<TipogeralTipogeralFiltro> findById(Integer idTipogeralTipogeralFiltro) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Integer insert(TipogeralTipogeralFiltroRequest tipogeralTipogeralFiltro) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}