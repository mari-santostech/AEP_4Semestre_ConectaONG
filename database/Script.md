# Script para criação das tabelas

CREATE TABLE doador (
    id_doador INT PRIMARY KEY,
    nome_fantasia VARCHAR(100),
    cnpj VARCHAR(20),
    nome_responsavel VARCHAR(100),
    telefone VARCHAR(20),
    email VARCHAR(100),
    endereco_completo VARCHAR(200)
);

CREATE TABLE entidade_beneficente (
    id_entidade INT PRIMARY KEY,
    nome_fantasia VARCHAR(100),
    cnpj VARCHAR(20),
    responsavel_tecnico VARCHAR(100),
    telefone VARCHAR(20),
    email VARCHAR(100),
    endereco_completo VARCHAR(200)
);

CREATE TABLE doacao (
    id_doacao INT PRIMARY KEY,
    id_doador INT,
    id_entidade INT,
    data_doacao DATE,
    status VARCHAR(50),
    CONSTRAINT fk_doador FOREIGN KEY (id_doador) REFERENCES doador(id_doador),
    CONSTRAINT fk_entidade FOREIGN KEY (id_entidade) REFERENCES entidade_beneficente(id_entidade)
);

CREATE TABLE item_doacao (
    id_item INT PRIMARY KEY,
    id_doacao INT,
    descricao_alimento VARCHAR(150),
    categoria VARCHAR(100),
    quantidade DECIMAL(10,2),
    unidade_medida VARCHAR(60),
    data_validade DATE,
    CONSTRAINT fk_doacao FOREIGN KEY (id_doacao) REFERENCES doacao(id_doacao)
);
