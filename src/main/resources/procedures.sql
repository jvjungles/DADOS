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