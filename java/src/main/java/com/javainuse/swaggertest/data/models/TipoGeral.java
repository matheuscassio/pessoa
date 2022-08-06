package com.javainuse.swaggertest.data.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name="tb_tipogeral")
public class TipoGeral {

	@ApiModelProperty(notes = "Identificador sequencial.",
			example = "1", required = true, position = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_TipoGeral", nullable = false)
	private Integer id;
	
	@Column (name="nm_TipoGeral")
	private String nomeTipoGeral;
	
	@Column (name="nm_Filtro")
	private String nomeFiltro;



}