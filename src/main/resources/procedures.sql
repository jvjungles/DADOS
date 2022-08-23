/*
DELIMITER &&  
CREATE PROCEDURE proc_aumentaSalario(IN in_id INT)

BEGIN  
  SELECT 
   f.id, 
	f.cargo, 
	f.cpf, 
	f.nome_funcionario, 
	f.qtde_dependente,
	f.salario + (salario * in_id/100) salario,
	f.id_departamento 
	FROM funcionario f;
END &&  
DELIMITER ;
*/

DELIMITER &&  
CREATE PROCEDURE proc_aumentaSalario(IN in_id INT)

BEGIN  
  UPDATE funcionario f SET f.salario = salario + (salario * (10/100));
END &&  
DELIMITER ;



DELIMITER && 
CREATE PROCEDURE proc_aumentaSalario(IN in_id BIGINT, OUT funcionario VARCHAR(254))
READS SQL DATA
BEGIN 
   UPDATE funcionario f SET f.salario = salario + (salario * (in_id/100));
END &&  
DELIMITER ;


CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_aumentaSalario2`(
	IN `in_id` INT
)
LANGUAGE SQL
NOT DETERMINISTIC
READS SQL DATA
SQL SECURITY DEFINER
COMMENT ''
BEGIN 
   UPDATE funcionario f SET f.salario = salario + (salario * (in_id/100));
   SELECT * FROM funcionario f;
END
