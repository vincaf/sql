drop table if exists pagamenti;

drop table if exists fatture;

drop table if exists ordini;

drop table if exists clienti;


CREATE TABLE clienti
   (
    ID_CLIENTE int auto_increment,
	NOME VARCHAR(50),
	COGNOME VARCHAR(50),
	EMAIL VARCHAR(50),
	INDIRIZZO VARCHAR(100),
	CITTA VARCHAR(50),
	PROVINCIA VARCHAR(2),
	CAP varchar(5),
	primary key(id_cliente)
   );


CREATE TABLE ordini -- generare da 10 a 20 ordini per cliente
   (
    ID_ORDINE int auto_increment, -- null in java java.lang.Integer
	DATA DATETIME, --  '2022-MM-GG 00:00:00' MM random compreso tra 1 e 12, GG random compreso tra 5 e 25 in java tipo String
	VALORE decimal(10,2),  -- random compreso tra 10000 e 20000 in java BigDecimal
    ID_CLIENTE int, -- da cliente in esame
	primary key(id_ordine)
   );



CREATE TABLE fatture
   (
    ID_FATTURA int auto_increment, -- progressivo
	DATA DATETIME, -- da ordini ma ....
	IMPORTO decimal(10,2), -- da ordine
	IMPONIBILE decimal(10,2), -- ....
	IVA decimal(10,2), -- calcolo sulla base 22% (importo-imponibile)
	ID_ORDINE int, -- da tabella ordini
	primary key(id_fattura)
   );

   -- se id cliente è pari ==> 2 fatture a 30, 60 gg --> 50% importo
   -- se id cliente multiplo di 3 ==> 3 fatture a 30, 60, 90 gg --> 33% + arrotondamento dell'importo
   -- in ogni altro caso ==> 1 fattura a 30 gg. per ogni ordine



CREATE TABLE pagamenti
   (
    ID_PAGAMENTO int auto_increment,
	DATA DATETIME,
	IMPORTO decimal(10,2),
	IMPONIBILE decimal(10,2),
	IVA decimal(10,2),
	ID_FATTURA int,
	primary key(id_pagamento)
   );

alter table ordini add constraint fk_ordini_clienti
foreign key(ID_CLIENTE) references clienti(ID_CLIENTE);

alter table fatture add constraint fk_fatture_ordini
foreign key(ID_ORDINE) references ordini(ID_ORDINE);

alter table pagamenti add constraint fk_pagamenti_fatture
foreign key(ID_FATTURA) references fatture(ID_FATTURA);

insert into clienti (NOME,COGNOME,EMAIL,INDIRIZZO,CITTA,PROVINCIA,CAP) values
('Giuseppe','Verdi','gverdi@aol.com','Roncole Verdi','Busseto','PR','43011'),
('Gioacchino','Rossini','gioacchino@libero.it','Via del Duomo','Pesaro','PU','61122'),
('Giacomo','Puccini','gpuccini@gmail.com','Corte San Lorenzo, 9 ','Lucca','LU','55100'),
('Gaetano','Donizetti','gaetano@walla.com','Via Don Luigi Palazzolo, 88','Bergamo','BG','24122'),
('Vincenzo','Bellini','bellini@bellini.org','Piazza San Francesco d’Assisi, 3','Catania','CT','95100'),
('Antonio','Vivaldi','antonio.vivaldi@vivaldi.com','Rion del boh, 33','Venezia','VE','30100'),
('Domenico','Scarlatti','dscarlatti@mail.partenope.it','Rion del boh, 33','Napoli','NA','80100'),
('Claudio','Monteverdi','34566@libero.it','Piazza del Duomo, 1','Cremona','CR','26100'),
('Amilcare','Ponchielli','aponchielli@aol.com','Piazza Revellino, 3','Paderno Ponchielli','CR','26024'),
('Arcangelo','Corelli','acor@spalfans.it','Piazza Roma, 18','Fusignano','RA','48032'),
('Tommaso','Albinoni','albinoni@gmail.com','Via Roma','Castione della Presolana','BG','24020'),
('Giovanni Battista','Pergolesi','gbattista.draghi@jesimusiva.org','Piazza Ghislieri, 4','Jesi','AN','60035'),
('Vincenzo','Capecelatro','vin.cap@libero.it','Via Po, 22','Napoli','NA','80100'),
('Francesco','Cilea','fcilea@cilea.it','Via Cilea, 1','Palmi','RC','89015'),
('Arrigo','Boito','arrigob@aol.com','Via Cavour, 17','Padova','PD','35100'),
('Luigi','Cherubini','lcherubini@gmail.com','Via Ricasoli, 10','Firenze','FI','50100'),
('Giovanni Pierluigi','Da Palestrina','gpp@gmail.com','Via Cenreo, 2','Palestrina','RM','00036'),
('Tarquinia','Molza','tarquinia@libero.it','Via Parma, 72','Modena','MO','41121'),
('Andres','Segovia Torres','andres.s@segovia.es','Villacarrillo, 133','Linares','JA','23700'),
('Rossi','Arturo', 'rossi-a@libero.it','Via delle Pisane, 78', 'Pavia', 'PV', '27100'),
('Bianchi','Federico', 'fb89@gmail.com', 'Piazza Giovanni XXIII, 63', 'Pavia', 'PV', '27100'),
('Alma','Mater', 'alma@mail.com', 'Via Mazzini, 2', 'Genova', 'GE', '16125'),
('Ludovia','Bentivoglio', 'bentivoglio@gmx.com','Viale dei Tigli, 55', 'Pisa', 'PI', '56010'),
('Rossi','Andrea', 'andrea.rossi@walla.com', 'Riviera Paleocapa, 74', 'Padova', 'PD', '35143'),
('Pezzini','Luigi', 'l.pezzini92@poste.it','Via Fratelli Bronzetti, 17', 'Milano', 'MI', '20129'),
('Pala','Giovanni', 'gpala@gmx.com','Via Lorenteggio, 58', 'Milano', 'MI', '20100'),
('Diego','Spelta', 'dspelta@tutanota.com','Corso Sempione, 79', 'Roma', 'RM', '00198'),
('Fafner','Pelutti', 'fafner.ildrago@aol.com','Via Peluttini, 56', 'Vigevano', 'PV', '27029'),
('Chloe','Cagnetti', 'Chloe@lasoffiata.it', 'Corso Roma, 54', 'Lodi', 'LO', '26900')
;

