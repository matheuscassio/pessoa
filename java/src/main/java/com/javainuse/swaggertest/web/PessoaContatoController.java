package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.PessoaContato;
import com.javainuse.swaggertest.data.playloads.request.PessoaContatoRequest;
import com.javainuse.swaggertest.service.PessoaContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/v1/pessoasContato")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
//@Tag(name = "Pessoas", description = "Operações relativas ao Cadastro de Pessoas")
public class PessoaContatoController {

    private final PessoaContatoService pessoaContatoService = null;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasContato", value = "Listar todas as pessoas da tabela contato.")
    public ArrayList<PessoaContato> listarPessoasConato() throws Exception {
        final Optional<ArrayList<PessoaContato>> lista = pessoaContatoService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{idPessoaContato}", name = "idPessoaContato")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasContato", value = "Recuperar uma pessoasContato.")
    public PessoaContato findById(
            @ApiParam(value = "Código digital de PessoaContato.", required = true)
            final @PathVariable(required = true) String hashPessoa) throws Exception {
        final Optional<PessoaContato> pessoa = pessoaContatoService.findById(idPessoaContato);
        if (pessoaContato.isPresent()) {
            return pessoaContato.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{hashPessoa}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Pessoas", value = "Deletar uma pessoas da tabela.")
    public Boolean deletePessoa(@ApiParam(value = "Código de identificação da Pessoa.", required = true) final @PathVariable(required = true) String hash) throws Exception {
        return pessoaContatoService.deleteById(id);
    }

    @PutMapping("/{idPessoaContato}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasConato", value = "Alterar os dados de uma pessoas da tabela.")
    public Optional<PessoaContato> updatePessoa(
            @ApiParam(value = "Código de identificação da PessoasConato.", required = true) final @PathVariable(required = true) String hash,
            @Valid @RequestBody PessoaConatoRequest request) throws Exception {
        return PessoaContatoService.update(id, request);
    }

    @PostMapping("/concepcao")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasContato", value = "Incluir dados de uma pessoas na tabela.")
    public Optional<PessoaContato> insertPessoaContato(
            @Valid @RequestBody PessoaContatoRequest request) throws Exception {
        return pessoaContatoService.insert(request);
    }


}