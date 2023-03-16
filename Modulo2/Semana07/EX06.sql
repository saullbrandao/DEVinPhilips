SELECT * FROM cursos WHERE max_alunos > 30 AND ead = '0';

SELECT * FROM estudantes WHERE LOWER(nome) LIKE 'j%';

SELECT * FROM estudantes WHERE media_geral > 7 ORDER BY media_geral DESC;

SELECT c.*
FROM cursos c
JOIN professores p ON c.professor_id = p.id
WHERE p.genero = 'feminino';

SELECT e.* 
FROM estudantes e
JOIN matricula m ON e.id = m.aluno_id
JOIN cursos c ON m.curso_id = c.id
WHERE c.ead = '1';
