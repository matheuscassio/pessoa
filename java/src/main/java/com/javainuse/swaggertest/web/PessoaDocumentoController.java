package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.PessoaDocumento;
import com.javainuse.swaggertest.data.playloads.request.PessoaDocumentoRequest;
import com.javainuse.swaggertest.service.PessoaDocumentoService;
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
@RequestMapping("/v1/pessoasDocumento")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
//@Tag(name = "Pessoas", description = "Operações relativas ao Cadastro de Pessoas Documento")
public class PessoaController {

    private final PessoaDocumentoService pessoaDocumentoService = null;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasDocumento", value = "Listar todas as pessoas da tabela.")
    public ArrayList<PessoaDocumento> listarPessoasDocumento() throws Exception {
        final Optional<ArrayList<PessoaDocumento>> lista = pessoaDocumentoService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{idPessoaDocumento}", name = "idPessoaDocumento")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasDocumentos", value = "Recuperar uma pessoasDocumento.")
    public PessoaDocumento findByHash(
            @ApiParam(value = "Código digital de PessoaDocumento.", required = true)
            final @PathVariable(required = true) String idPessoaDocumento) throws Exception {
        final Optional<PessoaDocumento> pessoaDocumento = pessoaDocumentoService.findById(idPessoaDocumento);
        if (pessoaDocumento.isPresent()) {
            return pessoaDocumento.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{hashPessoa}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Pessoas", value = "Deletar uma pessoas da tabela.")
    public Boolean deletePessoa(@ApiParam(value = "Código de identificação da Pessoa.", required = true) final @PathVariable(required = true) String id) throws Exception {
        return pessoaDocumentoService.deleteById(id);
    }

    @PutMapping("/{idPessoaDocumento}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasDocumento", value = "Alterar os dados de uma pessoas Documento da tabela.")
    public Optional<PessoaDocumento> updatePessoaDocumento(
            @ApiParam(value = "Código de identificação da Pessoa.", required = true) final @PathVariable(required = true) String hash,
            @Valid @RequestBody PessoaDocumentoRequest request) throws Exception {
        return pessoaDocumentoService.update(id, request);
    }

    @PostMapping("/concepcao")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasDocumentos", value = "Incluir dados de uma pessoas documentos na tabela.")
    public Optional<PessoaDocumento> insertPessoaDocumento(
            @Valid @RequestBody PessoaDocumentoRequest request) throws Exception {
        return pessoaDocumentoService.insert(request);
    }


}
