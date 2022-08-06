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

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/v1/pessoa/documentos")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class PessoaDocumentoController {

    private final PessoaDocumentoService pessoaDocumentoService ;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-documento-controller", value = "Listar todas as pessoas da tabela.")
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
    @ApiOperation(tags = "pessoa-documento-controller", value = "Recuperar uma pessoasDocumento.")
    public PessoaDocumento findById(
            @ApiParam(name = "idPessoaContato",
                    value = "Código de identificação do documento.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idPessoaDocumento) throws Exception {
        final Optional<PessoaDocumento> pessoaDocumento = pessoaDocumentoService.findById(idPessoaDocumento);
        if (pessoaDocumento.isPresent()) {
            return pessoaDocumento.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{idPessoaDocumento}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-documento-controller", value = "Deletar uma pessoas da tabela.")
    public Boolean deletePessoaDocumento(
            @ApiParam(name = "idPessoaContato",
                    value = "Código de identificação do documento.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idPessoaDocumento) throws Exception {
        return pessoaDocumentoService.deleteById(idPessoaDocumento);
    }

    @PutMapping("/{idPessoaDocumento}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-documento-controller", value = "Alterar os dados de uma pessoas Documento da tabela.")
    public Integer updatePessoaDocumento(
            @ApiParam(name = "idPessoaContato",
                    value = "Código de identificação do documento.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idPessoaDocumento,
            @Valid @RequestBody PessoaDocumentoRequest request) throws Exception {
        return pessoaDocumentoService.update(idPessoaDocumento, request);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-documento-controller", value = "Incluir dados de uma pessoas documentos na tabela.")
    public Integer insertPessoaDocumento(
            @Valid @RequestBody PessoaDocumentoRequest request) throws Exception {
        return pessoaDocumentoService.insert(request);
    }


}
