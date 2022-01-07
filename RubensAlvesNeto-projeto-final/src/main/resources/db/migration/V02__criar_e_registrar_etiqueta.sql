CREATE TABLE etiqueta (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO etiqueta (nome) values ('João Silva');
INSERT INTO etiqueta (nome) values ('Maria Rita');