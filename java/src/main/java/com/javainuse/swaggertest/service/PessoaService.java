package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.data.playloads.request.PessoaRequest;
import com.javainuse.swaggertest.data.playloads.response.MessageResponse;
import com.javainuse.swaggertest.data.models.Pessoa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PessoaService {

    MessageResponse createPessoa(PessoaRequest pessoaRequest);

    Optional<Pessoa> updatePessoa(Integer idPessoa, PessoaRequest pessoaRequest);

    void deletePessoa(Integer idPessoa);

    Pessoa getASinglePessoa(Integer employeeId);

    List<Pessoa> getAllPessoa();


}
