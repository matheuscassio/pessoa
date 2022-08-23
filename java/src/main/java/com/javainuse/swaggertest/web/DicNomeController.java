package com.javainuse.swaggertest.web;

import com.javainuse.swaggertest.data.models.DicNome;
import com.javainuse.swaggertest.data.playloads.request.DicNomeRequest;
import com.javainuse.swaggertest.data.playloads.request.PessoaRequest;
import com.javainuse.swaggertest.service.DicNomeService;
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
@RequestMapping("/v1/dic/nome")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Esta é uma requisição errada, por favor reveja a documentação da API."),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Recurso de segurança acionado. Acesso não permitido."),
        @io.swagger.annotations.ApiResponse(code = 500, message = "O serviço está momentâneamente fora do ar."),
    })
public class DicNomeController {
	
   private final DicNomeService dicNomeService;

   @GetMapping()
   @ResponseStatus(HttpStatus.OK)
   @ApiOperation(tags = "dic-nome-controller", value = "Listar todas Dicionario nome.")
   public ArrayList<DicNome> listarDicNome() throws Exception {
       final Optional<ArrayList<DicNome>> lista = dicNomeService.getAll();
       if (lista.isPresent()) {
           return lista.get();
       } else {
           return null;
       }
   }

   @GetMapping(value = "/{idDicNome}", name = "idDicNome")
   @ResponseStatus(HttpStatus.OK)
   @ApiOperation(tags = "dic-nome-controller", value = "Recuperar Dicionario nome.")
   public DicNome findById(
           @ApiParam(name = "idDicNome",
                   value = "Código Dicionaro Nome.",
                   example = "1",
                   required = true)
           @PathVariable(required = true) final Integer idDicNome) throws Exception {
       final Optional<DicNome> dicNome = dicNomeService.findById(idDicNome);
       if (dicNome.isPresent()) {
           return dicNome.get();
       } else {
           return null;
       }
   }
   
   
		 @DeleteMapping("/{idDicNome}")
		 @ResponseStatus(HttpStatus.OK)
		 @ApiOperation(tags = "dic-nome-controller", value = "Deletar um nome da tabela.")
		 public Boolean deleteDicNome(
		         @ApiParam(name = "idDicNome",
		                 value = "Código de dic nome.",
		                 example = "1",
		                 required = true)
		         @PathVariable(required = true) final Integer idDicNome) throws Exception {
		     return dicNomeService.deleteById(idDicNome);
		 }
   /*
    
    
    @PostMapping("/textoNome")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = "dic-nome-controller", value = "Incluir dados de uma pessoas na tabela.")
    Integer  insertDicNome(
            @Valid @RequestBody DicNomeRequest request) throws Exception {
        return dicNomeService.insert(request);
    }
*/


   }