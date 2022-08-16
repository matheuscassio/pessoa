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
@ApiModel(value = "PessoaSituacaoRequest", description = "Modelo que representa uma requisição para alterar uma situação de Pessoa.")
public class PessoaSituacaoRequest {

    @ApiModelProperty(notes = "Código de identificação da Pessoa.",
            example = "1", required = true, position = 0)
    private Integer idPessoa;
	
	@ApiModelProperty(value = "Código de identificação do Tipo da Situação",
            example = "1", required = true, position = 1)
	private Integer idTipoSituacao;
	

    @ApiModelProperty(value = "Data da Situaçao.", position = 1)
    @NotNull(message = "A Data não pode ser nulo.")
    private String dataSituacao;
    
   
}
