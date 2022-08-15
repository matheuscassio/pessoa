CREATE TABLE `tb_tipo_geral_filtro` (
 `id_tipo_geral_filtro` INTEGER NOT NULL AUTO_INCREMENT ,
`id_Tipo_Geral` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_pessoa',
`nm_Tipo_FIltro` VARCHAR(100) NOT NULL COMMENT 'texto do nome familia',
 PRIMARY KEY(`id_tipo_geral_filtro`),
  UNIQUE KEY (`nm_Tipo_FIltro`)
  ) COMMENT 'Situação em que a pessoa se encontra na tabela';
