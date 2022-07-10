CREATE SCHEMA atividade02db;
USE atividade02db;

-- create users
grant all privileges on atividade02db.funcionario 		TO 'funcionario10' 	identified by 'password1';
grant all privileges on atividade02db.* 				TO 'gerente10' 		identified by 'password1';

-- create tables
CREATE TABLE departamento (
    cod_departamento integer NOT NULL AUTO_INCREMENT,
    nome_departamento character varying(70),
    CONSTRAINT departamento_pkey PRIMARY KEY (cod_departamento)
);

CREATE TABLE funcionario (
    cod_funcionario integer NOT NULL AUTO_INCREMENT,
    nome_funcionario character varying(80),
    qtde_dependente integer,
    salario double,
    cargo character varying(70),
    cod_departamento integer,
    CONSTRAINT funcionario_pkey PRIMARY KEY (cod_funcionario),
    CONSTRAINT funcionario_cod_departamento_fkey FOREIGN KEY (cod_departamento) REFERENCES departamento(cod_departamento)
);

-- insert dados
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES(1, 'Tecnologia');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES(2, 'Administrativo');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES(3, 'Financeiro');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES(4, 'Recursos Humanos');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES(5, 'Setor comercial');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES(6, 'Setor operacional');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES(7, 'Diretoria');

INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES(1, 'nome funcionario 01', 0, 1000, 'cargo 01', 1);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES(2, 'nome funcionario 02', 0, 2000, 'cargo 02', 1);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES(3, 'nome funcionario 03', 0, 3000, 'Gerente', 3);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES(4, 'nome funcionario 04', 4, 8000, 'cargo 04', 4);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES(5, 'nome funcionario 05', 0, 5000, 'cargo 05', 7);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES(6, 'nome funcionario 06', 6, 6000, 'cargo 06', 7);


-- create views

-- a. Mostre o nome do departamento que tem o maior número de funcionários, mostrando também a quantidade de funcionários desse departamento.
CREATE VIEW view_a_dep_maior_num_func AS 
select
	d.nome_departamento,
	COUNT(f.cod_departamento) as qtde_funcionario
from
	funcionario f
inner join departamento d on
	f.cod_departamento = d.cod_departamento
group by
	f.cod_departamento
having
	qtde_funcionario = (
	select
		MAX(SUB.q_func)
	from
		departamento depart
	inner join (
		select
			dep.cod_departamento, COUNT(func.cod_departamento) as q_func
		from
			funcionario func
		inner join departamento dep on
			func.cod_departamento = dep.cod_departamento
		group by
			func.cod_departamento ) SUB on
		depart.cod_departamento = SUB.cod_departamento );

-- b. Mostre o nome do departamento que tem a menor quantidade de funcionários sem dependentes, com a quantidade de funcionários.
CREATE VIEW view_b_dep_menor_num_func_sem_d AS 
select
	d.nome_departamento,
	COUNT(f.cod_departamento) as qtde_funcionario
from
	funcionario f
inner join departamento d on
	f.cod_departamento = d.cod_departamento
where f.qtde_dependente = 0
group by
	f.cod_departamento
having
	qtde_funcionario = (
	select
		MIN(SUB.q_func)
	from
		departamento depart
	inner join (
		select
			dep.cod_departamento, COUNT(func.cod_departamento) as q_func
		from
			funcionario func
		inner join departamento dep on
			func.cod_departamento = dep.cod_departamento
		where func.qtde_dependente = 0
		group by
			func.cod_departamento ) SUB on
		depart.cod_departamento = SUB.cod_departamento );

-- c. Mostre o nome do departamento com os nomes dos seus respectivos funcionários de todos os departamentos cujo nome começa com “DIR”.
CREATE VIEW view_c_dep_func_dir AS
select
	d.nome_departamento,
	f.nome_funcionario
from
	funcionario f
inner join departamento d on
	f.cod_departamento = d.cod_departamento
where upper(d.nome_departamento) like 'DIR%';

-- d. Mostre o nome do funcionário e do departamento ao qual pertence o funcionário com o maior salário.
CREATE VIEW view_d_dep_func_maior_sal AS
select 
	f.nome_funcionario,
	d.nome_departamento 
from funcionario f 
inner join departamento d on 
	f.cod_departamento = d.cod_departamento
where f.salario = (
	select 
	max(salario) 
	from funcionario
);

-- e. Mostre o nome do departamento e do funcionário de cada departamento que tem o cargo de “Gerente”.
CREATE VIEW view_e_dep_func_ger AS
select
	d.nome_departamento,
	f.nome_funcionario
from
	funcionario f
inner join departamento d on
	f.cod_departamento = d.cod_departamento
where upper(f.cargo) like UPPER('%Gerente%');