USE pessoa;
CREATE TABLE `rl_tipogeral_tipogeralfiltro` (
 `id_TipoGeral_TipoGeralFiltro` INTEGER NOT NULL AUTO_INCREMENT ,
`id_Tipo_Geral` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_Tipo_Geral',
 `id_TipoGeral_Filtro` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral_Filtro',
 PRIMARY KEY(`id_Tipogeral_Tipogeralfiltro`)
  ) COMMENT 'Tabela Ligação tipo_geral e tipogeral_filtro';

USE pessoa;
ALTER TABLE `rl_tipogeral_tipogeralfiltro` ADD CONSTRAINT fk_tipogeral_tipogeralfiltro_idTipoGeral FOREIGN KEY (id_Tipo_Geral) REFERENCES `tb_tipogeral` (`id_Tipo_Geral`);
ALTER TABLE `rl_tipogeral_tipogeralfiltro` ADD CONSTRAINT  fktipogeral_tipogeralfiltro_idTipogeralFiltro FOREIGN KEY (id_Tipogeral_Filtro) REFERENCES `tb_tipogeral_filtro` (`id_Tipogeral_Filtro`);


USE pessoa;
ALTER TABLE pessoa.rl_tipogeral_tipogeralfiltro DROP FOREIGN KEY fk_tipogeral_tipogeralfiltro_idTipoGeral;
ALTER TABLE pessoa.rl_tipogeral_tipogeralfiltro DROP FOREIGN KEY fktipogeral_tipogeralfiltro_tbtb_tipogeral_filtro_idTipogeralFiltro;
USE pessoa;
DROP TABLE IF EXISTS `rl_tipogeral_tipogeralfiltro`;
USE pessoa;
DELETE FROM rl_tipogeral_tipogeralfiltro ;
