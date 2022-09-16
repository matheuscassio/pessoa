package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.TipoGeralFiltro;
import com.javainuse.swaggertest.data.playloads.request.TipoGeralFiltroRequest;
import com.javainuse.swaggertest.service.TipoGeralFiltroService;
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
@RequestMapping("/v1/tippo/geral/filtro")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class TipoGeralFiltroController {
	
    private final TipoGeralFiltroService tipoGeralFiltroService;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipo-geral-filtro-controller", value = "Listar todas od tipos geral do filtro.")
    public ArrayList<TipoGeralFiltro> listarTipoGeralFiltro() throws Exception {
        final Optional<ArrayList<TipoGeralFiltro>> lista = tipoGeralFiltroService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{idTipoGeralFiltro}", name = "idTipoGeralFiltro")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipo-geral-filtro-controller", value = "Recuperar tipo geral filtro.")
    public TipoGeralFiltro findById(
            @ApiParam(name = "idTipoGeralFiltro",
                    value = "Código de tipo geral filtro.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) final Integer idTipoGeralFiltro) throws Exception {
        final Optional<TipoGeralFiltro> tipoGeralFiltro = tipoGeralFiltroService.findById(idTipoGeralFiltro);
        if (tipoGeralFiltro.isPresent()) {
            return tipoGeralFiltro.get();
        } else {
            return null;
        }
    }
	 @DeleteMapping("/{idTipoGeralFiltro}")
	 @ResponseStatus(HttpStatus.OK)
	 @ApiOperation(tags = "tipo-geral-filtro-controller", value = "Deletar um tipo-geral-filtro-controllerda tabela.")
	 public Boolean idTipoGeralFiltro(
	         @ApiParam(name = "idTipoGeralFiltro",
	                 value = "Código de tipo-geral-filtro-controller.",
	                 example = "1",
	                 required = true)
	         @PathVariable(required = true) final Integer idTipoGeralFiltro) throws Exception {
	     return tipoGeralFiltroService.deleteById(idTipoGeralFiltro);
	 }
    
    /*

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
