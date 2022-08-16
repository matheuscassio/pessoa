package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.TipogeralFiltro;
import com.javainuse.swaggertest.data.playloads.request.TipogeralFiltroRequest;
import com.javainuse.swaggertest.service.TipogeralFiltroService;
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
@RequestMapping("/v1/tipogeralFiltro")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class TipogeralFiltroController {

    /*private final TipogeralFiltroService tipogeralFiltroService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipogeralFiltro-controller", value = "Listar todas os TipogeralFiltro da tabela.")
    public ArrayList<TipogeralFiltro> listarTipogeralFiltro() throws Exception {
        final Optional<ArrayList<TipogeralFiltro>> lista = tipogeralFiltroService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{idTipogeralFiltro}", name = "idTipogeralFiltro")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipogeralFiltro-controller", value = "Recuperar um TipogeralFiltro.")
    public TipogeralFiltro findById(
            @ApiParam(name = "idTipogeralFiltro",
                    value = "Código de TipogeralFiltro.",
                    example = "1",
                    required = true)
            final @PathVariable(required = true) Integer idTipogeralFiltro) throws Exception {
        final Optional<TipogeralFiltro> tipogeralFiltro = tipogeralFiltroService.findById(idTipogeralFiltro);
        if (tipogeralFiltro.isPresent()) {
            return tipogeralFiltro.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{idTipogeralFiltro}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipogeralFiltro-controller", value = "Deletar um TipogeralFiltro da tabela.")
    public Boolean deleteMunicipio(
            @ApiParam(name = "idTipogeralFiltro",
                    value = "Código de TipogeralFiltro.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idTipogeralFiltro) throws Exception {
        return tipogeralFiltroService.deleteById(idTipogeralFiltro);
    }

    @PutMapping("/{idTipogeralFiltro}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipogeralFiltro-controller", value = "Alterar os dados de um TipogeralFiltro da tabela.")
    public Integer updateMunicipio(
            @ApiParam(name = "idTipogeralFiltro",
                    value = "Código de TipogeralFiltro.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idTipogeralFiltro,
            @Valid @RequestBody TipogeralFiltroRequest request) throws Exception {
        return tipogeralFiltroService.update(idTipogeralFiltro, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
   @ApiOperation(tags = "tipogeralFiltro-controller", value = "Incluir dados de um TipogeralFiltro na tabela.")
    public Integer insertTipogeralFiltro(
           @Valid @RequestBody TipogeralFiltroRequest request) throws Exception {
       return tipogeralFiltroService.insert(request);
   }
*/
}
