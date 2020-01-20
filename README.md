# ControleFinanceiro

Backend para aplicação de controle financeiro

drop table transactions;

drop table provents;

drop table transactions_types;

drop table papers;

drop table provents_types;

create table transactions_types (id serial not null,
sigla varchar(2),
description varchar(100),
primary key (id));

create table papers (id serial not null,
name varchar(10),
description varchar(100),
primary key (id));

create table transactions (id serial not null,
transactions_types_id int not null references transactions_types ,
papers_id int not null references papers ,
value numeric(12,
6) not null,
quantity numeric(12,
6) not null,
transaction_date date not null,
primary key (id));

create table provents_types (id serial not null,
sigla varchar(100),
description varchar(100),
primary key (id));

create table provents (id serial not null,
provents_types_id int not null references provents_types ,
papers_id int not null references papers ,
value numeric(12,
6) not null,
provents_date date not null,
primary key (id));

insert
	into
	papers (name,
	description)
values('ITSA4',
'ITAUSA');

insert
	into
	papers (name,
	description)
values('KNRI11',
'KINEA RENDA IMOBILIÁRIA');

insert
	into
	transactions_types (sigla,
	description)
values('C',
'Compra');

insert
	into
	transactions_types (sigla,
	description)
values('V',
'Venda');

insert
	into
	transactions (transactions_types_id,
	papers_id,
	value,
	quantity,
	transaction_date)
values(1,
1,
10,
1,
date '2019-09-15');

insert
	into
	transactions (transactions_types_id,
	papers_id,
	value,
	quantity,
	transaction_date)
values(1,
1,
12,
1,
date '2019-09-28');

insert
	into
	transactions (transactions_types_id,
	papers_id,
	value,
	quantity,
	transaction_date)
values(1,
2,
15.13,
2,
date '2019-10-28');

insert
	into
	transactions (transactions_types_id,
	papers_id,
	value,
	quantity,
	transaction_date)
values(2,
2,
16.11,
1,
date '2019-11-28');

insert
	into
	transactions (transactions_types_id,
	papers_id,
	value,
	quantity,
	transaction_date)
values(1,
2,
13.157864,
3,
date '2019-11-10');

insert
	into
	provents_types (sigla,
	description)
values('DI',
'Dividendo');

insert
	into
	provents_types (sigla,
	description)
values('JCP',
'Juros sobre Capital Próprio');

insert
	into
	provents (provents_types_id,
	papers_id,
	value,
	provents_date)
values(1,
1,
1,
date '2019-11-10');

insert
	into
	provents (provents_types_id,
	papers_id,
	value,
	provents_date)
values(1,
1,
2,
date '2019-12-10');

insert
	into
	provents (provents_types_id,
	papers_id,
	value,
	provents_date)
values(1,
1,
2.3,
date '2019-10-10');

insert
	into
	provents (provents_types_id,
	papers_id,
	value,
	provents_date)
values(1,
1,
3.511254,
date '2020-01-10');

create view buy_average_value as
select
	papers.id,
	papers.name,
	sum(transactions.value * transactions.quantity) as total_value,
	sum(transactions.quantity) as total_quantity,
	sum(transactions.value * transactions.quantity)/ sum(transactions.quantity) as buy_average_value
from
	transactions
left join papers on
	papers.id = transactions.papers_id
left join transactions_types on
	transactions_types.id = transactions.transactions_types_id
where
	transactions_types_id = 1
group by
	papers.id,
	papers.id;

create view total_provents as
select
	papers.id,
	papers.name,
	sum(value) as total_provents
from
	provents
left join papers on
	papers.id = provents.papers_id
group by
	papers.id,
	papers.name;



create view dividend_yeld as
select
	buy_average_value.id,
	buy_average_value.name,
	(total_provents.total_provents / buy_average_value.total_value)* 100 as DY
from
	buy_average_value
left join total_provents on
	total_provents.id = buy_average_value.id;



 
