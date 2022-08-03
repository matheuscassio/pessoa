package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.Pessoa;
import com.javainuse.swaggertest.data.playloads.request.PessoaRequest;
import com.javainuse.swaggertest.data.playloads.response.MessageResponse;
import com.javainuse.swaggertest.data.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    @Override
    public MessageResponse createPessoa(PessoaRequest pessoaRequest) {
        return null;
    }

    @Override
    public Optional<Pessoa> updatePessoa(Integer idPessoa, PessoaRequest pessoaRequest) {
        return Optional.empty();
    }

    @Override
    public void deletePessoa(Integer idPessoa) {

    }

    @Override
    public Pessoa getASinglePessoa(Integer employeeId) {
        return null;
    }

    @Override
    public ArrayList<Pessoa> getAllPessoa() {
        return null;
    }

    @Override
    public Optional<ArrayList<Pessoa>> getAll() throws Exception {
        final Optional<ArrayList<Pessoa>> lista = this.pessoaRepository.listAll();
        return lista;
    }
}
