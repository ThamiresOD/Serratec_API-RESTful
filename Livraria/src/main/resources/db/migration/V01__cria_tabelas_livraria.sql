
CREATE TABLE Categoria (
	id_categoria serial PRIMARY KEY,
	nome varchar(30) NOT NULL,
	descricao varchar(200)
);


CREATE TABLE livro (
	id_livro serial PRIMARY KEY,
	titulo varchar(40) NOT NULL,
	isbn varchar(20) NOT NULL UNIQUE,
	data_publicacao date,
	id_categoria bigint REFERENCES categoria(id_categoria)
);


CREATE TABLE associado (
	id_associado serial PRIMARY KEY,
	nome varchar(50) NOT NULL,
	telefone varchar(15) NOT NULL,
	cpf varchar(11) NOT NULL,
	logradouro varchar(80) NOT NULL,
	numero varchar(10) NOT NULL,
	complemento varchar(30) NOT NULL,
	bairro varchar(50) NOT NULL,
	cidade varchar(50) NOT NULL,
	estado varchar(2) NOT NULL
);


CREATE TABLE autor (
	id_autor serial PRIMARY KEY,
	nome varchar(50) NOT NULL
);

 
CREATE TABLE livro_autor (
	id_livro int REFERENCES livro(id_livro),
	id_autor int REFERENCES autor(id_autor),
	PRIMARY KEY (id_livro, id_autor)
);

	
CREATE TABLE emprestimo (
	id_emprestimo serial PRIMARY KEY,
	dataEmprestimo date NOT NULL,
	id_associado int REFERENCES associado(id_associado)
);


CREATE TABLE emprestimo_Livro (
	id_emprestimo_livro serial PRIMARY KEY,
	obs_ato_emprestimo varchar(200),
	id_livro int REFERENCES livro(id_livro),
	id_emprestimo int REFERENCES emprestimo(id_emprestimo)
);


