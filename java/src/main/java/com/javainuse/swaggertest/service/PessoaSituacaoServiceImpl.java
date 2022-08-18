package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.PessoaSituacao;
import com.javainuse.swaggertest.data.playloads.request.PessoaSituacaoRequest;
import com.javainuse.swaggertest.data.repository.PessoaSituacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class PessoaSituacaoServiceImpl implements PessoaSituacaoService {

    private final PessoaSituacaoRepository pessoaSituacaoRepository ;

    @Override
    public Optional<ArrayList<PessoaSituacao>> getAll() throws Exception {
        return this.pessoaSituacaoRepository.listAll();
    }

    @Override
    public Integer update(Integer idPessoaSituacao, PessoaSituacaoRequest request) throws Exception {
        Optional<PessoaSituacao> pessoaSituacaoAlterada = this.pessoaSituacaoRepository.findById(idPessoaSituacao);
        if (pessoaSituacaoAlterada.isPresent()) {
            return this.pessoaSituacaoRepository.update(idPessoaSituacao, request.getIdPessoa(), request.getIdTipoSituacao(), request.getDataSituacao());
        } else return 0;
    }

    @Override
    public Boolean deleteById(Integer id) throws Exception {
        Optional<PessoaSituacao> pessoaSituacao = this.pessoaSituacaoRepository.findById(id);
        if (pessoaSituacao.isPresent()) {
            this.pessoaSituacaoRepository.delete(pessoaSituacao.get());
            return true;
        } else return false;
    }

    @Override
    public Integer insert(PessoaSituacaoRequest request) throws Exception {
        return this.pessoaSituacaoRepository.insert(request.getIdPessoa(), request.getIdTipoSituacao(), request.getDataSituacao());
    }

	@Override
	public Optional<PessoaSituacao> findById(Integer idPessoaSituacao) throws Exception {
        return this.pessoaSituacaoRepository.findById(idPessoaSituacao);
	}

}
