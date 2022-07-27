-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'tb_Pessoa'
-- Tabela para o cadastro de Pessoa Física e Jurídica 

ALTER TABLE pessoa.tb_Pessoa_Endereco DROP FOREIGN KEY fkPessoa_Endereco_tbPessoa_idPessoa;
ALTER TABLE pessoa.tb_Pessoa_Endereco DROP FOREIGN KEY fkPessoa_Endereco_tbTipoGeral_idTipoGeral;
ALTER TABLE pessoa.tb_Pessoa_Endereco DROP FOREIGN KEY fkPessoa_Endereco_tbMunicipio_idMunicipio;
ALTER TABLE pessoa.tb_Pessoa_Documento DROP FOREIGN KEY fkPessoa_Documento_tbTipoGeral_idTipoGeral;
ALTER TABLE pessoa.tb_Pessoa_Documento DROP FOREIGN KEY fkPessoa_Documento_tbPessoa_idPessoa;
ALTER TABLE pessoa.tb_Pessoa_Nome DROP FOREIGN KEY fkPessoa_Nome_tbPessoa_idPessoa;
ALTER TABLE pessoa.tb_Pessoa_Nome DROP FOREIGN KEY fkPessoa_Nome_tbPessoaDocumento_idPessoaDocumento;
ALTER TABLE pessoa.tb_Pessoa_Contatos DROP FOREIGN KEY fkPessoa_Contatos_tbPessoa_idPessoa;
ALTER TABLE pessoa.tb_Pessoa_Contatos DROP FOREIGN KEY fkPessoa_Contatos_tbTipoGeral_idTipoGeral;

DROP TABLE IF EXISTS `tb_Pessoa_Endereco`;
DROP TABLE IF EXISTS `tb_Pessoa_Documento`;
DROP TABLE IF EXISTS `tb_TipoGeral`;
DROP TABLE IF EXISTS `tb_Pessoa_Nome`;
DROP TABLE IF EXISTS `tb_Pessoa_Contatos`;
DROP TABLE IF EXISTS `tb_Pessoa`;
DROP TABLE IF EXISTS `tb_Municipio`;	


-- ---
-- criação da Tigger Hash apos inserir que tb_pessoa 
CREATE TRIGGER TgrPreenchimentoHash 
AFTER INSERT ON `tb_Pessoa_Nome` 
FOR EACH ROW
BEGIN
 SET @dt_Nascimento = (SELECT dt_Nascgeimento FROM tb_Pessoa WHERE id_Pessoa);
 SET @nm_Mae = (SELECT nm_Mae FROM tb_Pessoa WHERE id_Pessoa);
    UPDATE tb_Pessoa set tx_Hash= MD5('nm_Mae') WHERE id_Pessoa = NEW.id_Pessoa;
END;


DELETE FROM tb_Pessoa;
INSERT INTO `tb_Pessoa` (`id_Pessoa`,`tx_Hash`,`dt_Nascimento`,`nm_Mae`,`st_Embriao`) VALUES
 ('1','1a45ufnfeu43','1989-09-10','Kasandra Abadinel',TRUE);
INSERT INTO `tb_Pessoa` (`id_Pessoa`,`tx_Hash`,`dt_Nascimento`,`nm_Mae`,`st_Embriao`)VALUES
 ('2','1b345ufnfeu43','1996-03-08','Judite Siqueira',FALSE);
INSERT INTO `tb_Pessoa` (`id_Pessoa`,`tx_Hash`,`dt_Nascimento`,`nm_Mae`,`st_Embriao`) VALUES
 ('3','1c434hjb34b3','2019-09-09','Carla Figuereiro',TRUE);
INSERT INTO `tb_Pessoa` (`id_Pessoa`,`tx_Hash`,`dt_Nascimento`,`nm_Mae`,`st_Embriao`) VALUES
 ('4','1d354jn34jn3n3','2009-01-07','Juliana Abratinel',TRUE);
INSERT INTO `tb_Pessoa` (`id_Pessoa`,`tx_Hash`,`dt_Nascimento`,`nm_Mae`,`st_Embriao`) VALUES
 ('5','1e34jr434j3j4bj3','2022-01-01','Sirley Pereira',FALSE);
INSERT INTO `tb_Pessoa` (`id_Pessoa`,`tx_Hash`,`dt_Nascimento`,`nm_Mae`,`st_Embriao`) VALUES
 ('6','1f345u4ehhds','1978-06-02','Maria de Aparecida',TRUE);

DELETE FROM tb_TipoGeral;
INSERT INTO `tb_TipoGeral` (`id_TipoGeral`,`nm_TipoGeral`,`nm_Filtro`) VALUES
 ('1','Rua','TIPO_ENDERECO');
INSERT INTO `tb_TipoGeral` (`id_TipoGeral`,`nm_TipoGeral`,`nm_Filtro`) VALUES
 ('2','Quadra','TIPO_ENDERECO');
INSERT INTO `tb_TipoGeral` (`id_TipoGeral`,`nm_TipoGeral`,`nm_Filtro`) VALUES
 ('3','Avenida','TIPO_ENDERECO');

INSERT INTO `tb_TipoGeral` (`id_TipoGeral`,`nm_TipoGeral`,`nm_Filtro`) VALUES
 ('4','CPF','TIPO_DOCUMENTO');
INSERT INTO `tb_TipoGeral` (`id_TipoGeral`,`nm_TipoGeral`,`nm_Filtro`) VALUES
 ('5','RG','TIPO_DOCUMENTO');
INSERT INTO `tb_TipoGeral` (`id_TipoGeral`,`nm_TipoGeral`,`nm_Filtro`) VALUES
 ('6','Certidao','TIPO_DOCUMENTO');

INSERT INTO `tb_TipoGeral` (`id_TipoGeral`,`nm_TipoGeral`,`nm_Filtro`) VALUES
 ('7','email','TIPO_CONTATO');
INSERT INTO `tb_TipoGeral` (`id_TipoGeral`,`nm_TipoGeral`,`nm_Filtro`) VALUES
 ('8','Telefone','TIPO_CONTATO');
INSERT INTO `tb_TipoGeral` (`id_TipoGeral`,`nm_TipoGeral`,`nm_Filtro`) VALUES
 ('9','Intagram','TIPO_CONTATO');

INSERT INTO `tb_Municipio` (`id_Municipio`,`nm_Municipio`) VALUES
 ('1','Sao Paulo');
INSERT INTO `tb_Municipio` (`id_Municipio`,`nm_Municipio`) VALUES
 ('2','Brasilia');
INSERT INTO `tb_Municipio` (`id_Municipio`,`nm_Municipio`) VALUES
 ('3','Rio de Janeiro');
INSERT INTO `tb_Municipio` (`id_Municipio`,`nm_Municipio`) VALUES
 ('4','Rio Grande do Sul');


DELETE FROM tb_Pessoa_Documento;
INSERT INTO `tb_Pessoa_Documento` (`id_Pessoa_Documento`,`id_Pessoa`,`id_TipoDocumento`,`vr_Documento`,`dt_Emissao`,  `nm_OrgaoEmissor`,  `ds_Serie`) VALUES
 ('1','1','4','01239403003','1998-03-31','SESP-DF','RTETRET54');
INSERT INTO `tb_Pessoa_Documento` (`id_Pessoa_Documento`,`id_Pessoa`,`id_TipoDocumento`,`vr_Documento`,`dt_Emissao`,  `nm_OrgaoEmissor`,  `ds_Serie`) VALUES
 ('2','2','5','3571272','1990-01-03','SESP-DF','217865D');
INSERT INTO `tb_Pessoa_Documento` (`id_Pessoa_Documento`,`id_Pessoa`,`id_TipoDocumento`,`vr_Documento`,`dt_Emissao`,  `nm_OrgaoEmissor`,  `ds_Serie`) VALUES
 ('3','3','6','2374292132423414','2010-02-02','SESP-SP','2154');
INSERT INTO `tb_Pessoa_Documento` (`id_Pessoa_Documento`,`id_Pessoa`,`id_TipoDocumento`,`vr_Documento`,`dt_Emissao`,  `nm_OrgaoEmissor`,  `ds_Serie`) VALUES
 ('4','4','6','4324324434324233','1977-03-07','SESP-RJ','21EQWD');
INSERT INTO `tb_Pessoa_Documento` (`id_Pessoa_Documento`,`id_Pessoa`,`id_TipoDocumento`,`vr_Documento`,`dt_Emissao`,  `nm_OrgaoEmissor`,  `ds_Serie`) VALUES
 ('5','5','6','3242413556657567','1989-09-01','SESP-SP','2324A');
INSERT INTO `tb_Pessoa_Documento` (`id_Pessoa_Documento`,`id_Pessoa`,`id_TipoDocumento`,`vr_Documento`,`dt_Emissao`,  `nm_OrgaoEmissor`,  `ds_Serie`) VALUES
 ('6','6','4','89037473103','1998-03-03','SESP-DF','WDQE23');

DELETE FROM tb_Pessoa_Endereco ;
INSERT INTO `tb_Pessoa_Endereco` (`id_Pessoa_Endereco`,`id_Pessoa`,`id_TipoLogadouro`,`id_Municipio`,`nm_Logadouro`,`nm_Complemento`,`nm_Numero`,`nm_Bairro`,`nm_CEP`) VALUES
('1','1','1','2','Rua','dos coqueiros','101','Taguatinga','19020015');
INSERT INTO `tb_Pessoa_Endereco` (`id_Pessoa_Endereco`,`id_Pessoa`,`id_TipoLogadouro`,`id_Municipio`,`nm_Logadouro`,`nm_Complemento`,`nm_Numero`,`nm_Bairro`,`nm_CEP`) VALUES
('2','2','2','2','Quadra','villa mathias','102','Guara','34929123');
INSERT INTO `tb_Pessoa_Endereco` (`id_Pessoa_Endereco`,`id_Pessoa`,`id_TipoLogadouro`,`id_Municipio`,`nm_Logadouro`,`nm_Complemento`,`nm_Numero`,`nm_Bairro`,`nm_CEP`) VALUES
('3','3','3','1','Avenida','Dois Irmaos','103','Ibatuba','45929519');
INSERT INTO `tb_Pessoa_Endereco` (`id_Pessoa_Endereco`,`id_Pessoa`,`id_TipoLogadouro`,`id_Municipio`,`nm_Logadouro`,`nm_Complemento`,`nm_Numero`,`nm_Bairro`,`nm_CEP`) VALUES
('4','4','2','3','Quadra','dos Poderes','104','Ipanema','45021380');
INSERT INTO `tb_Pessoa_Endereco` (`id_Pessoa_Endereco`,`id_Pessoa`,`id_TipoLogadouro`,`id_Municipio`,`nm_Logadouro`,`nm_Complemento`,`nm_Numero`,`nm_Bairro`,`nm_CEP`) VALUES
('5','5','3','2','Avenida','EPNB','105','Aguas Claras','47570813');
INSERT INTO `tb_Pessoa_Endereco` (`id_Pessoa_Endereco`,`id_Pessoa`,`id_TipoLogadouro`,`id_Municipio`,`nm_Logadouro`,`nm_Complemento`,`nm_Numero`,`nm_Bairro`,`nm_CEP`) VALUES
('6','6','2','3','quadra','Dos Pombos','106','Pelotas','34043028');


 DELETE FROM tb_Pessoa_Nome ;
 INSERT INTO `tb_Pessoa_Nome` (`id_pessoa_Nome`,`Id_Pessoa`,`id_Pessoa_Documento`,`nm_Pessoa`) VALUES
 ('1','1','1','Joao');
INSERT INTO `tb_Pessoa_Nome` (`id_pessoa_Nome`,`Id_Pessoa`,`id_Pessoa_Documento`,`nm_Pessoa`) VALUES
 ('2','2','2','Pedro');
INSERT INTO `tb_Pessoa_Nome` (`id_pessoa_Nome`,`Id_Pessoa`,`id_Pessoa_Documento`,`nm_Pessoa`) VALUES
 ('3','3','3','Jaconias');
INSERT INTO `tb_Pessoa_Nome` (`id_pessoa_Nome`,`Id_Pessoa`,`id_Pessoa_Documento`,`nm_Pessoa`) VALUES
 ('4','4','4','Raimunda');
INSERT INTO `tb_Pessoa_Nome` (`id_pessoa_Nome`,`Id_Pessoa`,`id_Pessoa_Documento`,`nm_Pessoa`) VALUES
 ('5','5','5','Sebastian');
INSERT INTO `tb_Pessoa_Nome` (`id_pessoa_Nome`,`Id_Pessoa`,`id_Pessoa_Documento`,`nm_Pessoa`) VALUES
 ('6','6','6','Rodrigo');
 
DELETE FROM tb_Pessoa_Contatos ;
INSERT INTO `tb_Pessoa_Contatos` (`id_Pessoa_Contato`,`id_Pessoa`,`id_TipoContato`,`nm_Contato`,`ds_Contato`) VALUES
 ('1','1','7','email','joaao13@gmail.com');
INSERT INTO `tb_Pessoa_Contatos` (`id_Pessoa_Contato`,`id_Pessoa`,`id_TipoContato`,`nm_Contato`,`ds_Contato`) VALUES
 ('2','2','8','Telefone','61992929292');
INSERT INTO `tb_Pessoa_Contatos` (`id_Pessoa_Contato`,`id_Pessoa`,`id_TipoContato`,`nm_Contato`,`ds_Contato`) VALUES
 ('3','3','9','Instagram','@jaconaias1');
INSERT INTO `tb_Pessoa_Contatos` (`id_Pessoa_Contato`,`id_Pessoa`,`id_TipoContato`,`nm_Contato`,`ds_Contato`) VALUES
 ('4','4','7','email','Raimunda12@gmail.com');
INSERT INTO `tb_Pessoa_Contatos` (`id_Pessoa_Contato`,`id_Pessoa`,`id_TipoContato`,`nm_Contato`,`ds_Contato`) VALUES
 ('5','5','8','telefone','62934546789');
INSERT INTO `tb_Pessoa_Contatos` (`id_Pessoa_Contato`,`id_Pessoa`,`id_TipoContato`,`nm_Contato`,`ds_Contato`) VALUES
 ('6','6','9','Instagram','@rodrigo45');





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

