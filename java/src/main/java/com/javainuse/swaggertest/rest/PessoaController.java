package com.javainuse.swaggertest.rest;

import com.javainuse.swaggertest.model.Pessoa;
import io.swagger.annotations.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/v1/pessoas")
//@Tag(name = "Pessoas", description = "Operações relativas ao Cadastro de Pessoas")
@RequiredArgsConstructor
public class PessoaController {

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String listarPessoas() {

        return "Lista de Pessoas...";
    }

}
