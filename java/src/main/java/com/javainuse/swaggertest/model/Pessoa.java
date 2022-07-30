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
@Table(name="tb_Pessoa")
public class Pessoa {
	
	@Id
	@Column (name="id_Pessoa")
	//@GeneratedValue(strategy = GeneratioType.IDENTITY)
	private long id;
	
	@Column (name="tx_Hach")
	private String hash;
	
	@Column (name="idt_Nascimento")
	private String dataNascimento;
	
	@Column (name="nm_Mae")
	private String nomeMae;
	
	//gerar get in sets

}

