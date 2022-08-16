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
@ApiModel(value = "TipoGeralRequest", description = "Modelo que representa uma requisição para alterar Tipo de Contato,Endereço,Documento de  pessoa.")
public class TipoGeralRequest {
	
	
    @ApiModelProperty(value = "Nome do Tipo Geral.", position = 1)
    @NotNull(message = "O nome de Tipo Geral não pode ser nula.")
    private String nomeTipoGeral;

    @ApiModelProperty(value = "O nome Do filtro.", position = 1)
    @NotNull(message = "O nome do Filtro não pode ser nulo.")
    private String nomeFiltro;
    
    @ApiModelProperty(value = "Situacao Ativo.", position = 1)
    @NotNull(message = "A Situacao Ativo não pode ser nulo.")
    private String situacaoAtivo;
}
