SELECT 100 + 50;

show databases;

show tables;

-- (meno, meno, spazio) commento SQL di linea (equivalente di java //)

/* commento
 *  
 * SQL 
 * 
 * di blocco 
 */

-- eliminare la tabella "prova"
drop table if exists prova;

/*
 * creazione della tabella prova 
 * 
 * create creo un oggetto sul database
 * 
 * una tabella in un RDBMS è un insieme di colonne (i metadati: campi e tipi dei campi)
 */
create table if not exists prova(
	codice int,
	descrizione varchar(200),
	descrizione_allungata text
);

-- corso.prova definition
/*
 * Il backtick dice all'interprete SQL di intendere il nome così come è scritto
 * distinguendo tra maiuscole e minuscole
 */
CREATE TABLE if not exists `prova` (
  `codice` int(11) DEFAULT NULL,
  `descrizione` varchar(200) DEFAULT NULL,
  `descrizione_allungata` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*
 * CREATE, DROP appartengono al DDL (data Definition Language)
 */

describe prova; -- mysql dialect

/*
 * INSERT, DELETE, UPDATE appartengono al DML (data Manipulation Language)
 */

/*
 * una volta creata la tabella, bisogna alimentarla inserendo dati
 */
insert into prova (descrizione_allungata, codice, descrizione) values ('questa è la descrizione allungata del prodotto 1', 1, 'prodotto 1');
insert into prova (descrizione_allungata, codice, descrizione) values ('questa è la descrizione allungata del prodotto 2', 2, 'prodotto 2');
insert into prova (descrizione_allungata, codice, descrizione) values ('questa è la descrizione allungata del prodotto 3', 3, 'prodotto 3');

-- fast INSERT
insert into prova (descrizione_allungata, codice, descrizione) values
('questa è la descrizione allungata del prodotto 4', 4, 'prodotto 4'),
('questa è la descrizione allungata del prodotto 5', 5, 'prodotto 5'),
('questa è la descrizione allungata del prodotto 6', 6, 'prodotto 6'),
('questa è la descrizione allungata del prodotto 7', 7, 'prodotto 7');

-- INSERT senza nomi colonne
insert into prova values(8, 'prodotto 8', 'questa è la descrizione allungata del prodotto 8'); -- in questo caso l'ordine delle colonne deve essere l'ordine di definizione

-- delete from prova; /* delete non qualificata, elimina tutte le tuple(righe) dalla tabella */

delete from prova where codice = 5;

update prova set descrizione_allungata = "Descriz. Prd. 6" where codice = 6; -- aggiornamento di una riga

update prova set descrizione = "prod. 7", codice = 77 where codice = 7; -- aggiornamento di una riga su più campi


-- SELECT, proiezione e selezione
SELECT  COUNT(*) from prova; 

SELECT COUNT(*) as 'Numero righe in prova' from prova;

SELECT codice, descrizione, descrizione_allungata from prova;

SELECT codice, descrizione, descrizione_allungata -- proiezione
FROM prova
WHERE codice = 3 OR codice = 4; -- selezione

-- selezione con sintassi più veloce e corretta
SELECT codice, descrizione 
FROM prova
WHERE codice in(3, 4);

-- selezione con range di elementi
SELECT codice, descrizione 
FROM prova
WHERE codice BETWEEN 3 AND 8;

-- con ordinamento delle righe
SELECT codice, descrizione 
FROM prova
WHERE codice BETWEEN 3 AND 8
ORDER BY codice; 

-- si può utilizzare sia il nome che il numero della colonna (es: ORDER BY 1, dove 1 è sempre codice)
SELECT codice, descrizione 
FROM prova
WHERE codice BETWEEN 3 AND 8
ORDER BY 1; 
