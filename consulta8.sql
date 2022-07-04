CREATE SCHEMA atividade02;
USE atividade02;

-- create users
CREATE USER 'funcionario'@localhost IDENTIFIED BY 'password1'; -- falta acesso limitado
CREATE USER 'gerente'@localhost IDENTIFIED BY 'password1';

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
    salario integer,
    cargo character varying(70),
    cod_departamento integer,
    CONSTRAINT funcionario_pkey PRIMARY KEY (cod_funcionario),
    CONSTRAINT funcionario_cod_departamento_fkey FOREIGN KEY (cod_departamento) REFERENCES departamento(cod_departamento)
);

-- insert dados
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (1, 'Tecnologia');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (2, 'Administrativo');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (3, 'Financeiro');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (4, 'Recursos Humanos');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (5, 'Setor comercial');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (6, 'Setor operacional');

INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES (1, 'nome funcionario 01', 1, 1000, 'cargo 01', 1);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES (2, 'nome funcionario 02', 2, 2000, 'cargo 02', 2);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES (3, 'nome funcionario 03', 3, 3000, 'cargo 03', 3);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES (4, 'nome funcionario 04', 4, 4000, 'cargo 04', 4);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES (5, 'nome funcionario 05', 5, 5000, 'cargo 05', 5);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES (6, 'nome funcionario 06', 6, 6000, 'cargo 06', 6);

-- create views
-- CREATE VIEW testview AS SELECT * FROM departamento;

CREATE VIEW dep_maior_num_func AS 
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
		
		
CREATE VIEW dep_menor_num_func_sem_dep AS 
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
