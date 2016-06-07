--Apaga as tabelas
DROP TABLE IF EXISTS emp CASCADE;
DROP TABLE IF EXISTS dep CASCADE;

--Tabela dep
CREATE TABLE dep (
    n_dep int auto_increment,
    nome_dep varchar(20),
    local_dep varchar(30),
    PRIMARY KEY (n_dep)
);

INSERT INTO dep VALUES (DEFAULT, 'Administracao', 'Campinas');
INSERT INTO dep VALUES (DEFAULT, 'Pesquisa', 'Campinas');
INSERT INTO dep VALUES (DEFAULT, 'Vendas', 'Sao Paulo');
INSERT INTO dep VALUES (DEFAULT, 'Producao', 'Sao Paulo');

--Tabela emp
CREATE TABLE emp (
    n_emp int auto_increment,
    nome_emp varchar(30) NOT NULL,
    cargo varchar(10) NOT NULL,
    sal numeric(10,2) NOT NULL,
    PRIMARY KEY (n_emp),   
    CHECK (sal > 0)
);

INSERT INTO emp VALUES (DEFAULT, 'Pedro', 'Presidente', 15000.00);
INSERT INTO emp VALUES (DEFAULT, 'Ubaldo', 'Diretor', 8000.00);
INSERT INTO emp VALUES (DEFAULT, 'Rosa', 'Diretor', 3300.00);
INSERT INTO emp VALUES (DEFAULT, 'Eduardo', 'Vendedor', 2000.00);
INSERT INTO emp VALUES (DEFAULT, 'Sérgio', 'Vendedor', 1500.00);
INSERT INTO emp VALUES (DEFAULT, 'Augusta', 'Secretária', 1200.00);
INSERT INTO emp VALUES (DEFAULT, 'Ronaldo', 'Analista', 5000.00);
INSERT INTO emp VALUES (DEFAULT, 'Sílvia', 'Analista', 1500.00);