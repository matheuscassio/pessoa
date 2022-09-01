package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.DicNomeFamilia;
import com.javainuse.swaggertest.data.playloads.request.DicNomeFamiliaRequest;
import com.javainuse.swaggertest.data.repository.DicNomeFamiliaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class DicNomeFamiliaServiceImpl implements DicNomeFamiliaService {

    private final DicNomeFamiliaRepository dicNomeFamiliaRepository ;

    @Override
    public Optional<ArrayList<DicNomeFamilia>> getAll() throws Exception {
        return this.dicNomeFamiliaRepository.listAll();
    }

    @Override
    public Boolean deleteById(Integer idDicNomeFamilia) throws Exception {
        Optional<DicNomeFamilia> dicNomeFamilia = this.dicNomeFamiliaRepository.findById(idDicNomeFamilia);
        if (dicNomeFamilia.isPresent()) {
            this.dicNomeFamiliaRepository.delete(dicNomeFamilia.get());
            return true;
        } else return false;
    }

    @Override
    public Optional<DicNomeFamilia> findById(Integer idDicNomeFamilia) throws Exception {
        return this.dicNomeFamiliaRepository.findById(idDicNomeFamilia);
    }

    @Override
    public Integer update(Integer idDicNomeFamilia, DicNomeFamiliaRequest request) throws Exception {
        Optional<DicNomeFamilia> dicNomeFamiliaAlterada = this.dicNomeFamiliaRepository.findById(idDicNomeFamilia);
        if (dicNomeFamiliaAlterada.isPresent()) {
            return this.dicNomeFamiliaRepository.update(idDicNomeFamilia, request.getTextoNomeFamilia());
        } else return 0;
    }

    @Override
    public Integer insert(DicNomeFamiliaRequest request) throws Exception {
        return this.dicNomeFamiliaRepository.insert(request.getTextoNomeFamilia());
    }


}