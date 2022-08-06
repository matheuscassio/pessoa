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
	@Table(name="tb_dic_nome_familia")
	public class DicNomeFamilia{

		@ApiModelProperty(notes = "Identificador sequencial.",
				example = "1", required = true, position = 0)
		@Id
		@Column (name="id_DicNomeFamilia")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		
		@Column (name="tx_NomeFamilia")
		private String textoNomeFamilia;
	}
		

