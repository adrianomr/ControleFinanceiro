# ControleFinanceiro

Backend para aplicação de controle financeiro

DROP TABLE transactions;
DROP TABLE provents;
DROP TABLE transactions_types;
DROP TABLE papers;
DROP TABLE provents_types;
CREATE TABLE transactions_types (id serial NOT NULL, sigla varchar(2), description varchar(100), PRIMARY KEY (id));
CREATE TABLE papers (id serial NOT NULL, name varchar(10), description varchar(100), PRIMARY KEY (id));
CREATE TABLE transactions (id serial NOT NULL, transactions_types_id int not null references transactions_types , papers_id int not null references papers , value NUMERIC(12,6) NOT NULL, PRIMARY KEY (id));
CREATE TABLE provents_types (id serial NOT NULL, sigla varchar(100), description varchar(100), PRIMARY KEY (id));
CREATE TABLE provents (id serial NOT NULL, provents_types_id int not null references provents_types , papers_id int not null references papers , value NUMERIC(12,6) NOT NULL, PRIMARY KEY (id));
INSERT INTO papers (name, description) VALUES('ITSA4', 'ITAUSA');
INSERT INTO transactions_types (sigla, description) VALUES('C', 'Compra');
INSERT INTO transactions (transactions_types_id, papers_id, value) VALUES(1, 1, 10);
INSERT INTO provents_types (sigla, description) VALUES('DI', 'Dividendo');
INSERT INTO provents (provents_types_id, papers_id, value) VALUES(1, 1, 1);
