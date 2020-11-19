create table pessoa (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    dataCadastrato DATE,
    
    PRIMARY KEY(id)    
) ENGINE=INNODB;

create table endereco (
	idEndereco 	INT NOT NULL AUTO_INCREMENT,
    rua 		VARCHAR(255) NOT NULL,
    cidade 		VARCHAR(255) NOT NULL,
    estado 		VARCHAR(255) NOT NULL,
    pais		VARCHAR(255) NOT NULL,
    idPessoa 	INT NOT NULL,
    
    PRIMARY KEY(idEndereco) ,
    FOREIGN KEY (idPessoa) REFERENCES pessoa(id)
) ENGINE=INNODB;

create table contato (
	idContato INT NOT NULL AUTO_INCREMENT,
    telefone INT,
    email VARCHAR(255),
    idPessoa INT NOT NULL,
    
    PRIMARY KEY(idContato),
    FOREIGN KEY (idPessoa) REFERENCES pessoa(id)
) ENGINE=InnoDB;