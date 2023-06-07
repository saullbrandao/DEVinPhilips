-- Criação da tabela Produto
CREATE TABLE Produto (
  ID NUMBER PRIMARY KEY,
  Descricao VARCHAR2(50) NOT NULL,
  Status NUMBER(1) NOT NULL,
  Cadastro DATE NOT NULL,
  QuantidadeEmEstoque NUMBER NOT NULL
);

-- Inserção dos dados de 10 registros
INSERT INTO Produto (ID, Descricao, Status, Cadastro, QuantidadeEmEstoque)
VALUES (1, 'Produto 1', 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);

INSERT INTO Produto (ID, Descricao, Status, Cadastro, QuantidadeEmEstoque)
VALUES (2, 'Produto 2', 0, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 10);

INSERT INTO Produto (ID, Descricao, Status, Cadastro, QuantidadeEmEstoque)
VALUES (3, 'Produto 3', 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 12);

INSERT INTO Produto (ID, Descricao, Status, Cadastro, QuantidadeEmEstoque)
VALUES (4, 'Produto 4', 0, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);

INSERT INTO Produto (ID, Descricao, Status, Cadastro, QuantidadeEmEstoque)
VALUES (5, 'Produto 5', 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);

INSERT INTO Produto (ID, Descricao, Status, Cadastro, QuantidadeEmEstoque)
VALUES (6, 'Produto 6', 0, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 5);

INSERT INTO Produto (ID, Descricao, Status, Cadastro, QuantidadeEmEstoque)
VALUES (7, 'Produto 7', 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 2);

INSERT INTO Produto (ID, Descricao, Status, Cadastro, QuantidadeEmEstoque)
VALUES (8, 'Produto 8', 0, TO_DATE('2023-06-07 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), 15);

INSERT INTO Produto (ID, Descricao, Status, Cadastro, QuantidadeEmEstoque)
VALUES (9, 'Produto 9', 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);

INSERT INTO Produto (ID, Descricao, Status, Cadastro, QuantidadeEmEstoque)
VALUES (10, 'Produto 10', 0, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 9);