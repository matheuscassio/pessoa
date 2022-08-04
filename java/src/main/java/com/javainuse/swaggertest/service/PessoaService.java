package com.javainuse.swaggertest.service;

import org.springframework.stereotype.Component;
import com.javainuse.swaggertest.data.models.Pessoa;

import java.util.ArrayList;
import java.util.Optional;

@Component
public interface PessoaService {

    Optional<ArrayList<Pessoa>> getAll() throws Exception;
}
