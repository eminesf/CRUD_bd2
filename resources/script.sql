create table contato (
	id int NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    idade int NOT NULL,
    dataCadastrato date,
    
    PRIMARY KEY(id)    
) ENGINE=INNODB;