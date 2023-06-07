BEGIN
	FOR i IN 1..3 LOOP
    	UPDATE PrecoProduto
    	SET Valor = Valor + (Valor * 0.15)
    	WHERE Valor > 100;
  	END LOOP;
END;  