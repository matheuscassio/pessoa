package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.Municipio;
import com.javainuse.swaggertest.data.playloads.request.MunicipioRequest;
import com.javainuse.swaggertest.data.repository.MunicipioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class MunicipioServiceImpl implements MunicipioService {

    private final MunicipioRepository municipioRepository = null;

    @Override
    public Optional<ArrayList<Municipio>> getAll() throws Exception {
        return this.municipioRepository.listAll();
    }

    @Override
    public Optional<Municipio> findById(Integer idMunicipio) throws Exception {
        return this.municipioRepository.findById(idMunicipio);
    }

    @Override
    public Optional<Municipio> update(Integer idMunicipio, MunicipioRequest request) throws Exception {
        Optional<Municipio> municipioAlterada = this.municipioRepository.findById(idMunicipio);
        if (municipioAlterada.isPresent()) {
            return this.municipioRepository.update(idMunicipio, request.getNomeMunicipio());
        } else return municipioAlterada;
    }

    @Override
    public Boolean deleteById(Integer idMunicipio) throws Exception {
        Optional<Municipio> municipio = this.municipioRepository.findById(idMunicipio);
        if (municipio.isPresent()) {
            this.municipioRepository.delete(municipio.get());
            return true;
        } else return false;
    }

    @Override
    public Optional<Municipio> insert(MunicipioRequest request) throws Exception {
        return this.municipioRepository.insert(request.getNomeMunicipio());
    }

}
