# ControleFinanceiro

Backend para aplicação de controle financeiro

DROP TABLE transactions;
DROP TABLE provents;
DROP TABLE transactions_types;
DROP TABLE papers;
DROP TABLE provents_types;
CREATE TABLE transactions_types (id serial NOT NULL, sigla varchar(2), description varchar(100), PRIMARY KEY (id));
CREATE TABLE papers (id serial NOT NULL, name varchar(10), description varchar(100), PRIMARY KEY (id));
CREATE TABLE transactions (id serial NOT NULL, transactions_types_id int not null references transactions_types , papers_id int not null references papers , value NUMERIC(12,6) NOT NULL, quantity NUMERIC(12,6) NOT NULL, PRIMARY KEY (id));
CREATE TABLE provents_types (id serial NOT NULL, sigla varchar(100), description varchar(100), PRIMARY KEY (id));
CREATE TABLE provents (id serial NOT NULL, provents_types_id int not null references provents_types , papers_id int not null references papers , value NUMERIC(12,6) NOT NULL, PRIMARY KEY (id));
INSERT INTO papers (name, description) VALUES('ITSA4', 'ITAUSA');
INSERT INTO papers (name, description) VALUES('KNRI11', 'KINEA RENDA IMOBILIÁRIA');
INSERT INTO transactions_types (sigla, description) VALUES('C', 'Compra');
INSERT INTO transactions_types (sigla, description) VALUES('V', 'Venda');
INSERT INTO transactions (transactions_types_id, papers_id, value, quantity) VALUES(1, 1, 10, 1);
INSERT INTO transactions (transactions_types_id, papers_id, value, quantity) VALUES(1, 1, 12, 1);
INSERT INTO transactions (transactions_types_id, papers_id, value, quantity) VALUES(1, 2, 15.13, 2);
INSERT INTO transactions (transactions_types_id, papers_id, value, quantity) VALUES(2, 2, 16.11, 1);
INSERT INTO transactions (transactions_types_id, papers_id, value, quantity) VALUES(1, 2, 13.157864, 3);
INSERT INTO provents_types (sigla, description) VALUES('DI', 'Dividendo');
INSERT INTO provents_types (sigla, description) VALUES('JCP', 'Juros sobre Capital Próprio');
INSERT INTO provents (provents_types_id, papers_id, value) VALUES(1, 1, 1);
INSERT INTO provents (provents_types_id, papers_id, value) VALUES(1, 1, 2);
INSERT INTO provents (provents_types_id, papers_id, value) VALUES(1, 1, 2.3);
INSERT INTO provents (provents_types_id, papers_id, value) VALUES(1, 1, 3.511254);



CREATE VIEW buy_average_value AS
    select 
 papers.id, 
 papers.name, 
 SUM(transactions.value * transactions.quantity) as total_value,
 SUM(transactions.quantity)  as total_quantity,
 SUM(transactions.value * transactions.quantity)/SUM(transactions.quantity) as buy_average_value 
 from transactions 
 left join papers on papers.id = transactions.papers_id
 left join transactions_types on transactions_types.id = transactions.transactions_types_id
 where transactions_types_id = 1
 group by papers.id, papers.id;
 
CREATE VIEW total_provents AS
select papers.id, papers.name, sum(value) as total_provents from provents
left join papers on papers.id = provents.papers_id
group by papers.id, papers.name;
