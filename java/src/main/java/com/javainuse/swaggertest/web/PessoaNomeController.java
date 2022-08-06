package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.PessoaNome;
import com.javainuse.swaggertest.data.playloads.request.PessoaNomeRequest;
import com.javainuse.swaggertest.service.PessoaNomeService;
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
@RequestMapping("/v1/pessoasNome")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
//@Tag(name = "Pessoas", description = "Operações relativas ao Cadastro de Pessoas")
public class PessoaNomeController {

    private final PessoaNomeService pessoaService = null;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasNome", value = "Listar todas as pessoas Nome da tabela.")
    public ArrayList<PessoaNome> listarPessoasNome() throws Exception {
        final Optional<ArrayList<PessoaNome>> lista = pessoaNomeService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{idPessoaNome}", name = "idPessoaNome")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasNome", value = "Recuperar uma pessoasNome.")
    public Pessoa findById(
            @ApiParam(value = "Código digital de PessoaNome.", required = true)
            final @PathVariable(required = true) String hashPessoa) throws Exception {
        final Optional<PessoaNome> pessoaNome = pessoaService.findById(idPessoaNome);
        if (pessoa.isPresent()) {
            return pessoaNome.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{idPessoaNome}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasNome", value = "Deletar uma pessoas Nome da tabela.")
    public Boolean deletePessoa(@ApiParam(value = "Código de identificação da Pessoa.", required = true) final @PathVariable(required = true) String id) throws Exception {
        return pessoaService.deleteById(id);
    }

    @PutMapping("/{idPessoaNome}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasNome", value = "Alterar os dados de uma pessoas da tabela.")
    public Optional<Pessoa> updatePessoaNome(
            @ApiParam(value = "Código de identificação da Pessoa.", required = true) final @PathVariable(required = true) String id,
            @Valid @RequestBody PessoaNomeRequest request) throws Exception {
        return pessoaNomeService.update(id, request);
    }

    @PostMapping("/concepcao")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasNome", value = "Incluir dados de uma pessoas na tabela.")
    public Optional<PessoaNome> insertPessoa(
            @Valid @RequestBody PessoaNomeRequest request) throws Exception {
        return pessoaService.insert(request);
    }


}
