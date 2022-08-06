package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.PessoaNome;
import com.javainuse.swaggertest.data.playloads.request.PessoaNomeRequest;
import com.javainuse.swaggertest.service.PessoaNomeService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/v1/pessoa/nome")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class PessoaNomeController {

    private final PessoaNomeService pessoaNomeService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-nome-controller", value = "Listar todas as pessoas Nome da tabela.")
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
    @ApiOperation(tags = "pessoa-nome-controller", value = "Recuperar uma pessoasNome.")
    public PessoaNome findById(
            @ApiParam(name = "idPessoaNome",
                    value = "Código de identificação de nomes.",
                    example = "1",
                    required = true)
            final @PathVariable(required = true) Integer idPessoaNome) throws Exception {
        final Optional<PessoaNome> pessoaNome = pessoaNomeService.findById(idPessoaNome);
        if (pessoaNome.isPresent()) {
            return pessoaNome.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{idPessoaNome}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-nome-controller", value = "Deletar uma pessoas Nome da tabela.")
    public Boolean deletePessoa(
            @ApiParam(name = "idPessoaNome",
                    value = "Código de identificação de nomes.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) Integer idPessoaNome) throws Exception {
        return pessoaNomeService.deleteById(idPessoaNome);
    }

    @PutMapping("/{idPessoaNome}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-nome-controller", value = "Alterar os dados de uma pessoas da tabela.")
    public Integer updatePessoaNome(
            @ApiParam(name = "idPessoaNome",
                    value = "Código de identificação de nomes.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) Integer idPessoaNome,
            @Valid @RequestBody PessoaNomeRequest request) throws Exception {
        return pessoaNomeService.update(idPessoaNome, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-nome-controller", value = "Incluir dados de uma pessoas na tabela.")
    public Integer insertPessoa(
            @Valid @RequestBody PessoaNomeRequest request) throws Exception {
        return pessoaNomeService.insert(request);
    }


}
