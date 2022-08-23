package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.PessoaEndereco;
import com.javainuse.swaggertest.data.models.PessoaNome;
import com.javainuse.swaggertest.data.playloads.request.PessoaEnderecoRequest;
import com.javainuse.swaggertest.service.PessoaEnderecoService;
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
@RequestMapping("/v1/pessoa/endereco")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class PessoaEnderecoController {

	 
    private final PessoaEnderecoService pessoaEnderecoService ;
   
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-endereco-controller", value = "Listar todas as pessoas Endereco da tabela.")
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
    @ApiOperation(tags = "pessoa-endereco-controller", value = "Recuperar uma pessoa Endereco.")
    public PessoaEndereco findById(
            @ApiParam(name = "idPessoaEndereco",
                    value = "Código de identificação de Endereco.",
                    example = "1",
                    required = true)
            final @PathVariable(required = true) Integer idPessoaEndereco) throws Exception {
        final Optional<PessoaEndereco> pessoaEndereco = pessoaEnderecoService.findById(idPessoaEndereco);
        if (pessoaEndereco.isPresent()) {
            return pessoaEndereco.get();
        } else {
            return null;
        }
    }
    /*
    @DeleteMapping("/{idPessoaEndereco}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-endereco-controller", value = "Deletar uma pessoas Endereco da tabela.")
    public Boolean deletePessoaEndereco(
            @ApiParam(name = "idPessoaContato",
                    value = "Código de identificação de endereço.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idPessoaEndereco) throws Exception {
        return pessoaEnderecoService.deleteById(idPessoaEndereco);
    }

    @PutMapping("/{idPessoaEndereco}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-endereco-controller", value = "Alterar os dados de uma pessoas Endereco da tabela.")
    public Integer updatePessoaEndereco(
            @ApiParam(name = "idPessoaContato",
                    value = "Código de identificação de endereço.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idPessoaEndereco,
            @Valid @RequestBody PessoaEnderecoRequest request) throws Exception {
        return pessoaEnderecoService.update(idPessoaEndereco, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "pessoa-endereco-controller", value = "Incluir dados de uma pessoas Endereco na tabela.")
    public Integer insertPessoa(
            @Valid @RequestBody PessoaEnderecoRequest request) throws Exception {
        return pessoaEnderecoService.insert(request);
    }
*/

}
