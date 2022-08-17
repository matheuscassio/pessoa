package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.TipoGeralFiltro;
import com.javainuse.swaggertest.data.playloads.request.TipogeralFiltroRequest;
import com.javainuse.swaggertest.data.repository.TipogeralFiltroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class TipogeralFiltroServiceImpl implements TipogeralFiltroService {

    private final TipogeralFiltroRepository tipogeralFiltroRepository;

    @Override
    public Optional<ArrayList<TipoGeralFiltro>> getAll() throws Exception {
        return this.tipogeralFiltroRepository.listAll();
    }

    @Override
    public Optional<TipoGeralFiltro> findById(Integer idTipogeralFiltro) throws Exception {
        return this.tipogeralFiltroRepository.findById(idTipogeralFiltro);
    }

    @Override
    public Integer update(Integer idTipogeralFiltro, TipogeralFiltroRequest request) throws Exception {
        Optional<TipoGeralFiltro> tipogeralFiltroAlterada = this.tipogeralFiltroRepository.findById(idTipogeralFiltro);
        if (tipogeralFiltroAlterada.isPresent()) {
            return this.tipogeralFiltroRepository.update(idTipogeralFiltro, request.getNomeFiltro(),  request.getTextoParametro());
        } else return 0;
    }

    @Override
    public Boolean deleteById(Integer idTipogeralFiltro) throws Exception {
        Optional<TipoGeralFiltro> tipogeralFiltro = this.tipogeralFiltroRepository.findById(idTipogeralFiltro);
        if (tipogeralFiltro.isPresent()) {
            this.tipogeralFiltroRepository.delete(tipogeralFiltro.get());
            return true;
        } else return false;
    }

    @Override
    public Integer insert(TipogeralFiltroRequest request) throws Exception {
        return this.tipogeralFiltroRepository.insert(request.getNomeFiltro(), request.getTextoParametro());
    
    }

}