package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.TipoGeralFiltro;
import com.javainuse.swaggertest.data.playloads.request.TipoGeralFiltroRequest;
import com.javainuse.swaggertest.data.repository.TipoGeralFiltroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class TipoGeralFiltroServiceImpl implements TipoGeralFiltroService {

    private final TipoGeralFiltroRepository tipoGeralFiltroRepository;

    @Override
    public Optional<ArrayList<TipoGeralFiltro>> getAll() throws Exception {
        return this.tipoGeralFiltroRepository.listAll();
    }

    @Override
    public Optional<TipoGeralFiltro> findById(Integer idTipoGeralFiltro) throws Exception {
        return this.tipoGeralFiltroRepository.findById(idTipoGeralFiltro);
    }

    @Override
    public Integer update(Integer idTipogeralFiltro, TipoGeralFiltroRequest request) throws Exception {
        Optional<TipoGeralFiltro> tipogeralFiltroAlterada = this.tipoGeralFiltroRepository.findById(idTipogeralFiltro);
        if (tipogeralFiltroAlterada.isPresent()) {
            return this.tipoGeralFiltroRepository.update(idTipogeralFiltro, request.getNomeFiltro());
        } else return 0;
    }

    @Override
    public Boolean deleteById(Integer idTipogeralFiltro) throws Exception {
        Optional<TipoGeralFiltro> tipogeralFiltro = this.tipoGeralFiltroRepository.findById(idTipogeralFiltro);
        if (tipogeralFiltro.isPresent()) {
            this.tipoGeralFiltroRepository.delete(tipogeralFiltro.get());
            return true;
        } else return false;
    }

    @Override
    public Integer insert(TipoGeralFiltroRequest request) throws Exception {
        return this.tipoGeralFiltroRepository.insert(request.getNomeFiltro());
    
    }

}