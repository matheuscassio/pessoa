package com.javainuse.swaggertest.data.models;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="tb_pessoa_documento")
public class PessoaDocumento implements Serializable {

	@ApiModelProperty(notes = "Identificador sequencial.",
			example = "1", required = true, position = 0)
	@Id
	@Column (name="id_Pessoa_Documento")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Pessoa")
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_TipoDocumento")
	private TipoGeral tipoDocumento;
	
	@Column (name = "vr_Documento")
	private String valorDocumento;
	
	@Column (name = "dt_Emissao")
	private String dataEmissao;
	
	@Column (name = "nm_OrgaoEmissor")
	private String nomeOrgaoEmissor;
	
	@Column (name = "ds_Serie")
	private String descricaoSerie;
	
	
	
	

}
