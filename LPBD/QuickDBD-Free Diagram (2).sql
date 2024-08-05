-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/nG2M9Z
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.

-- Modify this code to update the DB schema diagram.
-- To reset the sample schema, replace everything with
-- two dots ('..' - without quotes).

CREATE TABLE `Imobiliaria` (
    `casaID` int  NOT NULL ,
    `status` int  NOT NULL ,
    `venda` boolean  NOT NULL ,
    `construcao` date  NOT NULL ,
    `endID` int  NOT NULL ,
    `valor` float  NOT NULL ,
    `valorL` float  NULL ,
    PRIMARY KEY (
        `casaID`
    )
);

CREATE TABLE `Endereco` (
    `endID` int  NOT NULL ,
    `rua` varchar(50)  NOT NULL ,
    `numero` int  NOT NULL ,
    `bairro` varchar(50)  NOT NULL ,
    `cidade` varchar(50)  NOT NULL ,
    `UF` char(2)  NOT NULL ,
    `cep` int  NOT NULL ,
    PRIMARY KEY (
        `endID`
    )
);

CREATE TABLE `Casa` (
    `casaID` int  NOT NULL ,
    `quartos` int  NOT NULL ,
    `suites` int  NOT NULL ,
    `salaEstar` int  NOT NULL ,
    `salaJantar` int  NOT NULL ,
    `vagas` int  NOT NULL ,
    `area` float  NOT NULL ,
    `armario` int  NOT NULL ,
    `descricao` varchar(100)  NOT NULL 
);

CREATE TABLE `apartamento` (
    `casaID` int  NOT NULL ,
    `quartos` int  NOT NULL ,
    `suites` int  NOT NULL ,
    `salaEstar` int  NOT NULL ,
    `salaJantar` int  NOT NULL ,
    `vagas` int  NOT NULL ,
    `area` float  NOT NULL ,
    `armario` int  NOT NULL ,
    `descricao` varchar(100)  NOT NULL ,
    `andar` int  NOT NULL ,
    `condominio` float  NOT NULL ,
    `portaria24` boolean  NOT NULL 
);

CREATE TABLE `salaComercial` (
    `casaID` int  NOT NULL ,
    `area` float  NOT NULL ,
    `banheiros` int  NOT NULL ,
    `comodos` int  NOT NULL ,
    `descricao` varchar(100)  NOT NULL 
);

CREATE TABLE `terreno` (
    `casaID` int  NOT NULL ,
    `area` float  NOT NULL ,
    `largura` float  NOT NULL ,
    `comprimento` float  NOT NULL ,
    `aclive` boolean  NOT NULL ,
    `descricao` varchar(100)  NOT NULL 
);

CREATE TABLE `Fotos` (
    `casaID` int  NOT NULL ,
    `nome` varchar(50)  NOT NULL ,
    `URL` varchar(50)  NOT NULL 
);

CREATE TABLE `Cliente` (
    `id` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `RelacaoCliente` (
    `casaID` int  NOT NULL ,
    `clienteID` int  NOT NULL ,
    `relacao` int  NOT NULL 
);

ALTER TABLE `Imobiliaria` ADD CONSTRAINT `fk_Imobiliaria_endID` FOREIGN KEY(`endID`)
REFERENCES `Endereco` (`endID`);

ALTER TABLE `Casa` ADD CONSTRAINT `fk_Casa_casaID` FOREIGN KEY(`casaID`)
REFERENCES `Imobiliaria` (`casaID`);

ALTER TABLE `apartamento` ADD CONSTRAINT `fk_apartamento_casaID` FOREIGN KEY(`casaID`)
REFERENCES `Imobiliaria` (`casaID`);

ALTER TABLE `salaComercial` ADD CONSTRAINT `fk_salaComercial_casaID` FOREIGN KEY(`casaID`)
REFERENCES `Imobiliaria` (`casaID`);

ALTER TABLE `terreno` ADD CONSTRAINT `fk_terreno_casaID` FOREIGN KEY(`casaID`)
REFERENCES `Imobiliaria` (`casaID`);

ALTER TABLE `Fotos` ADD CONSTRAINT `fk_Fotos_casaID` FOREIGN KEY(`casaID`)
REFERENCES `Imobiliaria` (`casaID`);

ALTER TABLE `RelacaoCliente` ADD CONSTRAINT `fk_RelacaoCliente_casaID` FOREIGN KEY(`casaID`)
REFERENCES `Imobiliaria` (`casaID`);

ALTER TABLE `RelacaoCliente` ADD CONSTRAINT `fk_RelacaoCliente_clienteID` FOREIGN KEY(`clienteID`)
REFERENCES `Cliente` (`id`);

