# ControleFinanceiro

Backend para aplicação de controle financeiro

CREATE TABLE transactionType (id serial NOT NULL, description varchar(100), PRIMARY KEY (id));

CREATE TABLE paper (id serial NOT NULL, name varchar(10), description varchar(100), PRIMARY KEY (id));

CREATE TABLE transaction (id serial NOT NULL, trasactionType_id int not null references transactionType , paper_id int not null references paper , PRIMARY KEY (id));
