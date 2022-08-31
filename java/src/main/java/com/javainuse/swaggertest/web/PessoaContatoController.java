package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.PessoaContato;
import com.javainuse.swaggertest.service.PessoaContatoService;
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
@RequestMapping("/v1/pessoa/contatos")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class PessoaContatoController {

    private final PessoaContatoService pessoaContatoService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-contato-controller", value = "Listar todas as pessoas da tabela contato.")
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
    @ApiOperation(tags = "pessoa-contato-controller", value = "Recuperar uma pessoasContato.")
    public PessoaContato findById(
            @ApiParam(name = "idPessoaContato",
                    value = "Código de Pessoa Contato.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idPessoaContato) throws Exception {
        final Optional<PessoaContato> pessoaContato = pessoaContatoService.findById(idPessoaContato);
        if (pessoaContato.isPresent()) {
            return pessoaContato.get();
        } else {
            return null;
        }
    }

	 @DeleteMapping("/{idPessoaContato}")
	 @ResponseStatus(HttpStatus.OK)
	 @ApiOperation(tags = "pessoa-contato-controller", value = "Deletar um pessoa-contato da tabela.")
	 public Boolean idPessoaContato(
	         @ApiParam(name = "idPessoaContato",
	                 value = "Código de Pessoa Contato.",
	                 example = "1",
	                 required = true)
	         @PathVariable(required = true) final Integer idPessoaContato) throws Exception {
	     return pessoaContatoService.deleteById(idPessoaContato);
	 }
//
//    @PutMapping("/{idPessoaContato}")
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(tags = "pessoa-contato-controller", value = "Alterar os dados de um contato pessoas da tabela.")
//    public Integer updatePessoaContato(
//            @ApiParam(name = "idPessoaContato",
//                    value = "Código de Pessoa Contato.",
//                    example = "1",
//                    required = true)
//            @PathVariable(required = true) final Integer idPessoaContato,
//            @Valid @RequestBody PessoaContatoRequest request) throws Exception {
//        return pessoaContatoService.update(idPessoaContato, request);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(tags = "pessoa-contato-controller", value = "Incluir dados de uma pessoas na tabela.")
//    public Integer insertPessoaContato(
//            @Valid @RequestBody PessoaContatoRequest request) throws Exception {
//        return pessoaContatoService.insert(request);
//    }


}