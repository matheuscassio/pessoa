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
	@Table(name="TB_PESSOA_CONTATOS")
public class PessoaContato {

	@ApiModelProperty(notes = "Identificador sequencial.",
			example = "1", required = true, position = 0)
	@Id
	@Column (name="ID_PESSSOA_CONTATO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_Pessoa")
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Tipo_Contato")
	private TipoGeral tipoContato;
	
	@Column (name="nm_Contato")
	private String nomeContato;
	
	@Column (name="ds_Contato")
	private String descricaoContato;

}
