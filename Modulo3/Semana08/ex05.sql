CREATE OR REPLACE TRIGGER afterUpdateProduto
AFTER UPDATE ON PRODUTO
FOR EACH ROW
DECLARE
    v_campo_alterado VARCHAR2(100);
    v_valor_antigo VARCHAR2(100);
BEGIN
    IF UPDATING('descricao') THEN
        v_campo_alterado := 'descricao';
        v_valor_antigo := :OLD.descricao;
    ELSIF UPDATING('status') THEN
        v_campo_alterado := 'status';
        v_valor_antigo := :OLD.status;
    ELSIF UPDATING('quantidadeemestoque') THEN
        v_campo_alterado := 'quantidadeemestoque';
        v_valor_antigo := :OLD.quantidadeemestoque;

    END IF;

    IF v_campo_alterado IS NOT NULL THEN
        INSERT INTO LOG (ID, Campo, ValorAntigo, NomeTabela)
        VALUES (:OLD.ID, v_campo_alterado, v_valor_antigo, 'Produto');
    END IF;
END;