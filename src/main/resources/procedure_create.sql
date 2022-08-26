DELIMITER && 
CREATE PROCEDURE proc_aumentaSalario(IN in_id FLOAT)
READS SQL DATA
BEGIN 
   UPDATE funcionario f SET f.salario = salario + (salario * (in_id/100));
   SELECT * FROM funcionario f;
END &&  
DELIMITER ;