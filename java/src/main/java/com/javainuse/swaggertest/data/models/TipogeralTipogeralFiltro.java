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
@Table(name="rl_Tipogeral_tipogeralfiltro")
public class TipogeralTipogeralFiltro {

	@ApiModelProperty(notes = "Identificador sequencial.",
			example = "1", required = true, position = 0)
	@Id
	@Column (name="id_Tipogeral_Tipogeralfiltroo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTipogeralTipogeralfiltroo;
	
	@ManyToOne
	@JoinColumn(name = "id_Tipo_Geral")
	private TipoGeral tipoGeral;
	
	@ManyToOne
	@JoinColumn(name = "id_Tipogeral_Filtro")
	private TipogeralFiltro tipogeralFiltro;


}