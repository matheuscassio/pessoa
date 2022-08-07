package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.PessoaContato;
import com.javainuse.swaggertest.data.playloads.request.PessoaContatoRequest;
import com.javainuse.swaggertest.data.repository.PessoaContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class PessoaContatoServiceImpl implements PessoaContatoService {

    private final PessoaContatoRepository pessoaContatoRepository ;

    @Override
    public Optional<ArrayList<PessoaContato>> getAll() throws Exception {
        return this.pessoaContatoRepository.listAll();
    }

    @Override
    public Integer update(Integer idPessoaContato, PessoaContatoRequest request) throws Exception {
        Optional<PessoaContato> pessoaContatoAlterada = this.pessoaContatoRepository.findById(idPessoaContato);
        if (pessoaContatoAlterada.isPresent()) {
            return this.pessoaContatoRepository.update(idPessoaContato, request.getNomeContato(), request.getDescricaoContato());
        } else return 0;
    }

    @Override
    public Optional<PessoaContato> findById(Integer idPessoaContato) throws Exception {
        return this.pessoaContatoRepository.findById(idPessoaContato);
    }

    @Override
    public Boolean deleteById(Integer idPessoaContato) throws Exception {
        Optional<PessoaContato> pessoaContato = this.pessoaContatoRepository.findById(idPessoaContato);
        if (pessoaContato.isPresent()) {
            this.pessoaContatoRepository.delete(pessoaContato.get());
            return true;
        } else return false;
    }

    @Override
    public Integer insert(PessoaContatoRequest request) throws Exception {
        return this.pessoaContatoRepository.insert(request.getIdPessoa(), request.getNomeContato(), request.getDescricaoContato());
    }

}
