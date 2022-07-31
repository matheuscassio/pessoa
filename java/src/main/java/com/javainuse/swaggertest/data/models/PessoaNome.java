package com.javainuse.swaggertest.data.models;

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
@Table(name="tb_Pessoa_Nome")
public class PessoaNome {
	
	@Id
	@Column (name="id_Pessoa_Nome")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_Pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "id_Pessoa_Documento")
	private PessoaDocumento pessoaDocumento;
	
	@Column (name="nm_Pessoa")
	private String nomePessoa;
	

}
