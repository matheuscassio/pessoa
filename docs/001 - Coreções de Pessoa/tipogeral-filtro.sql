USE pessoa;
CREATE TABLE `tb_tipogeral_Filtro` (
 `id_tipogeral_Filtro` INTEGER NOT NULL AUTO_INCREMENT ,
`nm_Filtro` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_Tipo_Geral',
 PRIMARY KEY(`id_tipogeral_Filtro`),
  ) COMMENT 'Tabela Ligação Tipogeral_Filtro'
