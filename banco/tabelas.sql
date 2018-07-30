CREATE TABLE CONTATO(
	nome VARCHAR,
	email VARCHAR PRIMARY KEY,
	senha VARCHAR,
	telefone VARCHAR UNIQUE,
	nascimento Date
);

INSERT INTO CONTATO(nome,email,senha,telefone,nascimento)
VALUES ('Flavio','flavio@gmail.com','flavio','991878787','1998-09-28');
