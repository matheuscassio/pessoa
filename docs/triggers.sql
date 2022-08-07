# Triggers para manipulação das inserções de Pessoa e PessoaNome.

CREATE DEFINER=`root`@`%` TRIGGER `TgrPreenchimentoHashById` BEFORE INSERT ON `tb_pessoa` FOR EACH ROW BEGIN 
	declare last_id int; 
    if new.tx_hash is null then
    	SELECT auto_increment into last_id FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'tb_pessoa' and TABLE_SCHEMA = 'pessoa';
    	set new.tx_hash = CONCAT('hash_temp#', last_id+1);
	end if;
END


CREATE DEFINER=`root`@`%` TRIGGER `TgrPreenchimentoHash` BEFORE INSERT ON `tb_pessoa_nome` FOR EACH ROW BEGIN 
	declare quantos_nomes int;
	SET @dt_Nascimento = (SELECT dt_Nascimento FROM tb_pessoa WHERE id_Pessoa=NEW.id_Pessoa);
    SET @nm_Mae = (SELECT nm_Mae FROM tb_pessoa WHERE id_Pessoa=NEW.id_Pessoa);
	SELECT count(*) into quantos_nomes FROM `tb_pessoa_nome` WHERE `id_Pessoa` = NEW.id_Pessoa;
	if quantos_nomes = 0 then
		UPDATE `tb_pessoa` SET tx_Hash=MD5(CONCAT(NEW.nm_Pessoa, @nm_Mae, @dt_Nascimento)), st_Embriao=0 WHERE id_Pessoa=NEW.id_Pessoa;
	end if;
END






