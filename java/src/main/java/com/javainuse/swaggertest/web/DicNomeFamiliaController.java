package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.DicNomeFamilia;
import com.javainuse.swaggertest.data.playloads.request.DicNomeFamiliaRequest;
import com.javainuse.swaggertest.service.DicNomeFamiliaService;
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
@RequestMapping("/v1/DicNomeFamiliav1")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
//@Tag(name = "Dependencias", description = "Operações relativas ao Cadastro de Pessoas")
public class DicNomeFamiliaController {

    private final DicNomeFamiliaService DicNomeFamiliaService = null;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "DicNomeFamilia", value = "Listar todas as pessoas da tabela contato.")
    public ArrayList<DicNomeFamilia> listarPessoasConato() throws Exception {
        final Optional<ArrayList<DicNomeFamilia>> lista = DicNomeFamiliaService.getAll();
        if (lista.isPresent()) {
            return lista.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{idDicNomeFamilia}", name = "idDicNomeFamilia")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "DicNomeFamilia", value = "Recuperar uma DicNomeFamilia.")
    public DicNomeFamilia findById(
            @ApiParam(value = "Código digital de DicNomeFamilia.", required = true)
            final @PathVariable(required = true) String idDependencia) throws Exception {
        final Optional<DicNomeFamilia> dicNomeFamilia = dicNomeFamiliaService.findById(idDicNomeFamilia);
        if (DicNomeFamilia.isPresent()) {
            return DicNomeFamilia.get();
        } else {
            return null;
        }
    }

 
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "dicNomeFamilia", value = "Deletar uma DicNomeFamilia da tabela.")
    public Boolean deleteDependencia(@ApiParam(value = "Código de identificação da Dependencia.", required = true) final @PathVariable(required = true) Integer id) throws Exception {
        return dicNomeFamiliaService.deleteById(idDicNomeFamilia);
    }

    @PutMapping("/{idDicNomeFamilia}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "DicNomeFamilia", value = "Alterar os dados de uma DicNomeFamilia da tabela.")
    Integer updateDepencia(
            @ApiParam(value = "Código de identificação da PessoasConato.", required = true) final @PathVariable(required = true) Integer id,
            @Valid @RequestBody DicNomeFamiliaRequest request) throws Exception {
        return dicNomeFamiliaService.update(id, request);
    }

    @PostMapping("/concepcao")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "PessoasContato", value = "Incluir dados de uma pessoas na tabela.")
    Integer  insertPessoaContato(
            @Valid @RequestBody DicNomeFamiliaRequest request) throws Exception {
        return dicNomeFamiliaService.insert(request);
    }


}