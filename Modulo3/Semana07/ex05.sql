CREATE OR REPLACE PROCEDURE AtualizarProdutoPreco(p_id NUMBER, p_valor_novo NUMBER)
IS
  v_status NUMBER(1);
  v_produto_nao_existe EXCEPTION;
  v_produto_desativado EXCEPTION;
  PRAGMA EXCEPTION_INIT(v_produto_nao_existe, -20001);
  PRAGMA EXCEPTION_INIT(v_produto_desativado, -20002);
BEGIN
  SELECT Status INTO v_status
  FROM Produto
  WHERE ID = p_id;
  
  IF v_status IS NULL THEN
    RAISE v_produto_nao_existe;
  END IF;
  
  IF v_status = 0 THEN
    RAISE v_produto_desativado;
  END IF;
  
  UPDATE PRECOPRODUTO
  SET Valor = p_valor_novo
  WHERE IDProduto = p_id;
  
  DBMS_OUTPUT.PUT_LINE('Preço do produto atualizado com sucesso.');
EXCEPTION
  WHEN v_produto_nao_existe THEN
    DBMS_OUTPUT.PUT_LINE('Erro (20001): Produto não existe.');
  WHEN v_produto_desativado THEN
    DBMS_OUTPUT.PUT_LINE('Erro (20002): Produto está desativado na tabela.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Erro ao atualizar o preço do produto.');
END;