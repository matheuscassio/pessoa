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
@Table(name="tb_Pessoa_Nome")
public class PessoaNome {
	
	@Id
	@Column (name="id_Pessoa_nome")
	//@GeneratedValue(strategy = GeneratioType.IDENTITY)
	private long id;
	
	private Pessoa pessoa;
	
	private PessoaDocumento pessoaDocumento;
	
	@Column (name="nm_Pessoa")
	private String nomePessoa;
	

}
