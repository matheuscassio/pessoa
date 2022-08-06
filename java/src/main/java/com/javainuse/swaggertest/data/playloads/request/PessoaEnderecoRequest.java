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
@ApiModel(value = "PessoaEnderecoRequest", description = "Modelo que representa uma requisição para alterar Endereço de Pessoa.")
public class PessoaEnderecoRequest {
	
	@ApiModelProperty(value = "Código de identificação da Pessoa")
	private Long idPessoa;
	//DUVIDA
	@ApiModelProperty(value = "Código de identificação Tipo Logadouro")
	private Long idTipoLogradouro;
	
	@ApiModelProperty(value = "Código de identificação da Pessoa")
	private Long idMunicipio;
	
	
    @ApiModelProperty(value = "Nome do Logadouro.", position = 1)
    @NotNull(message = "Nome do Logadouro não pode ser nula.")
    private String nomeLogadouro;

    @ApiModelProperty(value = "Nome do Complemento.", position = 1)
    @NotNull(message = "O nome do Complemento não pode ser nulo.")
    private String nomeComplemento;
    
    @ApiModelProperty(value = "Nome do Numero.", position = 1)
    @NotNull(message = "O nome do Numero não pode ser nulo.")
    private String nomeNumero;
    
    @ApiModelProperty(value = "Nome do Bairro.", position = 1)
    @NotNull(message = "O nome do Bairro não pode ser nulo.")
    private String nomeBairro;
    
    @ApiModelProperty(value = "Nome do CEP.", position = 1)
    @NotNull(message = "O nome do CEP não pode ser nulo.")
    private String nomeCep;
}
