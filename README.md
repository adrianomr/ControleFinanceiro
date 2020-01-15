# ControleFinanceiro

Backend para aplicação de controle financeiro

DROP TABLE transaction;

DROP TABLE transaction_type;

DROP TABLE paper;

CREATE TABLE transaction_type (id serial NOT NULL, description varchar(100), PRIMARY KEY (id));

CREATE TABLE paper (id serial NOT NULL, name varchar(10), description varchar(100), PRIMARY KEY (id));

CREATE TABLE transaction (id serial NOT NULL, trasactionType_id int not null references transaction_type , paper_id int not null references paper , value NUMERIC(12,6) NOT NULL, PRIMARY KEY (id));
