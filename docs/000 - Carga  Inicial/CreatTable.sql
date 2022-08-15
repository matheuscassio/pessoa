USE pessoa ; 

CREATE TABLE `tb_pessoa` (
  `id_Pessoa`INT NOT NULL AUTO_INCREMENT COMMENT 'Identificação sequêncial de Pessoa.',
  `tx_Hash` VARCHAR(50) NULL DEFAULT NULL COMMENT 'Algoritmo utilizado para garantir a integridade dos dados da',
  `dt_Nascimento` DATE NOT NULL COMMENT 'Data de nascimento pra criação do Hash',
  `nm_Genitor` VARCHAR (100) NOT NULL COMMENT 'Nome da Mae pra criação do Hash',
  `st_Embriao` BOOLEAN DEFAULT TRUE COMMENT 'Identificaçao da Construção do Hash',
  PRIMARY KEY (`id_Pessoa`),
  UNIQUE KEY (`tx_Hash`)
) COMMENT 'Tabela para o cadastro de Pessoa Física e Jurídica ';


CREATE TABLE `tb_municipio` (
  `id_Municipio` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificação sequêncial de Municipio',
  `nm_Municipio` VARCHAR(50) NULL DEFAULT NULL COMMENT 'Nome do Municipio',
  PRIMARY KEY (`id_Municipio`),
  UNIQUE KEY (`nm_Municipio`)
) COMMENT 'Municipio ';

-- ---
-- Table 'tb_pessoa_endereco'
-- Vinculação com tb_pessoa
-- ---	
CREATE TABLE `tb_pessoa_endereco` (
  `id_Pessoa_Endereco` INT NOT NULL AUTO_INCREMENT ,
  `id_Pessoa` INT NULL DEFAULT NULL COMMENT 'Chave Estrangeira com tb_pessoa',
  `id_Tipo_Logadouro` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral',
  `id_Municipio` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera para Municipios',
  `nm_Logadouro` VARCHAR(250) NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral',
  `nm_Complemento` VARCHAR(30) NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral',
  `nm_Numero` VARCHAR(20) NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral',
  `nm_Bairro` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral',
  `nm_CEP` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral',
  PRIMARY KEY (`id_Pessoa_Endereco`)
) COMMENT 'Vinculação com tb_pessoa';



-- ---
-- Table 'tb_pessoa_documento'
-- Vinculação com Tabela tb_pessoa
-- ---

		
CREATE TABLE `tb_pessoa_documento` (
  `id_Pessoa_Documento` INT NOT NULL AUTO_INCREMENT COMMENT 'Conecção de chave com a tabela tb_pessoa_nome',
  `id_Pessoa` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_pessoa',
  `id_Tipo_Documento` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral',
  `vr_Documento` VARCHAR (100) NULL DEFAULT NULL  COMMENT 'Numero do Documento',
  `dt_Emissao` DATE NULL DEFAULT NULL  COMMENT 'Data de Emissao do Documento',
  `nm_Orgao_Emissor` VARCHAR (100) NULL DEFAULT NULL  COMMENT 'Numero do Orgao emissor',
  `ds_Serie` VARCHAR (50) NULL DEFAULT NULL  COMMENT 'Descriçao da Serie do Documento',
  PRIMARY KEY (`id_Pessoa_Documento`)
) COMMENT 'Vinculação com Tabela tb_pessoa';

-- ---
-- Table 'tb_tipogeral'
-- Filtro de Geral 
-- ---

		
CREATE TABLE `tb_tipogeral` (
  `id_Tipo_Geral` INTEGER NOT NULL AUTO_INCREMENT ,
  `nm_Tipo_Geral` VARCHAR(100) NOT NULL COMMENT 'Nome do tipo Geral',
  `nm_Filtro` VARCHAR(100) NOT NULL COMMENT 'nome do Filtro',
  PRIMARY KEY (`id_Tipo_Geral`)
) COMMENT 'Filtro de Geral ';

-- ---
-- Table 'tb_pessoa_nome'
-- Nome de Pessoa Física ou Jurídica.
-- ---

		
CREATE TABLE `tb_pessoa_nome` (
  `id_pessoa_Nome` INTEGER NOT NULL AUTO_INCREMENT COMMENT 'Chave-Estrangera da pessoa Nome',
  `id_Pessoa` INT NOT NULL  COMMENT 'Chave-Estrangera de tb_pessoa',
  `id_Pessoa_Documento` INT NOT NULL COMMENT 'Chave-Estrangera de tb_pessoa_documento',
  `nm_Pessoa` VARCHAR(250) NOT NULL COMMENT 'Nome Pessoa',
  PRIMARY KEY (`id_pessoa_Nome`)
) COMMENT 'Nome de Pessoa Física ou Jurídica.';

-- ---
-- Table 'tb_pessoa_contatos'
-- Vinculação com chave pessoa tb_pessoa
-- ---
CREATE TABLE `tb_pessoa_contatos` (
  `id_Pessoa_Contato` INTEGER NOT NULL AUTO_INCREMENT,
  `id_Pessoa` INT NOT NULL COMMENT 'Chave-Estrangera de tb_Pessoa',
  `id_Tipo_Contato` INTEGER NOT NULL COMMENT 'Chave-Estrangera de filtro tb_TipoGeral',
  `nm_Contato` VARCHAR(250) NOT NULL COMMENT 'Chave-Estrangera de filtro tb_TipoGeral',
  `ds_Contato` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_Pessoa_Contato`)
) COMMENT 'Vinculação com chave pessoa tb_Pessoa';

-- #####################################################################################################################		
 CREATE TABLE `tb_dependencia` (
`id_Dependencia`INTEGER NOT NULL AUTO_INCREMENT,
`id_Pessoa` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_pessoa',
`id_Pessoa_Dependente`  INTEGER NOT NULL COMMENT 'Chave-Estrangera de tb_pessoa',
`id_Tipo_Dependencia` INTEGER NOT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral',
  PRIMARY KEY (`id_Dependencia`)
) COMMENT 'Vinculação com chave pessoa tb_pessoa';

CREATE TABLE `tb_dic_nome` (
`id_Dic_Nome` INTEGER NOT NULL AUTO_INCREMENT ,
`id_Tipo_Sexo` Integer NOT NULL COMMENT 'Tipo do sexo masculimo feminino',
`tx_Nome` VARCHAR(100) NOT NULL COMMENT 'texto do nome',
PRIMARY KEY (`id_Dic_Nome`),
UNIQUE KEY (`tx_Nome`)
) COMMENT 'tabea dicionario nome ';

  CREATE TABLE `tb_dic_nome_Familia` (
 `id_DicNomeFamilia` INTEGER NOT NULL AUTO_INCREMENT ,
 `tx_Nome_Familia` VARCHAR(100) NOT NULL COMMENT 'texto do nome familia',
 PRIMARY KEY(`id_DicNomeFamilia`),
 UNIQUE KEY (`tx_Nome_Familia`)
  ) COMMENT 'tabea dicionario nome familia ';
-- ###############################################################################################################3
-- ---
-- Foreign Keys fkdic_nome_familia_tbDicNomeFamilia_idDicNomeFamilia
-- ##########################################################################################################################################

ALTER TABLE `tb_dependencia` ADD CONSTRAINT fkDependencia_tbPessoa_idPessoa FOREIGN KEY (id_Pessoa) REFERENCES `tb_pessoa` (`id_pessoa`);
ALTER TABLE `tb_dependencia` ADD CONSTRAINT fkPessoaDependente_tbPessoa_idPessoa FOREIGN KEY (id_Pessoa) REFERENCES `tb_pessoa` (`id_Pessoa`);
ALTER TABLE `tb_dependencia` ADD CONSTRAINT fkTipoDependencia_tbTipoGeral_idTipoGeral FOREIGN KEY (id_Tipo_Dependencia) REFERENCES `tb_tipogeral` (`id_Tipo_Geral`);
ALTER TABLE `tb_dic_nome` ADD CONSTRAINT fkDic_Nome_tb_Tipogeral_idTipoGeral FOREIGN KEY (id_Tipo_Sexo) REFERENCES `tb_tipogeral` (`id_Tipo_Geral`);
-- #############################################################################################################


ALTER TABLE `tb_pessoa_endereco` ADD CONSTRAINT fkPessoa_Endereco_tbPessoa_idPessoa FOREIGN KEY (id_Pessoa) REFERENCES `tb_pessoa` (`id_Pessoa`);
ALTER TABLE `tb_pessoa_endereco` ADD CONSTRAINT fkPessoa_Endereco_tbTipoGeral_idTipoGeral FOREIGN KEY (id_Tipo_Logadouro) REFERENCES `tb_tipogeral` (`id_Tipo_Geral`);
ALTER TABLE `tb_pessoa_endereco` ADD CONSTRAINT fkPessoa_Endereco_tbMunicipio_idMunicipio FOREIGN KEY fkPessoa_Endereco_tbMunicipio_idMunicipio(id_Municipio) REFERENCES `tb_municipio` (`id_Municipio`);
ALTER TABLE `tb_pessoa_documento`ADD CONSTRAINT fkPessoa_Documento_tbTipoGeral_idTipoGeral FOREIGN KEY (id_Pessoa) REFERENCES `tb_pessoa` (`id_Pessoa`);
ALTER TABLE `tb_pessoa_documento`ADD CONSTRAINT fkPessoa_Documento_tbPessoa_idPessoa FOREIGN KEY (id_Tipo_Documento) REFERENCES `tb_tipogeral` (`id_Tipo_Geral`);
ALTER TABLE `tb_pessoa_nome` ADD CONSTRAINT fkPessoa_Nome_tbPessoa_idPessoa FOREIGN KEY (id_Pessoa) REFERENCES `tb_pessoa` (`id_Pessoa`);
ALTER TABLE `tb_pessoa_nome` ADD CONSTRAINT fkPessoa_Nome_tbPessoaDocumento_idPessoaDocumento FOREIGN KEY (id_Pessoa_Documento) REFERENCES `tb_pessoa_documento` (`id_Pessoa_Documento`);
ALTER TABLE `tb_pessoa_contatos` ADD CONSTRAINT fkPessoa_Contatos_tbPessoa_idPessoa FOREIGN KEY (id_Pessoa) REFERENCES `tb_pessoa` (`id_Pessoa`);
ALTER TABLE `tb_pessoa_contatos` ADD CONSTRAINT fkPessoa_Contatos_tbTipoGeral_idTipoGeral FOREIGN KEY (id_Tipo_Contato) REFERENCES `tb_tipogeral` (`id_Tipo_Geral`);

