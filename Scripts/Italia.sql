-- fornire il conteggio delle regioni
SELECT COUNT(id) -- count(*) tutte le righe
as "numero regioni"
from regioni;

-- fornire il conteggio delle province
SELECT COUNT(id)
as "numero province"
from province;

-- fornire il conteggio dei comuni
SELECT COUNT(id)
as "numero comuni"
from comuni;

-- fornire i dati precedenti in una stessa tabella
-- union, unione di tipo insiemistico (no duplicati)
-- per quanto riguarda gli aliases (ridenominazioni) conta solo la prima query
-- perché la union sia possibile è necessario che tutte le query nella union abbiano il medesimo numero di colonne
-- conteggio diviso per righe
SELECT COUNT(id) as conteggio, "numero regioni" as oggetto
from regioni
union
SELECT COUNT(id), "numero province"
from province
union
SELECT COUNT(id), "numero comuni"
from comuni;

-- conteggio diviso per colonne
SELECT 
(SELECT COUNT(id) from regioni) "Regioni", 
(SELECT COUNT(id) from province) "Province", 
(SELECT COUNT(id) from comuni) "Comuni" 
from dual;

-- selezione solo Province dall'unione precedente delle tabelle
SELECT Province from(
	select
	(SELECT COUNT(id) from regioni) "Regioni", 
	(SELECT COUNT(id) from province) "Province", 
	(SELECT COUNT(id) from comuni) "Comuni" 
	from dual
) xxx;

-- esempio di dual, quando serve una singola riga di risultato
create table xcalcoli (x int);
INSERT into xcalcoli values(null);
select 34.76 * 99.63 as result from xcalcoli;

-- elencare tutte le province 
select nome from province;

-- elencare tutte le province della puglia e della lombardia
select id_regione, nome, sigla_automobilistica 
from province 
where id_regione in(16, 3)
order by id_regione;

-- (16, 3) assomiglia ad un array
-- in termini di tabelle a cosa assomiglia un array?
-- in termini di database relazionale corrisponderebbe
-- ad una tabella con 1 colonna ed n righe
SELECT id 
from regioni 
WHERE nome = "Lombardia" OR nome = "Puglia";

-- condizione where utilizzando in()
SELECT id from regioni WHERE nome in("Lombardia", "Puglia");

-- esempio di inner select utilizzando la selezione precedente
select id_regione, nome, sigla_automobilistica 
from province 
where id_regione in( SELECT id from regioni WHERE nome in("Lombardia", "Puglia") ) -- inner select
order by id_regione;

-- elencare i comuni del Lazio
SELECT id from regioni WHERE nome in("Lazio"); -- inner select da utilizzare

select id, nome
from comuni 
where id_regione in( SELECT id from regioni WHERE nome in("Lazio") )
order by nome;

-- contare quante sono le città metropolitane in Italia
SELECT COUNT(*) from province where codice_citta_metropolitana is not null;
SELECT COUNT(codice_citta_metropolitana) from province; 


-- stampare nome regione, nome provincia, sigla automobilistica per le province di Basilicata, Puglia e Veneto.

select r.nome as regione, p.nome as provincia, p.sigla_automobilistica
from province p  
join regioni r
on p.id_regione = r.id
WHERE r.nome in ("basilicata", "puglia", "veneto")
order by r.nome;
