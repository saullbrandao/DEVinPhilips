create or replace PROCEDURE ExibirTodosProdutos IS
  CURSOR cursor_produtos IS
    SELECT * FROM Produto;

  v_id NUMBER;
  v_descricao VARCHAR2(50);
  v_status NUMBER(1);
  v_cadastro DATE;
  v_quantidade NUMBER;
BEGIN
  OPEN cursor_produtos;
  LOOP
    FETCH cursor_produtos INTO v_id, v_descricao, v_status, v_cadastro, v_quantidade;
    EXIT WHEN cursor_produtos%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE('ID: ' || v_id || ', Descrição: ' || v_descricao ||
                         ', Status: ' || v_status || ', Cadastro: ' || v_cadastro ||
                         ', Quantidade em Estoque: ' || v_quantidade);
  END LOOP;
  CLOSE cursor_produtos;
END;