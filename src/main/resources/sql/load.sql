INSERT INTO CLIENTES (NOME, NOME_INSS, SEXO, ENDERECO) VALUES('JOÃO DA SILVA', 'JOAO', 'MASCULINO', 'Rua dos imigrantes, Centro, Nova Veneza');
INSERT INTO TELEFONES (I_CLIENTES, DDD, NUMERO) VALUES(1, '48', '9988-7766');
INSERT INTO TELEFONES (I_CLIENTES, DDD, NUMERO) VALUES(1, '48', '3433-1122');

INSERT INTO CLIENTES (NOME, NOME_INSS, SEXO, ENDERECO) VALUES('MARIA DE SOUZA', 'MARIA', 'FEMININO', 'Av. Centenário, Pinheirinho, Criciúma');
INSERT INTO TELEFONES (I_CLIENTES, DDD, NUMERO) VALUES(2, '48', '9876-5432');

INSERT INTO CLIENTES (NOME, NOME_INSS, SEXO, ENDERECO) VALUES('CHAPOLIN COLORADO', 'CHAPOLIN', 'MASCULINO', 'Praia de Acapulco, México');

INSERT INTO PROCESSOS (I_CLIENTES, NUMERO_BENEFICIO, OBSERVACAO) VALUES(1, '123456', null);
INSERT INTO TRAMITES (I_PROCESSOS, DT_TRAMITE, SITUACAO, OBSERVACOES) VALUES(1, '2015-01-01', 'INICIADO', 'Início do processo');
INSERT INTO TRAMITES (I_PROCESSOS, DT_TRAMITE, SITUACAO, OBSERVACOES) VALUES(1, '2016-01-01', 'EM ANÁLISE', 'Processo sendo analisado por...');
INSERT INTO TRAMITES (I_PROCESSOS, DT_TRAMITE, SITUACAO, OBSERVACOES) VALUES(1, '2016-01-06', 'DESPACHADO', 'Processo despachado...');

INSERT INTO PROCESSOS (I_CLIENTES, NUMERO_BENEFICIO, OBSERVACAO) VALUES(2, '456123', null);
INSERT INTO TRAMITES (I_PROCESSOS, DT_TRAMITE, SITUACAO, OBSERVACOES) VALUES(2, '2016-03-01', 'INICIADO', 'Início do processo');
INSERT INTO TRAMITES (I_PROCESSOS, DT_TRAMITE, SITUACAO, OBSERVACOES) VALUES(2, '2016-03-11', 'NEGADO', 'Processo negado devido...');

INSERT INTO PROCESSOS (I_CLIENTES, NUMERO_BENEFICIO, OBSERVACAO) VALUES(3, '121212', 'DOCUMENTOS JA ENTREGUES');
INSERT INTO TRAMITES (I_PROCESSOS, DT_TRAMITE, SITUACAO, OBSERVACOES) VALUES(3, '2016-02-15', 'INICIADO', 'Início do processo');


