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
@ApiModel(value = "TipogeralTipogeralFiltroRequest", description = "Modelo que representa uma requisição para alterar uma tb TipogeralTipogeralFiltroRequest.")
public class TipogeralTipogeralFiltroRequest {

	@ApiModelProperty(value = "Código de identificação da TipogeralTipogeralFiltroRequest.",
			example = "1", required = true, position = 1)
	private Integer idTipoGeral;

	@ApiModelProperty(value = "Código de identificação da pessoa dependente",
			example = "1", required = true, position = 1)
	private Integer idTipogeralFiltro;

}
