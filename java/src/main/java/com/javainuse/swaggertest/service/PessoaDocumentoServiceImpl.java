package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.models.PessoaDocumento;
import com.javainuse.swaggertest.data.playloads.request.PessoaDocumentoRequest;
import com.javainuse.swaggertest.data.repository.PessoaDocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

//@log4j2
@Service
@RequiredArgsConstructor
public class PessoaDocumentoServiceImpl implements PessoaDocumentoService {

    private final PessoaDocumentoRepository pessoaDocumentoRepository = null;

    @Override
    public Optional<ArrayList<PessoaDocumento>> getAll() throws Exception {
        return this.pessoaDocumentoRepository.listAll();
    }

    @Override
    public Optional<PessoaDocumento> update(Integer idPessoaDocumento, PessoaDocumentoRequest request) throws Exception {
        Optional<PessoaDocumento> pessoaDocumentoAlterada = this.pessoaDocumentoRepository.findById(idPessoaDocumento);
        if (pessoaDocumentoAlterada.isPresent()) {
            return this.pessoaDocumentoRepository.update(idPessoaDocumento, request.getValorDocumento(), request.getDataEmissao(), request.getNomeOrgaoEmissor(), request.getDescricaoSerie());
        } else return pessoaDocumentoAlterada;
    }

    @Override
    public Boolean deleteById(Integer id) throws Exception {
        Optional<PessoaDocumento> pessoaDocumento = this.pessoaDocumentoRepository.findById(id);
        if (pessoaDocumento.isPresent()) {
            this.pessoaDocumentoRepository.delete(pessoaDocumento.get());
            return true;
        } else return false;
    }

    @Override
    public Optional<PessoaDocumento> insert(PessoaDocumentoRequest request) throws Exception {
        return this.pessoaDocumentoRepository.insert(request.getValorDocumento(), request.getDataEmissao(), request.getNomeOrgaoEmissor(), request.getDescricaoSerie());
    }

	@Override
	public Optional<PessoaDocumento> findById(Integer idPessoaDocumento) throws Exception {
        return this.pessoaDocumentoRepository.findById(idPessoaDocumento);
	}

}
