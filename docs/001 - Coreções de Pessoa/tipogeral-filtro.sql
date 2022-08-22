USE pessoa;
CREATE TABLE `tb_tipo_geral_filtro` (
 `id_Tipo_Geral_Filtro` INTEGER NOT NULL AUTO_INCREMENT ,
 `nm_Filtro` VARCHAR (100)NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_Tipo_Geral',
 PRIMARY KEY(`id_Tipo_Geral_Filtro`)
  ) COMMENT 'Tabela Ligação Tipogeral_Filtro';
  
  USE pessoa;
DROP TABLE IF EXISTS `id_Tipo_Geral_Filtro`;
USE pessoa;
DELETE FROM tb_tipo_geral_filtro ;
  

