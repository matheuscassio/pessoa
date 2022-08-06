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

    private static final String DicNomeRepository = null;
	private final DicNomeRepository pessoaRepository ;

    @Override
    public Optional<ArrayList<DicNome>> getAll() throws Exception {
        return this.DicNomeRepository.listAll();
    }

    @Override
    public Optional<DicNome> findById(Integer idDicNome) throws Exception {
        return this.DicNomeRepository.findById(idDicNome);
    }

    @Override
    Integer update(Integer idDicNome, DicNomeRequest request) throws Exception {
        Optional<DicNome> dicNomeAlterada = this.DicNomeRepository.findById(idDicNome);
        if (dicNomeAlterada.isPresent()) {
            return this.DicNomeRepository.update( request.getTextoDicionarioNome(),);
        } else return dicNomeAlterada;
    }

    @Override
    public Boolean deleteById(Integer idDicNome) throws Exception {
        Optional<DicNome> dicNome = this.DicNomeRepository.findById(idDicNome);
        if (dicNome.isPresent()) {
            this.DicNomeRepository.delete(dicNome.get());
            return true;
        } else return false;
    }

    @Override
    Integer insert(DicNomeRequest request) throws Exception {
        return this.pessoaRepository.insert(request.getTextoDicNome());
    }

}