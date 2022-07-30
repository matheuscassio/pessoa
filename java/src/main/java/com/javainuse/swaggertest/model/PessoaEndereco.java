package com.javainuse.swaggertest.model;

import javax.persistence.*;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_Pessoa")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "id_TipoLogradouro")
	private TipoGeral tipoGeral;
	
	@ManyToOne
	@JoinColumn(name = "id_Municipio")
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