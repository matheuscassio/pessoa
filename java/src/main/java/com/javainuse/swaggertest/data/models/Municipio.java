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
@Table(name="tb_Munucipio")
public class Municipio{
	
	@Id
	@Column (name="id_Municipio")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column (name="nm_Municipio")
	private String nomeMunicipio;
	
	
	
}