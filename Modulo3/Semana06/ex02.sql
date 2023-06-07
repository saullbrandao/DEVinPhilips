-- Criação da tabela PrecoProduto
CREATE TABLE PrecoProduto (
  ID NUMBER PRIMARY KEY,
  IDProduto NUMBER,
  Valor NUMBER(10, 2) NOT NULL,
  Status NUMBER(1) NOT NULL,
  Cadastro DATE NOT NULL,
  CONSTRAINT fk_produto FOREIGN KEY (IDProduto) REFERENCES Produto (ID)
);

-- Inserção dos dados de 15 registros
INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (1, 1, 10.00, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (2, 2, 6.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (3, 3, 1.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (4, 4, 2.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (5, 5, 3.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (6, 6, 4.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (7, 7, 5.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (8, 8, 6.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (9, 9, 7.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (10, 10, 8.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (11, 1, 5.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (12, 2, 5.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (13, 3, 5.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (14, 4, 5.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO PrecoProduto (ID, IDProduto, Valor, Status, Cadastro)
VALUES (15, 5, 5.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));