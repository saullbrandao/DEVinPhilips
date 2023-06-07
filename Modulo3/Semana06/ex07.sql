DECLARE
	status_produto VARCHAR2(10);
BEGIN
    FOR i IN (SELECT ID, STATUS FROM PRODUTO) LOOP
	    IF i.STATUS = 0 THEN
	    	status_produto := 'ativo';
	    ELSE
	    	status_produto := 'desativado';
	    END IF;
        DBMS_OUTPUT.PUT_LINE(i.ID || ': ' || status_produto);     
    END LOOP;
END;