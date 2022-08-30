package com.javainuse.swaggertest.data.models;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name="RL_TIPO_GERAL_TIPO_GERAL_FILTRO")
public class TipoGeralTipoGeralFiltro {

	@ApiModelProperty(notes = "Identificador sequencial.",
			example = "1", required = true, position = 0)
	@Id
	@Column (name="id_Tipo_Geral_Tipo_Geral_Filtro")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTipoGeralTipoGeralFiltro;
	
	@ManyToOne
	@JoinColumn(name = "id_Tipo_Geral")
	private TipoGeral tipoGeral;
	
	@ManyToOne
	@JoinColumn(name = "id_Tipo_Geral_Filtro")
	private TipoGeralFiltro tipoGeralFiltro;


}