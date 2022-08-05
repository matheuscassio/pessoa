package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.Pessoa;
import com.javainuse.swaggertest.data.playloads.request.PessoaRequest;
import com.javainuse.swaggertest.data.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository = null;

    @Override
    public Optional<ArrayList<Pessoa>> getAll() throws Exception {
        return this.pessoaRepository.listAll();
    }

    @Override
    public Optional<Pessoa> findByHash(String hash) throws Exception {
        return this.pessoaRepository.findByHash(hash);
    }

    @Override
    public Optional<Pessoa> update(String hash, PessoaRequest request) throws Exception {
        Optional<Pessoa> pessoaAlterada = this.pessoaRepository.findByHash(hash);
        if (pessoaAlterada.isPresent()) {
            return this.pessoaRepository.update(hash, request.getNomeMae(), request.getDataNascimento());
        } else return pessoaAlterada;
    }

    @Override
    public Boolean deleteByHash(String hash) throws Exception {
        Optional<Pessoa> pessoa = this.pessoaRepository.findByHash(hash);
        if (pessoa.isPresent()) {
            this.pessoaRepository.delete(pessoa.get());
            return true;
        } else return false;
    }

    @Override
    public Optional<Pessoa> insert(PessoaRequest request) throws Exception {
        return this.pessoaRepository.insert(request.getNomeMae(), request.getDataNascimento());
    }

}
