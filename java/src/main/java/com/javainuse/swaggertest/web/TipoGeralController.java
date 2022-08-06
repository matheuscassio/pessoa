package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.TipoGeral;
import com.javainuse.swaggertest.data.playloads.request.TipoGeralRequest;
import com.javainuse.swaggertest.service.TipoGeralService;
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
@RequestMapping("/v1/tipos")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
//@Tag(name = "Pessoas", description = "Operações relativas ao Cadastro de Pessoas")
public class TipoGeralController {

    private final TipoGeralService tipoService = null;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Tipos", value = "Listar todas as tipos da tabela.")
    public ArrayList<TipoGeral> listarTipos() throws Exception {
        final Optional<ArrayList<TipoGeral>> lista = tipoService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{idTipoGeral}", name = "idTipoGeral")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Tipos", value = "Recuperar uma tipos.")
    public Pessoa findByHash(
            @ApiParam(value = "Código digital de Tipo.", required = true)
            final @PathVariable(required = true) String hashPessoa) throws Exception {
        final Optional<TipoGeral> tipoGeral = tipoService.findById(idTipoGeral);
        if (pessoa.isPresent()) {
            return tipos.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{idTipoGeral}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Tipos", value = "Deletar uma tipos da tabela.")
    public Boolean deleteTipoGeral(@ApiParam(value = "Código de identificação da Tipo.", required = true) final @PathVariable(required = true) String id) throws Exception {
        return tipoService.deleteByHash(id);
    }

    @PutMapping("/{idTipoGeral}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Pessoas", value = "Alterar os dados de uma tipos da tabela.")
    public Optional<TipoGeral> updatePessoa(
            @ApiParam(value = "Código de identificação da Pessoa.", required = true) final @PathVariable(required = true) String id,
            @Valid @RequestBody TipoGeralRequest request) throws Exception {
        return tipoService.update(id, request);
    }

    @PostMapping("/concepcao")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "Tipos", value = "Incluir dados de uma tipos na tabela.")
    public Optional<TipoGeral> insertPessoa(
            @Valid @RequestBody TipoGeralRequest request) throws Exception {
        return tipoService.insert(request);
    }


}
