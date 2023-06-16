CREATE OR REPLACE PROCEDURE ListarProdutoPrecoPorIdProduto(p_id IN NUMBER, p_valor_somado OUT NUMBER)
IS
  v_total NUMBER := 0;
  v_produto_nao_encontrado EXCEPTION;
  PRAGMA EXCEPTION_INIT(v_produto_nao_encontrado, -20005);
  CURSOR c_preco_produto IS
    SELECT pp.Valor
    FROM Produto p
    INNER JOIN precoproduto pp ON p.ID = pp.IDProduto
    WHERE p.ID = p_id;
BEGIN
  OPEN c_preco_produto;
    p_valor_somado := 0;
  
  LOOP
    FETCH c_preco_produto INTO v_total;

    EXIT WHEN c_preco_produto%NOTFOUND;
    p_valor_somado := p_valor_somado + v_total;
  END LOOP;
  
  CLOSE c_preco_produto;
  
  IF p_valor_somado IS NULL THEN
    RAISE v_produto_nao_encontrado;
  END IF;
EXCEPTION
  WHEN v_produto_nao_encontrado THEN
    DBMS_OUTPUT.PUT_LINE('Erro (20005): Produto não encontrado.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Erro ao obter a soma dos produtos.');
END;