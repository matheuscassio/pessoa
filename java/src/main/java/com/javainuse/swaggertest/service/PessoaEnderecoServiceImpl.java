package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.PessoaEndereco;
import com.javainuse.swaggertest.data.playloads.request.PessoaEnderecoRequest;
import com.javainuse.swaggertest.data.repository.PessoaEnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class PessoaEnderecoServiceImpl implements PessoaEnderecoService {

    private final PessoaEnderecoRepository pessoaEnderecoRepository ;

    @Override
    public Optional<ArrayList<PessoaEndereco>> getAll() throws Exception {
        return this.pessoaEnderecoRepository.listAll();
    }

    @Override
    public Optional<PessoaEndereco> findById(Integer idPessoaEndereco) throws Exception {
        return this.pessoaEnderecoRepository.findById(idPessoaEndereco);
    }

    @Override
    public Integer update(Integer idPessoaEndereco, PessoaEnderecoRequest request) throws Exception {
        Optional<PessoaEndereco> pessoaEnderecoAlterada = this.pessoaEnderecoRepository.findById(idPessoaEndereco);
        if (pessoaEnderecoAlterada.isPresent()) {
            return this.pessoaEnderecoRepository.update(idPessoaEndereco, request.getNomeLogadouro(), request.getNomeComplemento(), request.getNomeNumero(), request.getNomeBairro(), request.getNomeCep());
        } else return 0;
    }

    @Override
    public Boolean deleteById(Integer idPessoaEndereco) throws Exception {
        Optional<PessoaEndereco> pessoaEndereco = this.pessoaEnderecoRepository.findById(idPessoaEndereco);
        if (pessoaEndereco.isPresent()) {
            this.pessoaEnderecoRepository.delete(pessoaEndereco.get());
            return true;
        } else return false;
    }

    @Override
    public Integer insert(PessoaEnderecoRequest request) throws Exception {
        return this.pessoaEnderecoRepository.insert(request.getNomeLogadouro(), request.getNomeComplemento(), request.getNomeNumero(), request.getNomeBairro(), request.getNomeCep());
    }

}
