CREATE TABLE `tb_tipo_geral_filtro` (
 `id_tipo_geral_filtro` INTEGER NOT NULL AUTO_INCREMENT ,
`id_Tipo_Geral` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_pessoa',
`nm_Tipo_FIltro` VARCHAR(100) NOT NULL COMMENT 'texto do nome familia',
 PRIMARY KEY(`id_tipo_geral_filtro`),
  UNIQUE KEY (`nm_Tipo_FIltro`)
  ) COMMENT 'tipo geral de filtros ';
  
  ALTER TABLE `tb_tipo_geral_filtro` ADD CONSTRAINT fktipo_geral_filtro_tbtipo_geral_filtro_id_tipo_geral_filtro FOREIGN KEY (id_Tipo_Geral) REFERENCES `tb_tipogeral` (`id_Tipo_Geral`);
  
  
