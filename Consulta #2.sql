SELECT * FROM dml.cantor;
SELECT * FROM dml.categoria;
SELECT * FROM dml.gravadora;
SELECT * FROM dml.musica;
SELECT * FROM dml.gravacao;
SELECT * FROM dml.pessoa;
SELECT * FROM dml.fone;



#Respostas

#Questão 01
#Obter o nome do cantor que possui o menor número de gravações (deve exibir todos os nomes de cantores que tenham o valor mínimo).


SELECT can.nome_cantor, COUNT(grav.cod_cantor) AS numGravacoes
from dml.gravacao grav
INNER JOIN dml.cantor can ON grav.cod_cantor = can.cod_cantor
GROUP BY grav.cod_cantor
HAVING numGravacoes = (
		SELECT MIN(minGravacoes.countGravacoes) FROM 
		(
			SELECT cod_cantor, COUNT(cod_cantor) AS countGravacoes
			from dml.gravacao 
			GROUP BY cod_cantor
		) minGravacoes
);

#SELECT * from dml.gravacao;
#SELECT (*) AS t FROM dml.gravacao GROUP BY cod_cantor ORDER BY t desc;
#SELECT * from dml.gravacao WHERE ;








#Questão 02
# Obter o nome do cantor que gravou com o maior número de gravadoras diferentes.


SELECT			
		can.nome_cantor, 
		COUNT(DISTINCT(grav.cod_gravadora)) AS gravCount
	FROM
		dml.gravacao grav
	INNER JOIN 
		dml.cantor can ON grav.cod_cantor = can.cod_cantor
	GROUP BY
		grav.cod_cantor
	HAVING gravCount = (
			SELECT MAX(sub1.grav)
			FROM
				dml.cantor can
			INNER JOIN 
			(
				SELECT
					cod_cantor, COUNT(DISTINCT(cod_gravadora)) AS grav
				FROM
					dml.gravacao
				GROUP BY
						cod_cantor
			) sub1 ON can.cod_cantor = sub1.cod_cantor
		);

-- SELECT 
-- 	cod_cantor,
-- 	cod_gravadora,
-- 	COUNT(DISTINCT(cod_gravadora)) as grav 
-- FROM dml.gravacao
-- 	GROUP by cod_cantor;

-- SELECT 
-- 	cod_cantor,
-- 	cod_gravadora,
-- 	COUNT(DISTINCT(cod_gravadora)) as grav 
-- FROM dml.gravacao
-- 	GROUP by cod_cantor;

-- SELECT 
-- sub1.grav
-- -- MAX(sub1.grav) 
-- FROM dml.gravacao grav2
-- INNER JOIN (
-- 	SELECT 
-- 	cod_gravadora, 
-- 	COUNT(DISTINCT(cod_gravadora)) as grav 
-- 	FROM dml.gravacao 
-- 	GROUP by cod_cantor) sub1 ON grav2.
-- ORDER BY sub1.grav;


-- SELECT 
-- -- *,
-- -- can.nome_cantor,
-- -- sub1.grav
-- MAX(sub1.grav) 
-- FROM dml.cantor can
-- INNER JOIN (
-- 	SELECT 
-- 	cod_cantor, 
-- 	COUNT(DISTINCT(cod_gravadora)) as grav 
-- 	FROM dml.gravacao 
-- 	GROUP by cod_cantor) sub1 ON can.cod_cantor = sub1.cod_cantor
-- ORDER BY sub1.grav;




-- SELECT 
-- cod_cantor, 
-- COUNT(DISTINCT(cod_gravadora)) as grav 
-- FROM dml.gravacao 
-- GROUP by cod_cantor 
-- ORDER BY grav;


-- SELECT *
-- FROM
-- (
-- 	SELECT			
-- 		can.nome_cantor, 
-- 		COUNT(DISTINCT(grav.cod_gravadora)) AS gravCount
-- 	FROM
-- 		dml.gravacao grav
-- 	INNER JOIN 
-- 		dml.cantor can ON grav.cod_cantor = can.cod_cantor
-- 	GROUP BY
-- 		grav.cod_cantor
-- ) tmax
-- WHERE
-- tmax.gravCount =
-- 	(
-- 		SELECT MAX(sub1.grav)
-- 		FROM
-- 			dml.cantor can
-- 		INNER JOIN 
-- 		(
-- 			SELECT
-- 				cod_cantor, COUNT(DISTINCT(cod_gravadora)) AS grav
-- 			FROM
-- 				dml.gravacao
-- 			GROUP BY
-- 					cod_cantor
-- 		) sub1 ON can.cod_cantor = sub1.cod_cantor
-- 	)
-- ORDER BY
-- 	nome_cantor;



-- SELECT *
-- -- tmax.nome_cantor,
-- -- MAX(tmax.gravCount) 
-- FROM (
-- 	SELECT
-- 	can.nome_cantor, 
-- 	COUNT(DISTINCT(grav.cod_gravadora)) as gravCount 
-- 	FROM dml.gravacao grav
-- 	INNER JOIN dml.cantor can ON grav.cod_cantor = can.cod_cantor
-- 	GROUP by grav.cod_cantor
-- ) tmax;










#Questão 03
#Obter o nome do cantor que possui a maior média de duração de gravações


SELECT
	sub.nome_cantor,
	MAX(sub.media) media
FROM
(
	SELECT
		can.nome_cantor, 
		AVG(mus.duracao) media
	FROM
		dml.gravacao grav
	INNER JOIN dml.musica mus ON
		grav.cod_musica = mus.cod_musica
	INNER JOIN dml.cantor can ON
		grav.cod_cantor = can.cod_cantor
	GROUP BY
		can.nome_cantor
	ORDER BY
		media DESC 
) sub;










#Questão 04
#Selecionar os cantores que nunca gravaram música com a gravadora Sony.

SELECT 
can.nome_cantor
FROM dml.cantor can  
WHERE NOT EXISTS (
	SELECT * FROM dml.gravacao grav 
	INNER JOIN dml.gravadora grad ON grav.cod_gravadora = grad.cod_gravadora
	WHERE grav.cod_cantor = can.cod_cantor 
	AND grad.nome_gravadora = 'Sony'
);

-- SELECT 
-- gcao.*, can.nome_cantor, gora.nome_gravadora 
-- #DISTINCT(can.nome_cantor)
-- FROM dml.gravacao gcao  
-- left JOIN  dml.cantor can ON can.cod_cantor = gcao.cod_cantor
-- left JOIN dml.gravadora gora ON gcao.cod_gravadora = gora.cod_gravadora
-- #WHERE gora.nome_gravadora != 'Sony'
-- #ORDER BY nome_cantor
-- ;

-- SELECT 
-- -- gcao.*, can.nome_cantor
-- DISTINCT(can.nome_cantor)
-- FROM dml.cantor can  
-- left JOIN  dml.gravacao gcao ON can.cod_cantor = gcao.cod_cantor
-- WHERE gcao.cod_gravadora != 1 OR gcao.cod_gravadora IS null
-- #ORDER BY nome_cantor
-- ;

-- SELECT 
-- can.nome_cantor
-- -- DISTINCT(can.nome_cantor)
-- FROM dml.cantor can  
-- left JOIN  dml.gravacao gcao ON gcao.cod_cantor = can.cod_cantor
-- WHERE gcao.cod_gravadora != 1 
-- #ORDER BY nome_cantor
-- ;




#Questão 05
#Selecione o nome das músicas, nome dos cantores e as datas de gravação, para as gravações do ano de 2004.

SELECT
	can.nome_cantor AS cantor,
	mus.titulo AS musica,
	gcao.data_gravacao
FROM
	dml.gravacao gcao
INNER JOIN dml.musica mus ON
	gcao.cod_musica = mus.cod_musica
INNER JOIN dml.cantor can ON
	gcao.cod_cantor = can.cod_cantor
WHERE
	YEAR(gcao.data_gravacao) = '2004';




#Questão 06
#Selecione o nome de cada cantor e a data da sua última gravação em ordem decrescente de data. Caso não tenha gravado nada, a data deve aparecer em branco.


SELECT
	can.nome_cantor AS cantor, MAX(gcao.data_gravacao) AS data_ultima_gravacao
FROM
	dml.cantor can
LEFT JOIN dml.gravacao gcao ON
	gcao.cod_cantor = can.cod_cantor
GROUP BY
	can.nome_cantor
ORDER BY
	data_ultima_gravacao DESC;





#Questão 07
# Dadas as tabelas pessoa e fone, retorne os números de telefone residencial, comercial e Celular de cadapessoa. O retorno deve conter uma linha para cada pessoa, com a coluna ‘nome’, seguida dos números.



SELECT 
p.nome_pessoa, 
fr.numero fr,
fc.numero fc,
fl.numero fl
FROM dml.pessoa p
inner JOIN dml.fone fr ON p.cod_pessoa = fr.cod_pessoa AND fr.tipo = 'R'
inner JOIN dml.fone fc ON p.cod_pessoa = fc.cod_pessoa AND fc.tipo = 'C'
inner JOIN dml.fone fl ON p.cod_pessoa = fl.cod_pessoa AND fl.tipo = 'L';

