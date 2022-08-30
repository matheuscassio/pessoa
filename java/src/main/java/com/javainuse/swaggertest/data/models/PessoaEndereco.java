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
@Table(name="TB_PESSOA_ENDERECO")
public class PessoaEndereco{

	@ApiModelProperty(notes = "Identificador sequencial.",
			example = "1", required = true, position = 0)
	@Id
	@Column (name="id_Pessoa_Endereco")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Pessoa")
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Tipo_Logadouro")
	private TipoGeral tipoGeral;
	
	@ManyToOne(fetch = FetchType.EAGER)
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
	private Integer nomeCep;
	
	
	
	
	
	

}
;