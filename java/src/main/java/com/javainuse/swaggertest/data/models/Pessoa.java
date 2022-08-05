package com.javainuse.swaggertest.data.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name="id_Pessoa")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column (name="tx_Hash")
	private String hash;
	
	@Column (name="dt_Nascimento")
	private Date dataNascimento;
	
	@Column (name="nm_Mae")
	private String nomeMae;

}

