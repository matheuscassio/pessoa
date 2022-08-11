package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.DicNome;
import com.javainuse.swaggertest.data.playloads.request.DicNomeRequest;
import com.javainuse.swaggertest.data.repository.DicNomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class DicNomeServiceImpl implements DicNomeService {

	private final DicNomeRepository dicNomeRepository ;

    @Override
    public Optional<ArrayList<DicNome>> getAll() throws Exception {
        return this.dicNomeRepository.listAll();
    }

    @Override
    public Optional<DicNome> findById(Integer idDicNome) throws Exception {
        return this.dicNomeRepository.findById(idDicNome);
    }

    @Override
    public Integer update(Integer idDicNome, DicNomeRequest request) throws Exception {
        Optional<DicNome> dicNomeAlterada = this.dicNomeRepository.findById(idDicNome);
        if (dicNomeAlterada.isPresent()) {
            return this.dicNomeRepository.update(request.getIdDicNomeRequest(), request.getNome());
        } else return 0;
    }

    @Override
    public Boolean deleteById(Integer idDicNome) throws Exception {
        Optional<DicNome> dicNome = this.dicNomeRepository.findById(idDicNome);
        if (dicNome.isPresent()) {
            this.dicNomeRepository.delete(dicNome.get());
            return true;
        } else return false;
    }

    @Override
    public Integer insert(DicNomeRequest request) throws Exception {
        return this.dicNomeRepository.insert(request.getNome());
    }


}