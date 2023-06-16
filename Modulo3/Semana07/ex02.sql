DECLARE
  CURSOR cursor_produtos IS
    SELECT p.ID, p.Status, pp.Valor
    FROM Produto p
    INNER JOIN PrecoProduto pp ON p.ID = pp.IDProduto;
  
  v_id NUMBER;
  v_status NUMBER;
  v_valor NUMBER(10, 2);
BEGIN
  OPEN cursor_produtos;
  LOOP
    FETCH cursor_produtos INTO v_id, v_status, v_valor;
    EXIT WHEN cursor_produtos%NOTFOUND;
    
    IF v_status = 1 AND v_valor < 1000.00 THEN
      DBMS_OUTPUT.PUT_LINE('ID: ' || v_id || ', Status: ativo, Preço: ' || v_valor || ' (Status ativo e preço menor que 1000,00)');
    ELSIF v_status = 1 THEN
      DBMS_OUTPUT.PUT_LINE('ID: ' || v_id || ', Status: ativo, Preço: ' || v_valor);
    ELSE
      DBMS_OUTPUT.PUT_LINE('ID: ' || v_id || ', Status: desativado, Preço: ' || v_valor);
    END IF;
  END LOOP;
  CLOSE cursor_produtos;
END;