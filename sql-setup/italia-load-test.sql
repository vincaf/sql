
select "Regioni:" as tipo, count(*) as conteggio from regioni
union
select "Province:", count(*) from province
union
select "Comuni:", count(*) from comuni
;


-- count(*) conta tutte le righe di una tabella
select count(*)  as conteggio from regioni;

-- count(nome_colonna) conta tutte le righe di una tabella dove la colonna non è null
select count(codice_citta_metropolitana) from province;


select
(select count(*) from regioni)  as "# Regioni",
(select count(*) from province) as "# Province",
(select count(*) from comuni) as "# Comuni"
;






