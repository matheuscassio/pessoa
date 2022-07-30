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
@Table(name="tb_Pessoa_Contato")
public class PessoaContato {
	
	@Id
	@Column (name="id_Pessoa_Contato")
	//@GeneratedValue(strategy = GeneratioType.IDENTITY)
	private long id;
	
	private Pessoa pessoa;
	
	private PessoaDocumento pessoaDocumento;
	
	private TipoGeral tipoGeral;
	
	@Column (name="nm_Contato")
	private String nomeContato;
	
	@Column (name="ds_Contato")
	private String descricaoContato;
	
	

}
