# ControleFinanceiro
Backend para aplicação de controle financeiro
CREATE TABLE trasactionType (id serial NOT NULL, description varchar(100), PRIMARY KEY (id));
CREATE TABLE paper (id serial NOT NULL, name varchar(10), description varchar(100), PRIMARY KEY (id));
CREATE TABLE transaction (id serial NOT NULL, trasactionType_id, paper_id, PRIMARY KEY (id));
