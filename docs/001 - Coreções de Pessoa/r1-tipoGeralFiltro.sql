USE pessoa;
CREATE TABLE `rl_tipo_geral_tipogeral_filtro` (
 `id_Tipo_Geral_Tipo_Geral_Filtro` INTEGER NOT NULL AUTO_INCREMENT ,
`id_Tipo_Geral` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_Tipo_Geral',
 `id_Tipo_Geral_Filtro` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral_Filtro',
 PRIMARY KEY(`id_Tipo_Geral_Tipo_Geral_Filtro`)
  ) COMMENT 'Tabela Ligação tipo_geral e tipogeral_filtro';

USE pessoa;
ALTER TABLE `rl_tipo_geral_tipogeral_filtro` ADD CONSTRAINT fk_tipogeral_tipogeralfiltro_idTipoGeral FOREIGN KEY (id_Tipo_Geral) REFERENCES `tb_tipo_geral` (`id_Tipo_Geral`);
ALTER TABLE `rl_tipo_geral_tipogeral_filtro` ADD CONSTRAINT  fktipogeral_tipogeralfiltro_idTipogeralFiltro FOREIGN KEY (id_Tipo_Geral_Filtro) REFERENCES `tb_tipo_geral_filtro` (`id_Tipo_Geral_Filtro`);


USE pessoa;
ALTER TABLE pessoa.rl_tipo_geral_tipogeral_filtro DROP FOREIGN KEY fk_tipogeral_tipogeralfiltro_idTipoGeral;
ALTER TABLE pessoa.rl_tipo_geral_tipogeral_filtro DROP FOREIGN KEY fktipogeral_tipogeralfiltro_tbtb_tipogeral_filtro_idTipogeralFiltro;
USE pessoa;
DROP TABLE IF EXISTS `rl_tipo_geral_tipogeral_filtro`;
USE pessoa;
DELETE FROM rl_tipo_geral_tipogeral_filtro ;
