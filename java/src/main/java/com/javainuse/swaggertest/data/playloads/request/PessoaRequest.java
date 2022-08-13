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
@ApiModel(value = "PessoaRequest", description = "Modelo que representa uma requisição para alterar uma pessoa.")
public class PessoaRequest {

    @ApiModelProperty(value = "Data de Nascimento da Pessoa.")
    @NotNull(message = "A data de nascimento não pode ser nula.")
    private Date dataNascimento;

    @ApiModelProperty(value = "O nome do Genitor da Pessoa.")
    @NotNull(message = "O nome do Genitor não pode ser nulo.")
    private String nomeGenitor;
}
