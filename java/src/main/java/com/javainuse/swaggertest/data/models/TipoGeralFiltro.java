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
@Table(name="tb_tipo_geral_filtro")
public class TipoGeralFiltro {

	@ApiModelProperty(notes = "Identificador sequencial.",
			example = "1", required = true, position = 0)
	@Id
	@Column (name="id_TipoGeralFiltro")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column (name="nm_Filtro")
	private String nomeFiltro;
	
}