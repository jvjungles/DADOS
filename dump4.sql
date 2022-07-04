-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.6.4-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para dml
CREATE DATABASE IF NOT EXISTS `dml` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dml`;

-- Copiando estrutura para tabela dml.cantor
CREATE TABLE IF NOT EXISTS `cantor` (
  `cod_cantor` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cantor` varchar(50) DEFAULT NULL,
  `pais` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_cantor`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela dml.cantor: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `cantor` DISABLE KEYS */;
INSERT INTO `cantor` (`cod_cantor`, `nome_cantor`, `pais`) VALUES
	(1, 'Marisa Monte', 'Brasil'),
	(2, 'Coldplay', 'Inglaterra'),
	(3, 'U2', 'Irlanda'),
	(4, 'Djavan', 'Brasil'),
	(5, 'Laura Pausini', 'Italia'),
	(6, 'Roberto Leal', 'Portugal'),
	(7, 'The Corrs', 'Estados Unidos'),
	(8, 'Legiao Urbana', 'Brasil'),
	(9, 'Cazuza', 'Brasil'),
	(10, 'Tom Jobim', 'Brasil'),
	(11, 'Frank Sinatra', 'Estados Unidos');
/*!40000 ALTER TABLE `cantor` ENABLE KEYS */;

-- Copiando estrutura para tabela dml.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `cod_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `desc_categoria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela dml.categoria: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`cod_categoria`, `desc_categoria`) VALUES
	(1, 'MPB'),
	(2, 'Rock'),
	(3, 'Vira'),
	(4, 'Bossa Nova'),
	(5, 'Jazz'),
	(6, 'Pop rock'),
	(7, 'Eletronic'),
	(8, 'Pop');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Copiando estrutura para tabela dml.fone
CREATE TABLE IF NOT EXISTS `fone` (
  `cod_fone` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(80) DEFAULT NULL,
  `tipo` char(1) DEFAULT NULL,
  `cod_pessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_fone`),
  KEY `fone_cod_pessoa_fkey` (`cod_pessoa`),
  CONSTRAINT `fone_cod_pessoa_fkey` FOREIGN KEY (`cod_pessoa`) REFERENCES `pessoa` (`cod_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela dml.fone: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `fone` DISABLE KEYS */;
INSERT INTO `fone` (`cod_fone`, `numero`, `tipo`, `cod_pessoa`) VALUES
	(1, '3333-1111', 'R', 1),
	(2, '4444-1111', 'C', 1),
	(3, '9999-1111', 'L', 1),
	(4, '3333-2222', 'R', 2),
	(5, '4444-2222', 'C', 2),
	(6, '9999-2222', 'L', 2),
	(7, '3333-3333', 'R', 3),
	(8, '4444-3333', 'C', 3),
	(9, '8888-3333', 'L', 3);
/*!40000 ALTER TABLE `fone` ENABLE KEYS */;

-- Copiando estrutura para tabela dml.gravacao
CREATE TABLE IF NOT EXISTS `gravacao` (
  `cod_gravacao` int(11) NOT NULL AUTO_INCREMENT,
  `cod_gravadora` int(11) NOT NULL,
  `cod_cantor` int(11) NOT NULL,
  `cod_musica` int(11) NOT NULL,
  `data_gravacao` date DEFAULT NULL,
  PRIMARY KEY (`cod_gravacao`),
  KEY `gravacao_cod_cantor_fkey` (`cod_cantor`),
  KEY `gravacao_cod_gravadora_fkey` (`cod_gravadora`),
  KEY `gravacao_cod_musica_fkey` (`cod_musica`),
  CONSTRAINT `gravacao_cod_cantor_fkey` FOREIGN KEY (`cod_cantor`) REFERENCES `cantor` (`cod_cantor`),
  CONSTRAINT `gravacao_cod_gravadora_fkey` FOREIGN KEY (`cod_gravadora`) REFERENCES `gravadora` (`cod_gravadora`),
  CONSTRAINT `gravacao_cod_musica_fkey` FOREIGN KEY (`cod_musica`) REFERENCES `musica` (`cod_musica`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela dml.gravacao: ~25 rows (aproximadamente)
/*!40000 ALTER TABLE `gravacao` DISABLE KEYS */;
INSERT INTO `gravacao` (`cod_gravacao`, `cod_gravadora`, `cod_cantor`, `cod_musica`, `data_gravacao`) VALUES
	(1, 1, 1, 1, '2000-07-10'),
	(2, 1, 1, 2, '2000-12-07'),
	(3, 1, 1, 3, '2001-05-30'),
	(4, 3, 8, 4, '2005-12-29'),
	(5, 3, 8, 5, '1993-04-25'),
	(6, 3, 8, 6, '1989-01-31'),
	(7, 3, 8, 7, '1991-12-01'),
	(8, 3, 6, 8, '1988-07-30'),
	(9, 4, 10, 9, '1978-10-14'),
	(10, 4, 10, 10, '1975-08-11'),
	(11, 4, 10, 11, '1979-05-05'),
	(12, 4, 10, 12, '1981-04-18'),
	(13, 1, 2, 13, '2004-09-12'),
	(14, 1, 2, 14, '2004-09-20'),
	(15, 1, 2, 15, '2004-08-30'),
	(16, 1, 2, 16, '2004-10-01'),
	(17, 4, 9, 17, '1986-06-30'),
	(18, 5, 9, 18, '1987-07-06'),
	(19, 1, 11, 19, '1971-08-29'),
	(20, 3, 5, 20, '1998-10-10'),
	(21, 5, 4, 21, '1995-01-20'),
	(22, 1, 3, 22, '1989-05-05'),
	(23, 1, 3, 23, '1991-10-20'),
	(24, 1, 3, 24, '1992-03-25'),
	(25, 5, 1, 25, '1998-10-20');
/*!40000 ALTER TABLE `gravacao` ENABLE KEYS */;

-- Copiando estrutura para tabela dml.gravadora
CREATE TABLE IF NOT EXISTS `gravadora` (
  `cod_gravadora` int(11) NOT NULL AUTO_INCREMENT,
  `nome_gravadora` varchar(50) DEFAULT NULL,
  `pais` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_gravadora`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela dml.gravadora: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `gravadora` DISABLE KEYS */;
INSERT INTO `gravadora` (`cod_gravadora`, `nome_gravadora`, `pais`) VALUES
	(1, 'Sony', 'Estados Unidos'),
	(2, 'Som livre', 'Brasil'),
	(3, 'EMI', 'Estados Unidos'),
	(4, 'Globo', 'Brasil'),
	(5, 'Trama', 'Brasil');
/*!40000 ALTER TABLE `gravadora` ENABLE KEYS */;

-- Copiando estrutura para tabela dml.musica
CREATE TABLE IF NOT EXISTS `musica` (
  `cod_musica` int(11) NOT NULL AUTO_INCREMENT,
  `cod_categoria` int(11) NOT NULL,
  `duracao` int(11) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_musica`),
  KEY `musica_cod_categoria_fkey` (`cod_categoria`),
  CONSTRAINT `musica_cod_categoria_fkey` FOREIGN KEY (`cod_categoria`) REFERENCES `categoria` (`cod_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela dml.musica: ~25 rows (aproximadamente)
/*!40000 ALTER TABLE `musica` DISABLE KEYS */;
INSERT INTO `musica` (`cod_musica`, `cod_categoria`, `duracao`, `titulo`) VALUES
	(1, 1, 240, 'Amor I love you'),
	(2, 1, 300, 'Nao e facil'),
	(3, 1, 250, 'Gentileza'),
	(4, 2, 500, 'Daniel na cova dos leoes'),
	(5, 2, 322, 'Fabrica'),
	(6, 2, 440, 'Tempo perdido'),
	(7, 2, 312, 'Acrilic on canvas'),
	(8, 3, 298, 'Vira-vira'),
	(9, 4, 348, 'Chega de saudade'),
	(10, 4, 231, 'Luiza'),
	(11, 4, 355, 'Aguas de marco'),
	(12, 4, 250, 'Wave'),
	(13, 6, 333, 'Politik'),
	(14, 6, 225, 'Green eyes'),
	(15, 6, 440, 'A Rush of Blood to the head'),
	(16, 6, 320, 'Clocks'),
	(17, 6, 300, 'Codinome beija-flor'),
	(18, 6, 290, 'Faz parte do meu show'),
	(19, 5, 446, 'New York'),
	(20, 8, 299, 'Solitudine'),
	(21, 1, 430, 'Oceano'),
	(22, 2, 511, 'With or without you'),
	(23, 2, 300, 'Beautiful day'),
	(24, 2, 458, 'Bullet The Blue Sky'),
	(25, 1, 300, 'Sua');
/*!40000 ALTER TABLE `musica` ENABLE KEYS */;

-- Copiando estrutura para tabela dml.pessoa
CREATE TABLE IF NOT EXISTS `pessoa` (
  `cod_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome_pessoa` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`cod_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela dml.pessoa: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` (`cod_pessoa`, `nome_pessoa`) VALUES
	(1, 'Ana'),
	(2, 'Beto'),
	(3, 'Carlos'),
	(4, 'Daniel'),
	(5, 'Eduardo'),
	(6, 'Flavio'),
	(7, 'Giuliana'),
	(8, 'Helena'),
	(9, 'Ivan');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
