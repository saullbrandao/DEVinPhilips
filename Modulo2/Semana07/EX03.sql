ALTER TABLE CURSOS ADD PRIMARY KEY(ID)
ALTER TABLE ESTUDANTES ADD PRIMARY KEY(ID)
ALTER TABLE PROFESSORES ADD PRIMARY KEY(ID)
ALTER TABLE MATRICULA ADD PRIMARY KEY(ID)

ALTER TABLE CURSOS ADD FOREIGN KEY(PROFESSOR_ID) REFERENCES PROFESSORES(ID)
ALTER TABLE MATRICULA ADD FOREIGN KEY(ALUNO_ID) REFERENCES ESTUDANTES(ID)
ALTER TABLE MATRICULA ADD FOREIGN KEY(CURSO_ID) REFERENCES CURSOS(ID);
