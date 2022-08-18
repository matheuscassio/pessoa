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

    private final TipoGeralTipoGeralFiltroRepository tipogeralTipogeralFiltroRepository ;

	@Override
	public Integer update(Integer idTipogeralTipogeralFiltro, TipoGeralTipoGeralFiltroRequest request) throws Exception {
		Optional<TipoGeralTipoGeralFiltro> tipogeralTipogeralFiltroAlterada = this.tipogeralTipogeralFiltroRepository.findById(idTipogeralTipogeralFiltro);
		if (tipogeralTipogeralFiltroAlterada.isPresent()) {
			return this.tipogeralTipogeralFiltroRepository.update(idTipogeralTipogeralFiltro, request.getIdTipoGeral(), request.getIdTipogeralFiltro());
		} else return 0;
	}

    @Override
    public Boolean deleteById(Integer idTipogeralTipogeralFiltro) throws Exception {
        Optional<TipoGeralTipoGeralFiltro> tipogeralTipogeralFiltro = this.tipogeralTipogeralFiltroRepository.findById(idTipogeralTipogeralFiltro);
        if (tipogeralTipogeralFiltro.isPresent()) {
            this.tipogeralTipogeralFiltroRepository.delete(tipogeralTipogeralFiltro.get());
            return true;
        } else return false;
    }

	@Override
	public Optional<TipoGeralTipoGeralFiltro> findById(Integer idTipogeralTipogeralFiltro) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Integer insert(TipoGeralTipoGeralFiltroRequest tipogeralTipogeralFiltro) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}