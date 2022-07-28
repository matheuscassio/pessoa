package com.javainuse.swaggertest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tb_Pessoa")
public class Pessoa {
	
	@Id
	@Column (name="id_Pessoa")
	//@GeneratedValue(strategy = GeneratioType.IDENTITY)
	private long idPessoa;
	
	@Column (name="id_Pessoa")
	private String hash;
	
	@Column (name="id_Pessoa")
	private String dataNascimento;
	
	@Column (name="id_Pessoa")
	private String nomeMae;
	
	//gerar get in sets

}

