-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.

-- Modify this code to update the DB schema diagram.
-- To reset the sample schema, replace everything with
-- two dots ('..' - without quotes).

CREATE TABLE `casa` (
    `id` int  NOT NULL ,
    `quartos` int  NOT NULL ,
    `suites` int  NOT NULL ,
    `banheiro` int  NOT NULL ,
    `salasStar` int  NOT NULL ,
    `salasJantar` int  NOT NULL ,
    `garagem` int  NOT NULL ,
    `area` float  NOT NULL ,
    `armarioEmbutido` boolean  NOT NULL ,
    `endid` int  NOT NULL ,
    `properid` int  NOT NULL ,
    `imagensid` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `apertamento` (
    `id` int  NOT NULL ,
    `andar` int  NOT NULL ,
    `condominio` float  NOT NULL ,
    `portaria24` boolean  NOT NULL ,
    `piscina` boolean  NOT NULL ,
    `churrasqueira` boolean  NOT NULL ,
    `quartos` int  NOT NULL ,
    `suites` int  NOT NULL ,
    `banheiro` int  NOT NULL ,
    `salasStar` int  NOT NULL ,
    `salasJantar` int  NOT NULL ,
    `garagem` int  NOT NULL ,
    `area` float  NOT NULL ,
    `varanda` boolean  NOT NULL ,
    `armarioEmbutido` boolean  NOT NULL ,
    `endid` int  NOT NULL ,
    `properid` int  NOT NULL ,
    `imagensid` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `terreno` (
    `id` int  NOT NULL ,
    `area` float  NOT NULL ,
    `largura` float  NOT NULL ,
    `comprimento` float  NOT NULL ,
    `tipo` int  NOT NULL ,
    `endid` int  NOT NULL ,
    `properid` int  NOT NULL ,
    `imagensid` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `salaComercial` (
    `id` int  NOT NULL ,
    `banheiros` int  NOT NULL ,
    `comodos` int  NOT NULL ,
    `area` float  NOT NULL ,
    `vagas` int  NOT NULL ,
    `endid` int  NOT NULL ,
    `properid` int  NOT NULL ,
    `imagensid` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `enderecos` (
    `id` int  NOT NULL ,
    `rua` str  NOT NULL ,
    `bairro` str  NULL ,
    `cidade` str  NOT NULL ,
    `numero` str  NOT NULL ,
    `cep` int  NOT NULL ,
    `UF` str  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `imagens` (
    `id` int  NOT NULL ,
    `url` str  NOT NULL ,
    `nomeImg` str  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `imoveis` (
    `id` int  NOT NULL ,
    `valor` float  NOT NULL ,
    `status` string  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `cliente` (
    `id` int  NOT NULL ,
    `nome` str  NOT NULL ,
    `CPF` int  NOT NULL ,
    `endereco` str  NOT NULL ,
    `idRelacao` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `relacao` (
    `id` int  NOT NULL ,
    `idProprietario` int  NOT NULL ,
    `idComprador` int  NOT NULL ,
    `idFDP` int  NOT NULL 
);

ALTER TABLE `casa` ADD CONSTRAINT `fk_casa_id` FOREIGN KEY(`id`)
REFERENCES `imoveis` (`id`);

ALTER TABLE `casa` ADD CONSTRAINT `fk_casa_endid` FOREIGN KEY(`endid`)
REFERENCES `enderecos` (`id`);

ALTER TABLE `casa` ADD CONSTRAINT `fk_casa_properid` FOREIGN KEY(`properid`)
REFERENCES `cliente` (`id`);

ALTER TABLE `casa` ADD CONSTRAINT `fk_casa_imagensid` FOREIGN KEY(`imagensid`)
REFERENCES `imagens` (`id`);

ALTER TABLE `apertamento` ADD CONSTRAINT `fk_apertamento_id` FOREIGN KEY(`id`)
REFERENCES `imoveis` (`id`);

ALTER TABLE `apertamento` ADD CONSTRAINT `fk_apertamento_endid` FOREIGN KEY(`endid`)
REFERENCES `enderecos` (`id`);

ALTER TABLE `apertamento` ADD CONSTRAINT `fk_apertamento_properid` FOREIGN KEY(`properid`)
REFERENCES `cliente` (`id`);

ALTER TABLE `apertamento` ADD CONSTRAINT `fk_apertamento_imagensid` FOREIGN KEY(`imagensid`)
REFERENCES `imagens` (`id`);

ALTER TABLE `terreno` ADD CONSTRAINT `fk_terreno_id` FOREIGN KEY(`id`)
REFERENCES `imoveis` (`id`);

ALTER TABLE `terreno` ADD CONSTRAINT `fk_terreno_endid` FOREIGN KEY(`endid`)
REFERENCES `enderecos` (`id`);

ALTER TABLE `terreno` ADD CONSTRAINT `fk_terreno_properid` FOREIGN KEY(`properid`)
REFERENCES `cliente` (`id`);

ALTER TABLE `terreno` ADD CONSTRAINT `fk_terreno_imagensid` FOREIGN KEY(`imagensid`)
REFERENCES `imagens` (`id`);

ALTER TABLE `salaComercial` ADD CONSTRAINT `fk_salaComercial_endid` FOREIGN KEY(`endid`)
REFERENCES `enderecos` (`id`);

ALTER TABLE `salaComercial` ADD CONSTRAINT `fk_salaComercial_properid` FOREIGN KEY(`properid`)
REFERENCES `cliente` (`id`);

ALTER TABLE `salaComercial` ADD CONSTRAINT `fk_salaComercial_imagensid` FOREIGN KEY(`imagensid`)
REFERENCES `imagens` (`id`);

ALTER TABLE `relacao` ADD CONSTRAINT `fk_relacao_id` FOREIGN KEY(`id`)
REFERENCES `cliente` (`idRelacao`);

