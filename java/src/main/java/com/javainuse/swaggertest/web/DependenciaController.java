package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.Dependencia;
import com.javainuse.swaggertest.data.playloads.request.DependenciaRequest;
import com.javainuse.swaggertest.service.DependenciaService;
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
@RequestMapping("/v1/dependenciav1")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
//@Tag(name = "Dependencias", description = "Operações relativas ao Cadastro de Pessoas")
public class DependenciaController {

    private final DependenciaService pessoaContatoService = null;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasContato", value = "Listar todas as pessoas da tabela contato.")
    public ArrayList<Dependencia> listarPessoasConato() throws Exception {
        final Optional<ArrayList<Dependencia>> lista = dependenciaService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{idPessoaContato}", name = "idPessoaContato")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasContato", value = "Recuperar uma pessoasContato.")
    public Dependencia findById(
            @ApiParam(value = "Código digital de PessoaContato.", required = true)
            final @PathVariable(required = true) String idDependencia) throws Exception {
        final Optional<Dependencia> dependencia = pessoaContatoService.findById(idDependencia);
        if (dependencia.isPresent()) {
            return dependencia.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{hashPessoa}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "dependencias", value = "Deletar uma Dependencia da tabela.")
    public Boolean deleteDependencia(@ApiParam(value = "Código de identificação da Dependencia.", required = true) final @PathVariable(required = true) Integer id) throws Exception {
        return dependenciaService.deleteById(id);
    }

    @PutMapping("/{idPessoaContato}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasConato", value = "Alterar os dados de uma pessoas da tabela.")
    Integer updateDepencia(
            @ApiParam(value = "Código de identificação da PessoasConato.", required = true) final @PathVariable(required = true) Integer id,
            @Valid @RequestBody DependenciaRequest request) throws Exception {
        return DependenciaService.update(id, request);
    }

    @PostMapping("/concepcao")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasContato", value = "Incluir dados de uma pessoas na tabela.")
    Integer  insertPessoaContato(
            @Valid @RequestBody DependenciaRequest request) throws Exception {
        return pessoaContatoService.insert(request);
    }


}