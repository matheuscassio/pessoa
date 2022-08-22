package com.javainuse.swaggertest.data.playloads.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PessoaDocumentoRequest", description = "Modelo que representa uma requisição para alterar uma pessoa documento.")
public class PessoaDocumentoRequest {

    @ApiModelProperty(notes = "Código de identificação da Pessoa.",
            example = "1", required = true, position = 0)
    private Integer idPessoa;
	
	@ApiModelProperty(value = "Código de identificação do Tipo de Documento",
            example = "1", required = true, position = 1)
	private Integer idTipoDocumento;
	
    @ApiModelProperty(value = "valor do documento", position = 1)
    @NotNull(message = "Valo do Documento não pode ser nula.")
    private String valorDocumento;

    @ApiModelProperty(value = "Data de Emissão.", position = 1)
    @NotNull(message = "A Data não pode ser nulo.")
    private Date dataEmissao;
    
    @ApiModelProperty(value = "Nome do Orgão Emissor.", position = 1)
    @NotNull(message = "O nome do Orgão não pode ser nulo.")
    private String nomeOrgaoEmissor;
    
    @ApiModelProperty(value = "Descrição Serie.", position = 1)
    @NotNull(message = "Decrição de Serie.")
    private String descricaoSerie;
}
