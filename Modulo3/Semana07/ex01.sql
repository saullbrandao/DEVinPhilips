DECLARE
  CURSOR cursor_produtos IS
    SELECT ID
    FROM Produto
    WHERE ROWNUM <= 3;
  
  v_id NUMBER;
BEGIN
  OPEN cursor_produtos;
  LOOP
    FETCH cursor_produtos INTO v_id;
    EXIT WHEN cursor_produtos%NOTFOUND;
    
    UPDATE Produto
    SET Status = 0
    WHERE ID = v_id;
    
    DBMS_OUTPUT.PUT_LINE('Registro atualizado: ' || v_id);
  END LOOP;
  CLOSE cursor_produtos;
END;