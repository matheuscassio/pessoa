USE pessoa;
CREATE TABLE `tb_pessoa_siatuacao` (
 `id_Pessoa_Situacao` INTEGER NOT NULL AUTO_INCREMENT ,
 `id_Pessoa` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_pessoa',
 `id_Tipo_Situacao` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral',
 `dt_situacao` DATE NULL DEFAULT NULL  COMMENT 'Data da Situação',
 PRIMARY KEY(`id_Pessoa_Situacao`)
  ) COMMENT 'Situação em que a pessoa se encontra na tabela';
  

-- Adicionando o campo se o registro é padrão.
ALTER TABLE tb_tipogeral ADD st_Padrao INT(1) NOT NULL DEFAULT 0 COMMENT 'Situação Padrão';
ALTER TABLE tb_tipogeral ADD nm_Chave VARCHAR(200) NULL COMMENT 'Nome da chave.';
ALTER TABLE tb_tipogeral ADD tx_Parametro LONGTEXT NULL COMMENT 'texto json para parametro.';


ALTER TABLE `tb_pessoa_siatuacao` ADD CONSTRAINT fkPessoaSituacao_tbtipogeral_idTipoGeral FOREIGN KEY (id_Tipo_Situacao) REFERENCES `tb_tipogeral` (`id_Tipo_Geral`);
ALTER TABLE `tb_pessoa_siatuacao` ADD CONSTRAINT fkPessoaSituacao_tbPessoa_idPessoa FOREIGN KEY (id_Pessoa) REFERENCES `tb_pessoa` (`id_Pessoa`);


INSERT INTO `tb_tipogeral` (`nm_Tipo_Geral`,`nm_Chave`) VALUES
('Ativo','PESSOA_SITUACAO');
INSERT INTO `tb_tipogeral` (`nm_Tipo_Geral`,`nm_Chave`) VALUES
('Deletado','PESSOA_SITUACAO');


ALTER TABLE pessoa.tb_pessoa_situacao DROP FOREIGN KEY fkPessoa_Situacao_tb_tipogeral_idTipoGeral;
ALTER TABLE pessoa.tb_pessoa_situacao DROP FOREIGN KEY fkpessoa_situacao_tbPessoa_idPessoa;

DROP TABLE IF EXISTS `tb_pessoa_situacao`;

DELETE FROM tb_pessoa_siatuacao ;
