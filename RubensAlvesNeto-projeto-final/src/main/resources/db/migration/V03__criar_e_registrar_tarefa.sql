CREATE TABLE tarefa (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL,
	dataRealizacao DATE NOT NULL,
	observacao VARCHAR(50),	
	id_etiqueta BIGINT(20) NOT NULL,
	id_usuario BIGINT(20) NOT NULL,
	FOREIGN KEY (id_etiqueta) REFERENCES etiqueta(id),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tarefa (descricao, dataRealizacao, observacao, id_etiqueta, id_usuario) 
	values ('Rendimento da Poupança', '2021-09-10', 'RECEITA', 1, 1);
INSERT INTO tarefa (descricao, dataRealizacao, observacao, id_etiqueta, id_usuario) 
	values ('Compra da semana', '2021-09-30', 'DESPESA', 2, 2);