package com.javainuse.swaggertest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name="tb_TipoGeral")
public class TipoGeral {
	
	@Id
	@Column (name="id_TipoGeral")
	//@GeneratedValue(strategy = GeneratioType.IDENTITY)
	private long id;
	
	@Column (name="nm_TipoGeral")
	private String nomeTipoGeral;
	
	@Column (name="nm_Filtro")
	private String nomeFiltro;
	

}