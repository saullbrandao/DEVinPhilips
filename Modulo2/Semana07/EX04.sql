INSERT INTO estudantes (nome, sobrenome, matricula, email, data_nascimento, nacionalidade, media_geral) 
VALUES ('Jorge', 'Silva', 'abc123', 'jorgesilva@test.com', '04/MAR/1997', 'brasileiro', 0);

INSERT INTO estudantes (nome, sobrenome, matricula, email, data_nascimento, nacionalidade, media_geral) 
VALUES ('Maria', 'Lopes', 'abc456', 'maria@test.com', '01/APR/1995', 'brasileiro', 0);

INSERT INTO estudantes (nome, sobrenome, matricula, email, data_nascimento, nacionalidade, media_geral) 
VALUES ('Rosa', 'Moreira', 'abc789', 'rosa@test.com', '14/DEC/1996', 'brasileiro', 0);


INSERT INTO professores (nome, sobrenome, endereco, email, telefone, data_nascimento, nacionalidade) 
VALUES ('Mario', 'Ribeiro', 'Quadra SQS 305 Bloco B, 579', 'mario@test.com', '11988887777', '28/JAN/1980', 'brasileiro');

INSERT INTO professores (nome, sobrenome, endereco, email, telefone, data_nascimento, nacionalidade) 
VALUES ('Joao', 'Barbosa', 'Rua Doutor Fernandes Lima, 714', 'joaobarbosa@test.com', '11955557777', '13/MAY/1975', 'brasileiro');

INSERT INTO professores (nome, sobrenome, endereco, email, telefone, data_nascimento, nacionalidade) 
VALUES ('Elisa', 'Duarte', 'Rua do Comércio, 123', 'elisa@test.com', '11966664444', '02/AUG/1986', 'brasileiro');

INSERT INTO cursos (codigo, nome, professor_id, max_alunos, ead) 
VALUES ('123abc', 'Java', 1, 50, '0');

INSERT INTO cursos (codigo, nome, professor_id, max_alunos, ead) 
VALUES ('456abc', 'Angular', 2, 50, '0');

INSERT INTO cursos (codigo, nome, professor_id, max_alunos, ead) 
VALUES ('789abc', 'SQL', 3, 50, '0');

INSERT INTO cursos (codigo, nome, professor_id, max_alunos, ead) 
VALUES ('789abc', 'Spring', 3, 50, '0');

INSERT INTO matricula(aluno_id, curso_id, media_aluno)
VALUES(1,1,9);

INSERT INTO matricula(aluno_id, curso_id, media_aluno)
VALUES(2,2,8);

INSERT INTO matricula(aluno_id, curso_id, media_aluno)
VALUES(3,3,8);