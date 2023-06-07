SELECT p.ID, 
	   pp.ID AS "ID_PRECO_PRODUTO",
	   p.DESCRICAO,
	   pp.VALOR, 
	   TO_CHAR(pp.Cadastro, 'MM/YYYY') AS CADASTRO
FROM PRODUTO p 
INNER JOIN PRECOPRODUTO pp 
ON p.ID = pp.ID;