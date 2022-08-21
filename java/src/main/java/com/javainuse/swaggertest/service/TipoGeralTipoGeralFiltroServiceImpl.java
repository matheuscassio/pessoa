package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.TipoGeralTipoGeralFiltro;
import com.javainuse.swaggertest.data.playloads.request.TipoGeralTipoGeralFiltroRequest;
import com.javainuse.swaggertest.data.repository.TipoGeralTipoGeralFiltroRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TipoGeralTipoGeralFiltroServiceImpl implements TipoGeralTipoGeralFiltroService {

    private final TipoGeralTipoGeralFiltroRepository tipoGeralTipoGeralFiltroRepository ;

	@Override
	public Integer update(Integer idTipogeralTipogeralFiltro, TipoGeralTipoGeralFiltroRequest request) throws Exception {
		Optional<TipoGeralTipoGeralFiltro> tipogeralTipogeralFiltroAlterada = this.tipoGeralTipoGeralFiltroRepository.findById(idTipogeralTipogeralFiltro);
		if (tipogeralTipogeralFiltroAlterada.isPresent()) {
			return this.tipoGeralTipoGeralFiltroRepository.update(idTipogeralTipogeralFiltro, request.getIdTipoGeral(), request.getIdTipogeralFiltro());
		} else return 0;
	}

    @Override
    public Boolean deleteById(Integer idTipoGeralTipogeralFiltro) throws Exception {
        Optional<TipoGeralTipoGeralFiltro> tipoGeralTipoGeralFiltro = this.tipoGeralTipoGeralFiltroRepository.findById(idTipoGeralTipogeralFiltro);
        if (tipoGeralTipoGeralFiltro.isPresent()) {
            this.tipoGeralTipoGeralFiltroRepository.delete(tipoGeralTipoGeralFiltro.get());
            return true;
        } else return false;
    }

	@Override
	public Optional<TipoGeralTipoGeralFiltro> findById(Integer idTipoGeralTipoGeralFiltro) throws Exception {
		return this.tipoGeralTipoGeralFiltroRepository.findById(idTipoGeralTipoGeralFiltro);
	}

	@Override
	public Integer insert(TipoGeralTipoGeralFiltroRequest tipogeralTipogeralFiltro) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}