package com.javainuse.swaggertest.web;


import com.javainuse.swaggertest.data.models.PessoaSituacao;
import com.javainuse.swaggertest.data.playloads.request.PessoaSituacaoRequest;
import com.javainuse.swaggertest.service.PessoaSituacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/v1/pessoa/situacao")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class PessoaSituacaoController {
   /* private final PessoaSituacaoService pessoaSituacaoService ;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-situacao-controller", value = "Listar todas as Situações de pessoas da tabela.")
    public ArrayList<PessoaSituacao> listarPessoaSituacao() throws Exception {
       final Optional<ArrayList<PessoaSituacao>> lista = pessoaSituacaoService.getAll();
        if (lista.isPresent()) {
            return lista.get();
       } else {
            return null;
       }
    }

    @GetMapping(value = "/{idPessoaSituacao}", name = "idPessoaSituacao")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-situacao-controller", value = "Recuperar uma Situçao pessoa.")
    public PessoaSituacao findById(
            @ApiParam(name = "idPessoaSituacao",value = "Código de identificação da Situacao.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idPessoaSituacao) throws Exception {
        final Optional<PessoaSituacao> pessoaSituacao = pessoaSituacaoService.findById(idPessoaSituacao);
        if (pessoaSituacao.isPresent()) {
            return pessoaSituacao.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{idPessoaSituacao}")
	 @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-Situacao-controller", value = "Deletar uma Situação pessoas da tabela.")
    public Boolean deletePessoaDocumento(
            @ApiParam(name = "idPessoaSituacao",
                    value = "Código de identificação da Situação.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idPessoaSituacao) throws Exception {
        return pessoaSituacaoService.deleteById(idPessoaSituacao);
    }

    @PutMapping("/{idPessoaSituacao}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-situacao-controller", value = "Alterar os dados de uma  pessoas Situaçao na tabela.")
    public Integer updatePessoaDocumento(
            @ApiParam(name = "idPessoaSituacao",
                   value = "Código de identificação da Situação.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idPessoaSituacao,
            @Valid @RequestBody PessoaSituacaoRequest request) throws Exception {
        return pessoaSituacaoService.update(idPessoaSituacao, request);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-situacao-controller", value = "Incluir dados de uma  Situacao pessoa na tabela.")
    public Integer insertPessoaSituacao(
            @Valid @RequestBody PessoaSituacaoRequest request) throws Exception {
        return pessoaSituacaoService.insert(request);
    }

*/
}
