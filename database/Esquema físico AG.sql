CREATE DATABASE easytrips;

use easytrips;

CREATE TABLE Login (
id_login INTEGER PRIMARY KEY auto_increment,
tipoLogin VARCHAR(20)
);

CREATE TABLE Cliente (
id_cliente INTEGER PRIMARY KEY auto_increment,
id_login INTEGER,
emailCliente VARCHAR(50),
nomeCliente VARCHAR(50),
senhaCliente VARCHAR(50),
cpfCliente VARCHAR(50)
);

CREATE TABLE Compra (
id_compra INTEGER PRIMARY KEY auto_increment,
id_pacote INTEGER,
id_cliente INTEGER,
valor_itens DECIMAL(5,2),
qtd_itens DECIMAL(5,2),
dataCompra DATE,
valorCompra DECIMAL(5,2),
FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente),
FOREIGN KEY(id_pacote) REFERENCES PacotesViagem (id_pacote)
);

CREATE TABLE Destinos (
id_destino INTEGER PRIMARY KEY auto_increment,
data_volta DATE,
pais VARCHAR(20),
cidade_origem VARCHAR(30),
data_ida DATE
);

CREATE TABLE Hoteis (
id_hotel INTEGER PRIMARY KEY auto_increment,
cafeDaManha VARCHAR(10),
valor_diaria DECIMAL(5,2),
nome_hotel VARCHAR(30)
);

CREATE TABLE PacotesViagem (
id_pacote INTEGER PRIMARY KEY auto_increment,
id_destino INTEGER,
id_hotel integer,
valor_pacote DECIMAL(5,2),
promo VARCHAR(10),
FOREIGN KEY(id_hotel) REFERENCES Hoteis (id_hotel)
);

ALTER TABLE Cliente ADD FOREIGN KEY(id_login) REFERENCES Login (id_login);
ALTER TABLE PacotesViagem ADD FOREIGN KEY(id_destino) REFERENCES Destinos (id_destino);
ALTER TABLE Destinos ADD nomeDestino VARCHAR(50);

create view cliente_login as 
select
c.*,
l.id_login as login,
l.tipoLogin from cliente c , login l where c.id_login = l.id_login;

