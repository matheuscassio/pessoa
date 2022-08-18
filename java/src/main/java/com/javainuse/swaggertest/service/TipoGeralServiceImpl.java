package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.TipoGeral;
import com.javainuse.swaggertest.data.playloads.request.TipoGeralRequest;
import com.javainuse.swaggertest.data.repository.TipoGeralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class TipoGeralServiceImpl implements TipoGeralService {

	    private final TipoGeralRepository tipoGeralRepository;

	    @Override
	    public Optional<ArrayList<TipoGeral>> getAll() throws Exception {
	        return this.tipoGeralRepository.listAll();
	    }

	    @Override
	    public Optional<TipoGeral> findById(Integer idTipoGeral) throws Exception {
	        return this.tipoGeralRepository.findById(idTipoGeral);
	    }

	    @Override
	    public Integer update(Integer idTipoGeral, TipoGeralRequest request) throws Exception {
	        Optional<TipoGeral> tipoGeralAlterada = this.tipoGeralRepository.findById(idTipoGeral);
	        if (tipoGeralAlterada.isPresent()) {
	            return this.tipoGeralRepository.update(idTipoGeral, request.getNomeTipoGeral(), request.getNomeFiltro(), request.getSituacaoPadrao(), request.getAtivo(), request.getTextoParametro());
	        } else return 0;
	    }

	    @Override
	    public Boolean deleteById(Integer idTipoGeral) throws Exception {
	        Optional<TipoGeral> tipoGeral = this.tipoGeralRepository.findById(idTipoGeral);
	        if (tipoGeral.isPresent()) {
	            this.tipoGeralRepository.delete(tipoGeral.get());
	            return true;
	        } else return false;
	    }

	    @Override
	    public Integer insert(TipoGeralRequest request) throws Exception {
	        return this.tipoGeralRepository.insert( request.getNomeTipoGeral(), request.getNomeFiltro(), request.getSituacaoPadrao(), request.getAtivo(), request.getTextoParametro());
	    }

	}
