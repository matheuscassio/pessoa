USE pessoa;

DELIMITER $$
$$
CREATE DEFINER=`root`@`%` TRIGGER `TgrPreenchimentoHashPessoa` BEFORE INSERT ON `tb_pessoa` FOR EACH ROW BEGIN 
	SET tx_Hash=NEW.id_Pessoa;
END$$
DELIMITER ;

DELIMITER $$
$$
CREATE DEFINER=`root`@`%` TRIGGER `TgrPreenchimentoHashPessoaNome` BEFORE INSERT ON `tb_pessoa_nome` FOR EACH ROW BEGIN 
	SET @dt_Nascimento = (SELECT dt_Nascimento FROM tb_pessoa WHERE id_Pessoa=NEW.id_Pessoa);
    SET @nm_Genitor = (SELECT nm_Genitor FROM tb_pessoa WHERE id_Pessoa=NEW.id_Pessoa);
	UPDATE `tb_pessoa` SET tx_Hash=MD5(CONCAT(NEW.nm_Pessoa, @nm_Genitor, @dt_Nascimento)) WHERE id_Pessoa=NEW.id_Pessoa;
END$$
DELIMITER;
