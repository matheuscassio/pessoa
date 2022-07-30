package com.javainuse.swaggertest.model;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Data
@Table(name="tb_Pessoa_Documento")
public class PessoaDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name="id_Pessoa_Documento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_id_pessoa")
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Tipo_Documento")
	private TipoGeral tipoGeral;
	
	@Column (name = "vr_Documento")
	private String valorDocumento;
	
	@Column (name = "dt_Emissao")
	private String dataEmissao;
	
	@Column (name = "nm_OrgaoEmissor")
	private String nomeOrgaoEmissor;
	
	@Column (name = "ds_Serie")
	private String descricaoSerie;
	
	
	
	

}
