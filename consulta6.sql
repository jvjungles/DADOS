


SELECT d.nome_departamento, COUNT(f.cod_departamento) AS qtde_funcionario
from funcionario f 
INNER JOIN departamento d ON f.cod_departamento = d.cod_departamento
GROUP BY f.cod_departamento
HAVING qtde_funcionario = (	
	SELECT MAX(SUB.q_func)
	FROM departamento depart
	INNER JOIN (
		SELECT dep.cod_departamento, COUNT(func.cod_departamento) AS q_func
		from funcionario func 
		INNER JOIN departamento dep ON func.cod_departamento = dep.cod_departamento
		GROUP BY func.cod_departamento 
	) SUB ON
	depart.cod_departamento = SUB.cod_departamento
);
	


select * from atividade02.departamento d ;

select * from atividade02.funcionario f ;

select * from atividade02.dep_maior_num_func dmnf ;

select
	d.nome_departamento,
	f.nome_funcionario
from
	funcionario f
inner join departamento d on
	f.cod_departamento = d.cod_departamento
where d.nome_departamento like '%Dir%';

SELECT * 
from departamento d 
INNER JOIN funcionario f
where d.nome_departamento like '%Dir%';


