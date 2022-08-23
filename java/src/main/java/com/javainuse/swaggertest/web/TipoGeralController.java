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

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/v1/tipos")
@RequiredArgsConstructor
@Transactional
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class TipoGeralController {

    private final TipoGeralService tipoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipo-geral-controller", value = "Listar todas as tipos da tabela.")
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
    @ApiOperation(tags = "tipo-geral-controller", value = "Recuperar uma tipos.")
    public TipoGeral findByHash(
            @ApiParam(name = "idTipoGeral",
                    value = "Código de identificação de Tipo.",
                    example = "1",
                    required = true)
            final @PathVariable(required = true) Integer idTipoGeral) throws Exception {
        final Optional<TipoGeral> tipoGeral = tipoService.findById(idTipoGeral);
        if (tipoGeral.isPresent()) {
            return tipoGeral.get();
        } else {
            return null;
        }
    }
	 @DeleteMapping("/{idTipoGeral}")
	 @ResponseStatus(HttpStatus.OK)
	 @ApiOperation(tags = "tipo-geral-controller", value = "Deletar um tipo-geral-controller da tabela.")
	 public Boolean idPessoaContato(
	         @ApiParam(name = "idTipoGeral",
	                 value = "Código de tipo-geral-controller.",
	                 example = "1",
	                 required = true)
	         @PathVariable(required = true) final Integer idTipoGeral) throws Exception {
	     return tipoService.deleteById(idTipoGeral);
	 }
/*

    @PutMapping("/{idTipoGeral}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipo-geral-controller", value = "Alterar os dados de uma tipos da tabela.")
    public Integer updatePessoa(
            @ApiParam(name = "idTipoGeral",
                    value = "Código de identificação de Tipo.",
                    example = "1",
                    required = true)
            @PathVariable(required = true) Integer idTipoGeral,
            @Valid @RequestBody TipoGeralRequest request) throws Exception {
        return tipoService.update(idTipoGeral, request);
    }

    @PostMapping
   @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "tipo-geral-controller", value = "Incluir dados de uma tipos na tabela.")
    public Integer insert(
            @Valid @RequestBody TipoGeralRequest request) throws Exception {
        return tipoService.insert(request);
    }
*/

}
