/*
 * Esercizio
 * - creare la tabella "studenti"
 * - campi matricola (numerico), nome, cognome, età, corso di laurea
 * - inserire 10 righe
 * - cancellare una riga
 * - aggiornare 2 righe
 */

DROP table if exists studenti;

CREATE table if not exists studenti(
	matricola int,
	nome varchar(50),
	cognome varchar(50),
	età int,
	corso_di_laurea varchar(200)
);

insert into studenti (matricola, nome, cognome, età, corso_di_laurea) values
(001, 'Giuseppe', 'Verdi', 20, 'psicologia'),
(002, 'Mario', 'Rossi', 24, 'giurisprudenza'),
(003, 'Antonio', 'Bianchi', 21, 'lettere moderne'),
(004, 'Domenico', 'Verdi', 20, 'lettere classiche'),
(005, 'Salvatore', 'Esposito', 22, 'ingegneria informatica'),
(006, 'Mario', 'Bros', 22, 'ingegneria edile'),
(007, 'Maria', 'Di Maria', 24, 'architettura'),
(008, 'Vittoria', 'Di Giacomo', 22, 'scienze della comunicazione'),
(009, 'Melissa', 'Satta', 26, 'ingegneria aerospaziale'),
(010, 'Claudio', 'Diocleziano', 23, 'filosofia');

delete from studenti where matricola = 006;

update studenti set corso_di_laurea = "lettere moderne" where matricola = 010;
update studenti set cognome = "Verde" where matricola = 004;

-- creare una select per conoscere quante sono le righe contenute nella tabella
SELECT COUNT(*) as 'Numero righe in studenti' from studenti;

-- creare una select per elencare gli studenti di età compresa tra i 24 e 27 anni
SELECT matricola, nome, cognome, età, corso_di_laurea
FROM studenti
WHERE età BETWEEN 24 AND 27;