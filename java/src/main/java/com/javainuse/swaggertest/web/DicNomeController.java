package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.DicNome;
import com.javainuse.swaggertest.data.playloads.request.DicNomeRequest;
import com.javainuse.swaggertest.service.DicNomeService;
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
@RequestMapping("/v1/dicionario/nome")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class DicNomeController {
//
//    private final DicNomeService dicNomeService;
//
//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(tags = "dic-nome-controller", value = "Listar todas as pessoas da tabela contato.")
//    public ArrayList<DicNome> listarPessoasConato() throws Exception {
//        final Optional<ArrayList<DicNome>> lista = dicNomeService.getAll();
//        if (lista.isPresent()) {
//            return lista.get();
//        } else {
//            return null;
//        }
//    }
//
//    @GetMapping(value = "/{idDicNome}", name = "idDicNome")
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(tags = "dic-nome-controller", value = "Recuperar uma pessoasContato.")
//    public DicNome findById(
//            @ApiParam(value = "Código digital de PessoaContato.", required = true)
//            @PathVariable(required = true) final Integer idDependencia) throws Exception {
//        final Optional<DicNome> dependencia = dicNomeService.findById(idDependencia);
//        if (dependencia.isPresent()) {
//            return dependencia.get();
//        } else {
//            return null;
//        }
//    }
//
//    /*@DeleteMapping("/{idDicNome}"*/
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(tags = "dic-nome-controller", value = "Deletar uma Dependencia da tabela.")
//    public Boolean deleteDependencia(@ApiParam(value = "Código de identificação da Dependencia.", required = true) final @PathVariable(required = true) Integer id) throws Exception {
//        return dicNomeService.deleteById(id);
//    }
//
//    @PutMapping("/{idDicNome}")
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(tags = "dic-nome-controller", value = "Alterar os dados de uma pessoas da tabela.")
//    Integer updateDepencia(
//            @ApiParam(value = "Código de identificação da DicNome.", required = true) final @PathVariable(required = true) Integer id,
//            @Valid @RequestBody DicNomeRequest request) throws Exception {
//        return dicNomeService.update(id, request);
//    }
//
//    @PostMapping("")
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(tags = "dic-nome-controller", value = "Incluir dados de uma pessoas na tabela.")
//    Integer  insertPessoaContato(
//            @Valid @RequestBody DicNomeRequest request) throws Exception {
//        return dicNomeService.insert(request);
//    }


}