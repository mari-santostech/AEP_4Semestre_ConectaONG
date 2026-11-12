
CREATE DATABASE IF NOT EXISTS `mydb`
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE `mydb`;

CREATE TABLE IF NOT EXISTS `doador` (
                                        `id_doador` INT NOT NULL AUTO_INCREMENT,
                                        `nome_fantasia` VARCHAR(100) NOT NULL,
    `cnpj` VARCHAR(20) NOT NULL,
    `nome_responsavel` VARCHAR(100) NOT NULL,
    `telefone` VARCHAR(20) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `endereco_completo` VARCHAR(200) NOT NULL,
    PRIMARY KEY (`id_doador`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `entidade_beneficente` (
                                                      `id_entidade` INT NOT NULL AUTO_INCREMENT,
                                                      `nome_fantasia` VARCHAR(100) NOT NULL,
    `cnpj` VARCHAR(20) NOT NULL,
    `responsavel_tecnico` VARCHAR(100) NOT NULL,
    `telefone` VARCHAR(20) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `endereco_completo` VARCHAR(200) NOT NULL,
    PRIMARY KEY (`id_entidade`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `doacao` (
                                        `id_doacao` INT NOT NULL AUTO_INCREMENT,
                                        `id_doador` INT NOT NULL,
                                        `id_entidade` INT NOT NULL,
                                        `data_doacao` DATE NOT NULL,
                                        `status` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id_doacao`),
    KEY `fk_doacao_doador_idx` (`id_doador`),
    KEY `fk_doacao_entidade_idx` (`id_entidade`),
    CONSTRAINT `fk_doacao_doador`
    FOREIGN KEY (`id_doador`) REFERENCES `doador` (`id_doador`),
    CONSTRAINT `fk_doacao_entidade`
    FOREIGN KEY (`id_entidade`) REFERENCES `entidade_beneficente` (`id_entidade`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `item_doacao` (
                                             `id_item` INT NOT NULL AUTO_INCREMENT,
                                             `id_doacao` INT NOT NULL,
                                             `descricao_alimento` VARCHAR(150) NOT NULL,
    `categoria` VARCHAR(100) NOT NULL,
    `quantidade` DECIMAL(10,2) NOT NULL,
    `unidade_medida` VARCHAR(60) NOT NULL,
    `data_validade` DATE NOT NULL,
    PRIMARY KEY (`id_item`),
    KEY `fk_item_doacao_doacao_idx` (`id_doacao`),
    CONSTRAINT `fk_item_doacao_doacao`
    FOREIGN KEY (`id_doacao`) REFERENCES `doacao` (`id_doacao`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
