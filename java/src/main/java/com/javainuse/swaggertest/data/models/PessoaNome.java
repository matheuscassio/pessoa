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
@Table(name="tb_pessoa_nome")
public class PessoaNome {

	@ApiModelProperty(notes = "Identificador sequencial.",
			example = "1", required = true, position = 0)
	@Id
	@Column (name="id_Pessoa_Nome")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_Pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "id_Pessoa_Documento")
	private PessoaDocumento pessoaDocumento;
	
	@Column (name="nm_Pessoa")
	private String nomePessoa;
	

}
