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
import com.javainuse.swaggertest.data.models.Dependencia;
import com.javainuse.swaggertest.data.playloads.request.DependenciaRequest;
import com.javainuse.swaggertest.service.DependenciaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/v1/dependencia")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class DependenciaController {

    private final DependenciaService dependenciaService;

    @GetMapping(value = "/{idDependencia}", name = "idDependencia")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "dependencia-controller", value = "Recuperar uma Dependencia.")
    public Dependencia findById(
            @ApiParam(value = "Código digital de Dependencia.", required = true)
            final @PathVariable(required = true) Integer idDependencia) throws Exception {
        final Optional<Dependencia> dependencia = dependenciaService.findById(idDependencia);
        if (dependencia.isPresent()) {
            return dependencia.get();
        } else {
            return null;
        }
    }
    /*
    @DeleteMapping("/{idDependencia}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "dependencia-controller", value = "Deletar uma Dependencia da tabela.")
    public Boolean deleteDependencia(
            @ApiParam(name = "idDependencia",
            value = "Código de Dependencia .",
            example = "1",
            required = true)
            @PathVariable(required = true) final Integer idDependencia) throws Exception {
    	        return dependenciaService.deleteById(idDependencia);
    }

    @PutMapping("/{idDependencia}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "dependencia-controller", value = "Alterar os dados de uma Dependencia da tabela.")
    Integer updateDepencia(
            @ApiParam(name = "idDependencia",
            value = "Código de Dependencia .",
            example = "1",
            required = true)
            @PathVariable(required = true) final Integer idDependencia,
            @Valid @RequestBody DependenciaRequest request) throws Exception {
        return dependenciaService.update(idDependencia, request);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "dependencia-controller", value = "Incluir dados de Dependencia.")
    Integer  insertDependencia(
            @Valid @RequestBody DependenciaRequest request) throws Exception {
        return dependenciaService.insert(request);
    }
*/
}
