package com.javainuse.swaggertest.data.playloads.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "DicNomeRequest", description = "Modelo que representa uma requisição para alterar nome ficticio.")
public class DicNomeRequest {

    @ApiModelProperty(notes = "Código de identificação da Dicionario Nome.",
            example = "1", required = true, position = 0)
    private Integer idDicNomeRequest;
	
	@ApiModelProperty(value = "Código de identificação do Tipo do Sexo Masculino Feminico",
            example = "1", required = true, position = 1)
	private Integer idTipoSexo;
	
    @ApiModelProperty(value = "Texto do Nome", position = 1)
    @NotNull(message = "Texto do Nomenão pode ser nula.")
    private String nome;

 
}

