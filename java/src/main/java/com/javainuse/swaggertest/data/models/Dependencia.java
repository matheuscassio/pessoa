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
@Table(name="tb_dependencia")
public class Dependencia {

	@ApiModelProperty(notes = "Identificador sequencial.",
			example = "1", required = true, position = 0)
	@Id
	@Column (name="id_Depedencia")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDependencia;
	
	@ManyToOne
	@JoinColumn(name = "id_Pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "id_PessoaDependente")
	private Pessoa pessoaDependente;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_TipoDependencia")
	private TipoGeral tipoDependencia	;


}