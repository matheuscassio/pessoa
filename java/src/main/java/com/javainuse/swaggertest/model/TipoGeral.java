package com.javainuse.swaggertest.model;

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
@Table(name="tb_TipoGeral")
public class TipoGeral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_TipoGeral", nullable = false)
	private Long id;
	
	@Column (name="nm_TipoGeral")
	private String nomeTipoGeral;
	
	@Column (name="nm_Filtro")
	private String nomeFiltro;



}