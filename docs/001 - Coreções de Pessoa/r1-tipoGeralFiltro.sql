USE pessoa;
CREATE TABLE `rl_Tipogeral_Tipogeralfiltro` (
 `id_Tipogeral_Tipogeralfiltroo` INTEGER NOT NULL AUTO_INCREMENT ,
`id_Tipo_Geral` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de tb_Tipo_Geral',
 `id_Tipogeral_Filtro` INT NULL DEFAULT NULL COMMENT 'Chave-Estrangera de filtro tb_tipogeral_Filtro',
 PRIMARY KEY(`id_Tipogeral_Tipogeralfiltroo`),
  ) COMMENT 'Tabela Ligação tipo_geral e tipogeral_filtro';

USE pessoa;
ALTER TABLE `rl_Tipogeral_Tipogeralfiltro` ADD CONSTRAINT fkTipogeral_Tipogeralfiltro_idTipoGeral FOREIGN KEY (id_Tipo_Geral) REFERENCES `tb_tipogeral` (`id_Tipo_Geral`);
ALTER TABLE `tb_pessoa_situacao` ADD CONSTRAINT  fkTipogeral_Tipogeralfiltro_tbTipogeralFiltro_idTipogeralFiltro FOREIGN KEY (id_tipogeral_Filtro) REFERENCES `tb_tipogeral_Filtro` (`tb_tipogeral_Filtro`);



USE pessoa;
ALTER TABLE pessoa.rl_Tipogeral_Tipogeralfiltro DROP FOREIGN KEY fkTipogeral_Tipogeralfiltro_idTipoGeral;
ALTER TABLE pessoa.rl_Tipogeral_Tipogeralfiltro DROP FOREIGN KEY fkTipogeral_Tipogeralfiltro_tbTipogeralFiltro_idTipogeralFiltro;
USE pessoa;
DROP TABLE IF EXISTS `rl_Tipogeral_Tipogeralfiltro`;
USE pessoa;
DELETE FROM rl_Tipogeral_Tipogeralfiltro ;
