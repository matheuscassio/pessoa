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
@Table(name="tb_Munucipio")
public class Municipio{
	
	@Id
	@Column (name="id_Municipio")
	//@GeneratedValue(strategy = GeneratioType.IDENTITY)
	private long id;
	
	@Column (name="nm_Municipio")
	private String nomeMunicipio;
	
	
	
}