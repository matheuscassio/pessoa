package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.PessoaNome;
import com.javainuse.swaggertest.data.playloads.request.PessoaNomeRequest;
import com.javainuse.swaggertest.data.repository.PessoaNomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class PessoaNomeServiceImpl implements PessoaNomeService {

    private final PessoaNomeRepository pessoaNomeRepository ;

    @Override
    public Optional<ArrayList<PessoaNome>> getAll() throws Exception {
        return this.pessoaNomeRepository.listAll();
    }

    @Override
    public Optional<PessoaNome> findById(Integer idPessoaNome) throws Exception {
        return this.pessoaNomeRepository.findById(idPessoaNome);
    }

    @Override
    public Integer update(Integer idPessoaNome, PessoaNomeRequest request) throws Exception {
        Optional<PessoaNome> pessoaNomeAlterada = this.pessoaNomeRepository.findById(idPessoaNome);
        if (pessoaNomeAlterada.isPresent()) {
            return this.pessoaNomeRepository.update(idPessoaNome, request.getNomePessoa());
        } else return 0;
    }

    @Override
    public Boolean deleteById(Integer idPessoaNome) throws Exception {
        Optional<PessoaNome> pessoaNome = this.pessoaNomeRepository.findById(idPessoaNome);
        if (pessoaNome.isPresent()) {
            this.pessoaNomeRepository.delete(pessoaNome.get());
            return true;
        } else return false;
    }

    @Override
    public Integer insert(PessoaNomeRequest request) throws Exception {
        return this.pessoaNomeRepository.insert(request.getNomePessoa());
    }

}
