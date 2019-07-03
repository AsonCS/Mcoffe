/*

create database if not exists mcoffe default character set utf8 default collate utf8_general_ci;

create table if not exists estoque (cod smallint not null auto_increment,pro varchar (30) not null,pmp decimal(6,2),pre decimal(6,2) not null,qua smallint not null,qum tinyint,primary key (cod)) default charset = utf8;

create table if not exists cliente (id smallint not null primary key auto_increment,nome varchar(30)not null,cpf decimal(11,0)not null,cep decimal(8,0)not null,cpre decimal(6,2)) default charset = utf8;

create table if not exists comanda (id smallint not null primary key auto_increment,num varchar (3) not null,lpre decimal(6,2)) default charset = utf8;

create table if not exists venda (idCli smallint, idCom smallint, codPro smallint, pre decimal, dat date) default charset = utf8;

*/

create database mcoffe
default character set utf8 default
collate utf8_general_ci;

use mcoffe;

create table estoque (
cod smallint not null auto_increment,
pro varchar (30) not null,
pmp decimal(6,2),
pre decimal(6,2) not null,
qua smallint not null,
qum tinyint,
primary key (cod)
) default charset = utf8;

insert into estoque values (default,'Coca cola 2L','4.5','7','20','5'),
(default,'Dolly 2L','1.25','2.5','20','5'),
(default,'Torcida','.75','1.5','80','20'),
(default,'Ovo de pascoa','40','70','30','5');
select * from estoque; 

create table cliente (
id smallint not null primary key auto_increment,
nome varchar(30)not null,
cpf decimal(11,0)not null,
cep decimal(8,0)not null,
cpro varchar(30),
cpre decimal(6,2),
cdat date
) default charset = utf8;

insert into cliente values ('1','a','12345678901','12345678','1','1','2016-1-1');
delete from mcoffe.cliente where id='1';
drop table cliente;
select * from estoque; 
select * from estoque where pro like '%coc%';

create table comanda (
id smallint not null primary key auto_increment,
num varchar (3) not null,
lpro varchar(30),
lpre decimal(6,2),
ldat date
) default charset = utf8;

create table servico (
scod smallint not null primary key auto_increment,
ser varchar(30)not null,
spre decimal(6,2)
) default charset = utf8;
select * from servico;
insert into servico values (default,'Marmita','12'),
(default,'Prato Feito','12'),
(default,'Suco','2'),
(default,'Selfservice','25'),
(default,'Quilo','5');

use mcoffe;
select * from cliente;
select * from comanda;

insert into cliente (id,nome,cpf,cep,cpro,cpre,cdat)
values(default,'anderson','44942030846','06624170','','0','2016-03-24'),
(default,'costa','44942030800','06624171','','0','2016-03-24'),
(default,'silva','00042030846','08824170','','0','2016-03-24'),
(default,'adelmo','16425715553','06624170','','0','2016-03-24');

alter table comanda
drop ldat;

insert into comanda values(default,'001','0','2016-03-24',''),
(default,'002','0','2016-03-24',''),
(default,'003','0','2016-03-24',''),
(default,'004','0','2016-03-24','');

select * from cliente where nome like 'anderson';

select * from cliente ;
UPDATE `mcoffe`.`cliente` SET `nome`='Adelmo' WHERE `id`='5';
update mcoffe.cliente set cpre='1' where nome='anderson';