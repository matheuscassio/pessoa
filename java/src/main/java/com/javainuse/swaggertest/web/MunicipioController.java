package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.Municipio;
import com.javainuse.swaggertest.data.playloads.request.MunicipioRequest;
import com.javainuse.swaggertest.service.MunicipioService;
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
@RequestMapping("/v1/municipios")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
//@Tag(name = "Municipios", description = "Operações relativas ao Cadastro de Municipios")
public class MunicipioController {

    private final Municipioervice municipiosService = null;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Municipios", value = "Listar todas os municipios da tabela.")
    public ArrayList<Municipio> listarMunicipios() throws Exception {
        final Optional<ArrayList<Municipio>> lista = municipioService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{idMunicipio}", name = "idMunicipio")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Municipios", value = "Recuperar um Municipio.")
    public Municipio findByHash(
            @ApiParam(value = "Código digital de Municipio.", required = true)
            final @PathVariable(required = true) String hashPessoa) throws Exception {
        final Optional<Municipio> municipio = municipioService.findById(idMunicipio);
        if (pessoa.isPresent()) {
            return municipio.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{idMunicipio}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Municipios", value = "Deletar um Municipio da tabela.")
    public Boolean deleteMunicipio(@ApiParam(value = "Código de identificação do Municipio.", required = true) final @PathVariable(required = true) String id) throws Exception {
        return municipioService.deleteById(id);
    }

    @PutMapping("/{idMunicipio}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Municipios", value = "Alterar os dados de um Municipio da tabela.")
    public Optional<Municipio> updateMunicipio(
            @ApiParam(value = "Código de identificação de Municipio.", required = true) final @PathVariable(required = true) String id,
            @Valid @RequestBody PessoaRequest request) throws Exception {
        return municipioService.update(id, request);
    }

    @PostMapping("/concepcao")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Municipios", value = "Incluir dados de um Municipio na tabela.")
    public Optional<Municipio> insertMunicipio(
            @Valid @RequestBody MunicipioRequest request) throws Exception {
        return municipioService.insert(request);
    }


}
