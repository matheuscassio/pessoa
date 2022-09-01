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
@ApiModel(value = "DicNomeFamiliaRequest", description = "Modelo que representa uma requisição para alterar SobreNome ficticio .")
public class DicNomeFamiliaRequest {

    @ApiModelProperty(value = "Texto do Nome familia", position = 1)
    @NotNull(message = "Texto do Nome não pode ser nula.")
    private String textoNomeFamilia;

 
}

