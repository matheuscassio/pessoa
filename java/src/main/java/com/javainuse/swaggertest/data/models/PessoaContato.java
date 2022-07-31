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
@Table(name="tb_Pessoa_Contato")
public class PessoaContato {
	
	@Id
	@Column (name="id_Pessoa_Contato")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id_pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_documento_id_pessoa_documento")
	private PessoaDocumento pessoaDocumento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Tipo_Contato")
	private TipoGeral tipoGeral;
	
	@Column (name="nm_Contato")
	private String nomeContato;
	
	@Column (name="ds_Contato")
	private String descricaoContato;
	
	

}
