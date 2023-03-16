UPDATE estudantes SET media_geral = 9 WHERE ID = 1;

UPDATE cursos 
SET ead = '1'
WHERE professor_id NOT IN (
    SELECT id
    FROM professores
    WHERE LOWER(endereco) LIKE '%santa catarina%'
);

DELETE FROM cursos
WHERE ID = 4;