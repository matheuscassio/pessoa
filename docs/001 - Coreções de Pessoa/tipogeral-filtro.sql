USE pessoa;
CREATE TABLE `tb_tipogeral_filtro` (
 `id_Tipogeral_Filtro` INTEGER NOT NULL AUTO_INCREMENT ,
 `nm_Filtro` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_Tipo_Geral',
 PRIMARY KEY(`id_tipogeral_Filtro`)
  ) COMMENT 'Tabela Ligação Tipogeral_Filtro';
  
  USE pessoa;
DROP TABLE IF EXISTS `tb_tipogeral_filtro`;
USE pessoa;
DELETE FROM tb_tipogeral_filtro ;
