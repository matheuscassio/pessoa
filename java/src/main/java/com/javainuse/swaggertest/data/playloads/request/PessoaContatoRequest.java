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
@ApiModel(value = "PessoaContatoRequest", description = "Modelo que representa uma requisição para alterar contato de pessoa.")
public class PessoaContatoRequest {
	
	
	@ApiModelProperty(value = "Código de identificação da Pessoa")
	private Long Pessoa;
	
	@ApiModelProperty(value = "Código de identificação da Pessoa Documento")
	private Long idPessoaDocumento;
	//DUVIDA
	@ApiModelProperty(value = "Código de identificação de Tipo GEral")
	private Long idTipoGeral;

    @ApiModelProperty(value = "Nome do Contato.", position = 1)
    @NotNull(message = "o nome do contato não pode seer nulo.")
    private String nomeContato;

    @ApiModelProperty(value = "Descrição do Contato.", position = 1)
    @NotNull(message = "Descrição do Contato não pode ser nulo.")
    private String descricaoContato;
}
