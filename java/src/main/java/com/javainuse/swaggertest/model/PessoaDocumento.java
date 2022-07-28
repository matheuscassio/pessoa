package com.javainuse.swaggertest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name="tb_Pessoa_Documento")
public class PessoaDocumento {
	
	@Id
	@Column (name="id_Documento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_PessoaDocumento;
	
	private Pessoa pessoa;
	
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
