package com.javainuse.swaggertest.data.playloads.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TipogeralFiltroRequest", description = "Modelo que representa uma requisição para alterar TipogeralFiltro.")
public class TipoGeralFiltroRequest {

    @ApiModelProperty(value = "Nome do Filtro.", position = 1)
    @NotNull(message = "O nome do Filtro não pode ser nulo !")
    private String nomeFiltro;
    
    
  
}
