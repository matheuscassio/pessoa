package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.Municipio;
import com.javainuse.swaggertest.data.playloads.request.MunicipioRequest;
import com.javainuse.swaggertest.service.MunicipioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/v1/municipio")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class MunicipioController {
	  
    private final MunicipioService municipioService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "municipio-controller", value = "Listar todas os municipios da tabela.")
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
    @ApiOperation(tags = "municipio-controller", value = "Recuperar um Municipio.")
    public Municipio findById(
            @ApiParam(name = "idMunicipio",
                    value = "Código de Município.",
                    example = "1",
                    required = true)
            final @PathVariable(required = true) Integer idMunicipio) throws Exception {
        final Optional<Municipio> municipio = municipioService.findById(idMunicipio);
        if (municipio.isPresent()) {
            return municipio.get();
        } else {
            return null;
        }
    }
	 @DeleteMapping("/{idMunicipio}")
	 @ResponseStatus(HttpStatus.OK)
	 @ApiOperation(tags = "municipio-controller", value = "Deletar um Municipio da tabela.")
	 public Boolean deleteMunicipio(
	         @ApiParam(name = "idMunicipio",
	                 value = "Código de Municipio.",
	                 example = "1",
	                 required = true)
	         @PathVariable(required = true) final Integer idMunicipio) throws Exception {
	     return municipioService.deleteById(idMunicipio);
	 }
    
    

    @PutMapping("/{idMunicipio}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "municipio-controller", value = "Alterar os dados de um Município da tabela.")
    public Integer updateMunicipio(
            @ApiParam(name = "idMunicipio",
                    value = "Código de Município.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idMunicipio,
            @Valid @RequestBody MunicipioRequest request) throws Exception {
        return municipioService.update(idMunicipio, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "municipio-controller", value = "Incluir dados de um Município na tabela.")
    public Integer insertMunicipio(
            @Valid @RequestBody MunicipioRequest request) throws Exception {
        return municipioService.insert(request);
    }
    /**/
}
