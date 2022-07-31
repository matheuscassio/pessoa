package com.javainuse.swaggertest.data.playloads.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PessoaRequest {

    @NotBlank
    @NotNull
    private String hash;

    @NotBlank
    @NotNull
    private String nomeMae;


}
