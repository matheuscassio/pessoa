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
@Table(name="tb_Pessoa_Endereco")
public class PessoaEndereco{
	
	@Id
	@Column (name="id_Pessoa_Endereco")
	//@GeneratedValue(strategy = GeneratioType.IDENTITY)
	private long id;
	
	private Pessoa pessoa;
	
	private PessoaDocumento pessoaDocumento;
	
	private TipoGeral tipoGeral;
	
	private Municipio municipio;
	
	@Column (name="nm_Logadouro")
	private String nomeLogadouro;
	
	@Column (name="nm_Complemento")
	private String nomeComplemento;
	
	@Column (name="nm_Numero")
	private String nomeNumero;
	
	@Column (name="nm_Bairro")
	private String nomeBairro;
	
	@Column (name="nm_CEP")
	private String nomeCep;
	
	
	
	
	
	

}
;