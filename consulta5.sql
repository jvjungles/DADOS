CREATE SCHEMA atividade02;
USE atividade02;

CREATE USER 'funcionario'@localhost IDENTIFIED BY 'password1'; -- falta acesso limitado
CREATE USER 'gerente'@localhost IDENTIFIED BY 'password1';

-- Em uma determinada empresa, todo departamento tem um código numérico e um nome. 

CREATE TABLE departamento (
    cod_departamento integer NOT NULL AUTO_INCREMENT,
    nome_departamento character varying(70),
    CONSTRAINT departamento_pkey PRIMARY KEY (cod_departamento)
);

-- Todos os funcionários da empresa são cadastrados com seu código, nome, quantidade de dependentes, salário e cargo.
-- Cada funcionário está lotado em somente um departamento.

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


INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (1, 'Ana');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (2, 'Beto');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (3, 'Carlos');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (4, 'Recursos Humanos');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (5, 'Setor comercial');
INSERT INTO departamento (cod_departamento, nome_departamento) VALUES (6, 'Setor operacional');


INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES (1, 'nome funcionario', 1 , 1 ,'cargo', 1);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES (2, 'nome funcionario', 1 , 1 ,'cargo', 2);
INSERT INTO funcionario (cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, cod_departamento) VALUES (3, 'nome funcionario', 1 , 1 ,'cargo', 3);


CREATE VIEW testview AS SELECT * FROM departamento;
