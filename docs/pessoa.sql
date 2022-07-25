-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'tb_Pessoa'
-- Tabela para o cadastro de Pessoa Física e Jurídica 
-- ---

DROP TABLE IF EXISTS `tb_Pessoa`;

		
CREATE TABLE `tb_Pessoa` (
  `id_Pessoa` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificação sequêncial de Pessoa.',
  `tx_Hash` VARCHAR(50) NULL DEFAULT NULL COMMENT 'Algoritmo utilizado para garantir a integridade dos dados da',
  PRIMARY KEY (`id_Pessoa`),
  UNIQUE KEY (`tx_Hash`)
) COMMENT 'Tabela para o cadastro de Pessoa Física e Jurídica ';

-- ---
-- Table 'tb_Pessoa_Endereco'
-- Vinculação com tb_Pessoa
-- ---

DROP TABLE IF EXISTS `tb_Pessoa_Endereco`;
		
CREATE TABLE `tb_Pessoa_Endereco` (
  `id_Pessoa_Endereco` INTEGER NOT NULL AUTO_INCREMENT ,
  `id_Pessoa` INT NULL DEFAULT NULL COMMENT 'Chave Estrangeira com tb_Pessoa',
  `id_TipoLogadouro` INTEGER NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_TipoGeral',
  `nm_Logadouro` VARCHAR(250) NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_TipoGeral',
  PRIMARY KEY (`id_Pessoa_Endereco`)
) COMMENT 'Vinculação com tb_Pessoa';

-- ---
-- Table 'tb_Pessoa_Documento'
-- Vinculação com Tabela tb_Pessoa
-- ---

DROP TABLE IF EXISTS `tb_Pessoa_Documento`;
		
CREATE TABLE `tb_Pessoa_Documento` (
  `id_Pessoa_Documento` INT NOT NULL AUTO_INCREMENT COMMENT 'Conecção de chave com a tabela tb_Pessoa_Nome',
  `id_Pessoa` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_Pessoa',
  `id_TipoDocumento` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_TipoGeral',
  `vr_Documento` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id_Pessoa_Documento`)
) COMMENT 'Vinculação com Tabela tb_Pessoa';

-- ---
-- Table 'tb_TipoGeral'
-- Filtro de Geral 
-- ---

DROP TABLE IF EXISTS `tb_TipoGeral`;
		
CREATE TABLE `tb_TipoGeral` (
  `id_TipoGeral` INTEGER NOT NULL AUTO_INCREMENT ,
  `nm_TipoGeral` VARCHAR(100) NULL DEFAULT NULL,
  `nm_Filtro` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_TipoGeral`)
) COMMENT 'Filtro de Geral ';

-- ---
-- Table 'tb_Pessoa_Nome'
-- Nome de Pessoa Física ou Jurídica.
-- ---

DROP TABLE IF EXISTS `tb_Pessoa_Nome`;
		
CREATE TABLE `tb_Pessoa_Nome` (
  `id_pessoa_Nome` INTEGER NOT NULL AUTO_INCREMENT COMMENT 'Chave-Estrangera da pessoa Nome',
  `id_Pessoa` INT NOT NULL  COMMENT 'Chave-Estrangera de tb_Pessoa',
  `id_Pessoa_Documento` INT NOT NULL COMMENT 'Chave-Estrangera de tb_Pessoa_Documento',
  `nm_Pessoa` VARCHAR(250) NOT NULL COMMENT 'Nome Pessoa',
  PRIMARY KEY (`id_pessoa_Nome`)
) COMMENT 'Nome de Pessoa Física ou Jurídica.';

-- ---
-- Table 'tb_Pessoa_Contatos'
-- Vinculação com chave pessoa tb_Pessoa
-- ---

DROP TABLE IF EXISTS `tb_Pessoa_Contatos`;
		
CREATE TABLE `tb_Pessoa_Contatos` (
  `id_Pessoa_Contato` INTEGER NOT NULL AUTO_INCREMENT,
  `id_Pessoa` INT NOT NULL COMMENT 'Chave-Estrangera de tb_Pessoa',
  `id_TipoContato` INTEGER NOT NULL COMMENT 'Chave-Estrangera de filtro tb_TipoGeral',
  `nm_Contato` VARCHAR(250) NOT NULL COMMENT 'Chave-Estrangera de filtro tb_TipoGeral',
  `ds_Contato` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_Pessoa_Contato`)
) COMMENT 'Vinculação com chave pessoa tb_Pessoa';

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `tb_Pessoa_Endereco` ADD FOREIGN KEY (id_Pessoa) REFERENCES `tb_Pessoa` (`id_Pessoa`);
ALTER TABLE `tb_Pessoa_Endereco` ADD FOREIGN KEY (id_TipoLogadouro) REFERENCES `tb_TipoGeral` (`id_TipoGeral`);
ALTER TABLE `tb_Pessoa_Documento` ADD FOREIGN KEY (id_Pessoa) REFERENCES `tb_Pessoa` (`id_Pessoa`);
ALTER TABLE `tb_Pessoa_Documento` ADD FOREIGN KEY (id_TipoDocumento) REFERENCES `tb_TipoGeral` (`id_TipoGeral`);
ALTER TABLE `tb_Pessoa_Nome` ADD FOREIGN KEY (Id_Pessoa) REFERENCES `tb_Pessoa` (`id_Pessoa`);
ALTER TABLE `tb_Pessoa_Nome` ADD FOREIGN KEY (id_Pessoa_Documento) REFERENCES `tb_Pessoa_Documento` (`id_Pessoa_Documento`);
ALTER TABLE `tb_Pessoa_Contatos` ADD FOREIGN KEY (id_Pessoa) REFERENCES `tb_Pessoa` (`id_Pessoa`);
ALTER TABLE `tb_Pessoa_Contatos` ADD FOREIGN KEY (id_TipoContato) REFERENCES `tb_TipoGeral` (`id_TipoGeral`);



ALTER TABLE pessoa.tb_Pessoa_Endereco DROP FOREIGN KEY tb_Pessoa_Endereco_ibfk_2;

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `tb_Pessoa` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `tb_Pessoa_Endereco` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `tb_Pessoa_Documento` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `tb_TipoGeral` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `tb_Pessoa_Nome` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `tb_Pessoa_Contatos` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `tb_Pessoa` (`id_Pessoa`,`tx_Hash`) VALUES
-- ('','');
-- INSERT INTO `tb_Pessoa_Endereco` (`id_Pessoa_Endereco`,`id_Pessoa`,`id_TipoLogadouro`,`nm_Logadouro`) VALUES
-- ('','','','');
-- INSERT INTO `tb_Pessoa_Documento` (`id_Pessoa_Documento`,`id_Pessoa`,`id_TipoDocumento`,`vr_Documento`) VALUES
-- ('','','','');
-- INSERT INTO `tb_TipoGeral` (`id_TipoGeral`,`nm_TipoGeral`,`nm_Filtro`) VALUES
-- ('','','');
-- INSERT INTO `tb_Pessoa_Nome` (`id_pessoa_Nome`,`Id_Pessoa`,`id_Pessoa_Documento`,`nm_Pessoa`) VALUES
-- ('','','','');
-- INSERT INTO `tb_Pessoa_Contatos` (`id_Pessoa_Contato`,`id_Pessoa`,`id_TipoContato`,`nm_Contato`,`ds_Contato`) VALUES
-- ('','','','','');

