--
-- query su clienti/ordini/fatture/pagamenti
--

-- quanti ordini per ogni cliente?

-- utilizzando join
SELECT clienti.ID_CLIENTE, clienti.NOME, clienti.COGNOME, COUNT(*)
FROM ordini
JOIN clienti
ON ordini.ID_CLIENTE = clienti.ID_CLIENTE 
GROUP BY clienti.ID_CLIENTE;

-- utilizzando where
SELECT clienti.ID_CLIENTE, clienti.NOME, clienti.COGNOME, COUNT(*)
FROM ordini, clienti
WHERE ordini.ID_CLIENTE = clienti.ID_CLIENTE 
GROUP BY clienti.ID_CLIENTE;

-- utilizzando right join verificare i clienti senza ordini
SELECT clienti.ID_CLIENTE, clienti.NOME, clienti.COGNOME, COUNT(ID_ORDINE) as conteggio
FROM ordini
RIGHT JOIN clienti
ON ordini.ID_CLIENTE = clienti.ID_CLIENTE 
GROUP BY clienti.ID_CLIENTE
HAVING conteggio = 0;

-- utilizzando left join verificare ordini senza cliente
SELECT ordini.ID_ORDINE, clienti.NOME, clienti.COGNOME 
FROM ordini
LEFT JOIN clienti
ON ordini.ID_CLIENTE = clienti.ID_CLIENTE 
WHERE clienti.nome is null;

--
-- elencare clienti e relative province
--
select c.id_cliente, c.nome, c.cognome, c.provincia, p.nome
from clienti c
inner join province p
on c.PROVINCIA = p.sigla_automobilistica
order by c.provincia;

--
-- elencare clienti e province e regioni
--
select c.id_cliente, c.nome, c.cognome, c.provincia, p.nome, r.nome
from clienti c
inner join province p
on c.PROVINCIA = p.sigla_automobilistica
inner join regioni r
on p.id_regione = r.id
order by c.provincia;


--
-- filtrare le righe per Veneto e Lazio
--
select c.id_cliente, c.nome, c.cognome, c.provincia, p.nome, r.nome
from clienti c
inner join province p
on c.PROVINCIA = p.sigla_automobilistica
inner join regioni r
on p.id_regione = r.id
where r.nome in ('Veneto', 'Lazio')  -- "array/lista" corrisponde ad una tabella di 1 colonna e 0-n righe.
order by c.provincia;