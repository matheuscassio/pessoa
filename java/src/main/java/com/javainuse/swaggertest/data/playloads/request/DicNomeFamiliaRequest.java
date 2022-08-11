package com.javainuse.swaggertest.data.playloads.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;*/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "DicNomeFamiliaRequest", description = "Modelo que representa uma requisição para alterar SobreNome ficticio .")
public class DicNomeFamiliaRequest {

    @ApiModelProperty(notes = "Código de identificação da Dicionario Nome Familia.",
            example = "1", required = true, position = 0)
    private Integer id;
	
	
    @ApiModelProperty(value = "Texto do Nome familia", position = 1)
    @NotNull(message = "Texto do Nome não pode ser nula.")
    private String nomeFamilia;

 
}

