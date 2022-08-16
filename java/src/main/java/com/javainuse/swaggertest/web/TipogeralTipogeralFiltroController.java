
package com.javainuse.swaggertest.web;

import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.javainuse.swaggertest.data.models.TipogeralTipogeralFiltro;
import com.javainuse.swaggertest.data.playloads.request.TipogeralTipogeralFiltroRequest;
import com.javainuse.swaggertest.service.TipogeralTipogeralFiltroService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/v1/tipogeralTipogeralFiltro")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class TipogeralTipogeralFiltroController {

    private final TipogeralTipogeralFiltroService tipogeralTipogeralFiltroService;

    @GetMapping(value = "/{idTipogeralTipogeralFiltro}", name = "idTipogeralTipogeralFiltro")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipogeralTipogeralFiltro-controller", value = "Recuperar um TipogeralTipogeralFiltro.")
    public TipogeralTipogeralFiltro findById(
            @ApiParam(value = "Código digital de TipogeralTipogeralFiltro.", required = true)
            final @PathVariable(required = true) Integer idTipogeralTipogeralFiltro) throws Exception {
        final Optional<TipogeralTipogeralFiltro> tipogeralTipogeralFiltro = tipogeralTipogeralFiltroService.findById(idTipogeralTipogeralFiltro);
        if (tipogeralTipogeralFiltro.isPresent()) {
            return tipogeralTipogeralFiltro.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{idTipogeralTipogeralFiltro}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipogeralTipogeralFiltro-controller", value = "Deletar uma TipogeralTipogeralFiltro da tabela.")
    public Boolean deleteTipogeralTipogeralFiltro(
            @ApiParam(name = "idTipogeralTipogeralFiltro",
            value = "Código de TipogeralTipogeralFiltro .",
            example = "1",
            required = true)
            @PathVariable(required = true) final Integer idTipogeralTipogeralFiltro) throws Exception {
    	        return tipogeralTipogeralFiltroService.deleteById(idTipogeralTipogeralFiltro);
    }

    @PutMapping("/{idTipogeralTipogeralFiltro}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipogeralTipogeralFiltro-controller", value = "Alterar os dados de um TipogeralTipogeralFiltro da tabela.")
    Integer updateDepencia(
            @ApiParam(name = "idTipogeralTipogeralFiltro",
           value = "Código de TipogeralTipogeralFiltro .",
            example = "1",
            required = true)
            @PathVariable(required = true) final Integer idTipogeralTipogeralFiltro,
            @Valid @RequestBody TipogeralTipogeralFiltroRequest request) throws Exception {
        return tipogeralTipogeralFiltroService.update(idTipogeralTipogeralFiltro, request);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipogeralTipogeralFiltro-controller", value = "Incluir dados de TipogeralTipogeralFiltro.")
    Integer  insertDependencia(
            @Valid @RequestBody TipogeralTipogeralFiltroRequest request) throws Exception {
        return tipogeralTipogeralFiltroService.insert(request);
    }

}




