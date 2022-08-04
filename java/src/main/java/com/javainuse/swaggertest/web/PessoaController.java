package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.Pessoa;
import com.javainuse.swaggertest.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/v1/pessoas")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
//@Tag(name = "Pessoas", description = "Operações relativas ao Cadastro de Pessoas")
public class PessoaController {


    private final PessoaService pessoaService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Pessoas", value = "Listar todas as pessoas da tabela.")
    public ArrayList<Pessoa> listarPessoas() throws Exception {
        final Optional<ArrayList<Pessoa>> lista = pessoaService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{hashPessoa}", name = "hashPessoa")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Pessoas", value = "Recuperar uma pessoas.")
    public Pessoa findByHash(
            @ApiParam(value = "Código digital de Pessoa.", required = true)
            final @PathVariable(required = true) String hashPessoa) throws Exception {
        final Optional<Pessoa> pessoa = pessoaService.findByHash(hashPessoa);
        if (pessoa.isPresent()) {
            return pessoa.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{hashPessoa}}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Pessoas", value = "Deletar uma pessoas da tabela.")
    public Boolean deletePessoa(@ApiParam(value = "Código de identificação da Pessoa.", required = true) final @PathVariable(required = true) String hash) throws Exception {
        final Optional<ArrayList<Pessoa>> lista = pessoaService.getAll();
        return true;
    }



}