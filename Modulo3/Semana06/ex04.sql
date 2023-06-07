SELECT
  p.ID,
  CASE
    WHEN total_soma < 150.00 THEN 'Soma do produto menor que 150.00'
    WHEN total_soma < 500.00 THEN 'Soma do produto está entre 150 e 500'
    ELSE 'Soma dos produtos está acima de 500,00'
  END CASE
FROM
  Produto p
  INNER JOIN (
    SELECT IDProduto, SUM(Valor) AS total_soma
    FROM PrecoProduto
    GROUP BY IDProduto
  ) pp ON p.ID = pp.IDProduto;