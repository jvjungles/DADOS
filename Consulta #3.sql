
#Respostas

#Questão 01
#Obter o nome do cantor que possui o menor número de gravações (deve exibir todos os nomes de cantores que tenham o valor mínimo).


SELECT
	CAN.NOME_CANTOR AS CANTOR,
	COUNT(GRAV.COD_CANTOR) AS NUM_GRAVACOES
FROM
	DML.GRAVACAO GRAV
INNER JOIN DML.CANTOR CAN ON
	GRAV.COD_CANTOR = CAN.COD_CANTOR
GROUP BY
	GRAV.COD_CANTOR
HAVING
	NUM_GRAVACOES = (
	SELECT
		MIN(MINGRAVACOES.COUNTGRAVACOES)
	FROM
		(
		SELECT
			COD_CANTOR, COUNT(COD_CANTOR) AS COUNTGRAVACOES
		FROM
			DML.GRAVACAO
		GROUP BY
			COD_CANTOR ) MINGRAVACOES 
	);


#Questão 02
# Obter o nome do cantor que gravou com o maior número de gravadoras diferentes.


SELECT
	CAN.NOME_CANTOR AS CANTOR,
	COUNT(DISTINCT(GRAV.COD_GRAVADORA)) AS NUM_GRAVACOES
FROM
	DML.GRAVACAO GRAV
INNER JOIN DML.CANTOR CAN ON
	GRAV.COD_CANTOR = CAN.COD_CANTOR
GROUP BY
	GRAV.COD_CANTOR
HAVING
	NUM_GRAVACOES = (
	SELECT
		MAX(SUB1.GRAV)
	FROM
		DML.CANTOR CAN
	INNER JOIN (
			SELECT
				COD_CANTOR, COUNT(DISTINCT(COD_GRAVADORA)) AS GRAV
			FROM
				DML.GRAVACAO
			GROUP BY
				COD_CANTOR 
		) SUB1 ON
		CAN.COD_CANTOR = SUB1.COD_CANTOR 
	)
ORDER BY CANTOR;


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