package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.PessoaEndereco;
import com.javainuse.swaggertest.data.playloads.request.PessoaEnderecoRequest;
import com.javainuse.swaggertest.service.PessoaEnderecoService;
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
@RequestMapping("/v1/pessoasEndereco")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
//@Tag(name = "Pessoas", description = "Operações relativas ao Cadastro de Pessoas")
public class PessoaEnderecoController {

    private final PessoaEnderecoService pessoaEnderecoService = null;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasEndereco", value = "Listar todas as pessoas Endereco da tabela.")
    public ArrayList<PessoaEndereco> listarPessoasEndereco() throws Exception {
        final Optional<ArrayList<PessoaEndereco>> lista = pessoaEnderecoService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{idPessoaEndereco}", name = "idPessoaEndereco")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasEndereco", value = "Recuperar uma pessoas Endereco.")
    public PessoaEndereco findById(
            @ApiParam(value = "Código digital de PessoaEndereco.", required = true)
            final @PathVariable(required = true) String idPessoaEndereco) throws Exception {
        final Optional<PessoaEndereco> pessoaEndereco = pessoaEnderecoService.findById(idPessoaEndereco);
        if (pessoaEndereco.isPresent()) {
            return pessoaEndereco.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{idPessoaEndereco}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasEndereco", value = "Deletar uma pessoas Endereco da tabela.")
    public Boolean deletePessoaEndereco(@ApiParam(value = "Código de identificação da Pessoa Endereco.", required = true) final @PathVariable(required = true) String id) throws Exception {
        return pessoaEnderecoService.deleteById(id);
    }

    @PutMapping("/{idPessoaEndereco}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasEndereco", value = "Alterar os dados de uma pessoas Endereco da tabela.")
    public Optional<PessoaEndereco> updatePessoaEndereco(
            @ApiParam(value = "Código de identificação da Pessoa Endereco.", required = true) final @PathVariable(required = true) String hash,
            @Valid @RequestBody PessoaEnderecoRequest request) throws Exception {
        return pessoaEnderecoService.update(id, request);
    }

    @PostMapping("/concepcao")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasEndereco", value = "Incluir dados de uma pessoas Endereco na tabela.")
    public Optional<PessoaEndereco> insertPessoa(
            @Valid @RequestBody PessoaEnderecoRequest request) throws Exception {
        return pessoaEnderecoService.insert(request);
    }


}
