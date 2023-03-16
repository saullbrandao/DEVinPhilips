CREATE TABLE PROFESSORES(
    ID NUMBER GENERATED BY DEFAULT AS IDENTITY,
    NOME VARCHAR2(64) NOT NULL,
    SOBRENOME VARCHAR2(64) NOT NULL,
    ENDERECO VARCHAR2(512) NOT NULL,
    TELEFONE VARCHAR2(11) NOT NULL,
    EMAIL VARCHAR2(128) NOT NULL,
    DATA_NASCIMENTO DATE NOT NULL,
    NACIONALIDADE VARCHAR2(32) NOT NULL
);

CREATE TABLE ESTUDANTES(
    ID NUMBER GENERATED BY DEFAULT AS IDENTITY,
    NOME VARCHAR2(64) NOT NULL,
    SOBRENOME VARCHAR2(64) NOT NULL,
    MATRICULA VARCHAR2(64) NOT NULL,
    EMAIL VARCHAR2(128) NOT NULL,
    DATA_NASCIMENTO DATE NOT NULL,
    NACIONALIDADE VARCHAR2(32) NOT NULL,
    MEDIA_GERAL NUMBER NOT NULL
);

CREATE TABLE CURSOS(
    ID NUMBER GENERATED BY DEFAULT AS IDENTITY,
    CODIGO VARCHAR2(64) NOT NULL,
    NOME VARCHAR2(64) NOT NULL,
    PROFESSOR_ID NUMBER NOT NULL,
    MAX_ALUNOS NUMBER NOT NULL,
    EAD CHAR(1) DEFAULT '0'
);