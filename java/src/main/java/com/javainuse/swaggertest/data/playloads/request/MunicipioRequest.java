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
@ApiModel(value = "MunicipioRequest", description = "Modelo que representa uma requisição para alterar Município.")
public class MunicipioRequest {

    @ApiModelProperty(value = "Nome do Município.", position = 1)
    @NotNull(message = "O nome do Município não pode ser nulo !")
    private String nomeMunicipio;

}
