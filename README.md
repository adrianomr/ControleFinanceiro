# ControleFinanceiro

Backend para aplicação de controle financeiro

DROP TABLE transaction;

DROP TABLE transaction_type;

DROP TABLE paper;

CREATE TABLE transaction_type (id serial NOT NULL, sigla varchar(2), description varchar(100), PRIMARY KEY (id));

CREATE TABLE paper (id serial NOT NULL, name varchar(10), description varchar(100), PRIMARY KEY (id));

CREATE TABLE transaction (id serial NOT NULL, trasactionType_id int not null references transaction_type , paper_id int not null references paper , value NUMERIC(12,6) NOT NULL, PRIMARY KEY (id));

INSERT INTO paper (name, description) VALUES('ITSA4', 'ITAUSA');

INSERT INTO transaction_type (sigla, description) VALUES('V', 'Venda');

INSERT INTO transaction (trasactionType_id, paper_id, value) VALUES(1, 1, 10);
