package com.javainuse.swaggertest.data.playloads.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PessoaNomeRequest", description = "Modelo que representa uma requisição para alterar Nome de pessoa.")
public class PessoaNomeRequest {
	
	@ApiModelProperty(value = "Código de identificação da Pessoa")
	private Long idPessoa;
	
	@ApiModelProperty(value = "Código de identificação da Pessoa")
	private Long idPessoaDocumento;
	
    @ApiModelProperty(value = "Nome Pessoa.", position = 1)
    @NotNull(message = "Nome Pessoa não pode ser nula.")
    private Date dataNascimento;

    
}
