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
    public Optional<DicNomeFamilia> findById(Integer idDicNomeFamilia) throws Exception {
        return this.dicNomeFamiliaRepository.findById(idDicNomeFamilia);
    }

    @Override
    public Integer update(String hash, PessoaRequest request) throws Exception {
        Optional<DicNomeFamilia> dicNomeFamiliaAlterada = this.dicNomeFamiliaRepository.findById(idDicNomeFamilia);
        if (dicNomeFamiliaAlterada.isPresent()) {
            return this.dicNomeFamiliaRepository.update( request.getTextoDicNomeFamilia());
        } else return dicNomeFamiliaAlterada;
    }

    @Override
    public Boolean deleteById(String idDicNomeFamilia) throws Exception {
        Optional<DicNomeFamilia> pessoa = this.dicNomeFamiliaRepository.findById(idDicNomeFamilia);
        if (dicNomeFamilia.isPresent()) {
            this.dicNomeFamiliaRepository.delete(dicNomeFamilia.get());
            return true;
        } else return false;
    }

    @Override
    public Integer insert(DicNomeFamiliaRequest request) throws Exception {
        return this.dicNomeFamiliaRepository.insert(request.getTextoDicNomeFamilia());
    }

	@Override
	public Integer update(Integer idDicNomeFamilia, DicNomeFamiliaRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteByHash(Integer idDicNomeFamilia) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(Integer idDicNomeFamilia, DicNomeFamiliaRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}