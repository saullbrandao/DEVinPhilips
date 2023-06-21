create or replace FUNCTION CalcularDescontoProduto(
    codigo IN NUMBER,
    aplicar_desconto IN NUMBER
) RETURN NUMBER
IS
    valor_produto NUMBER;
    desconto NUMBER := 0;
BEGIN
    SELECT valor INTO valor_produto
    FROM precoproduto
    WHERE idproduto = codigo;

    IF aplicar_desconto = 1 THEN
        desconto := valor_produto * 0.1; -- 10% de desconto
    END IF;

    RETURN valor_produto - desconto;
END;

--SELECT CalcularDescontoProduto(1,1) AS CalculoDesconto FROM DUAL;