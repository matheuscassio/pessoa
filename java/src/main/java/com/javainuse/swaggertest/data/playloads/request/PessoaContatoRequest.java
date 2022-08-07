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

    @ApiModelProperty(notes = "Código de identificação da Pessoa.",
            example = "1", required = true, position = 0)
	private Integer idPessoa;

    @ApiModelProperty(notes = "Código de identificação de Tipo Contato.",
            example = "1", required = true, position = 1)
	private Integer idTipoContato;

    @ApiModelProperty(value = "Nome do Contato.")
    @NotNull(message = "o nome do contato não pode seer nulo.")
    private String nomeContato;

    @ApiModelProperty(value = "Descrição do Contato.")
    @NotNull(message = "Descrição do Contato não pode ser nulo.")
    private String descricaoContato;
}
