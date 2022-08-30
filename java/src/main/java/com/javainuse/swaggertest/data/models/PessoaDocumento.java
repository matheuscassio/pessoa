package com.javainuse.swaggertest.data.models;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name="TB_PESSOA_DOCUMENTO")
public class PessoaDocumento {

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
	@JoinColumn(name = "id_Tipo_Documento")
	private TipoGeral tipoDocumento;
	
	@Column (name = "vr_Documento")
	private String valorDocumento;
	
	@Column (name = "dt_Emissao")
	private String dataEmissao;
	
	@Column (name = "nm_Orgao_Emissor")
	private String nomeOrgaoEmissor;
	
	@Column (name = "ds_Serie")
	private String descricaoSerie;

}
