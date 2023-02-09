
SELECT count(*) AS "conteggio dopo rollback" FROM clienti;
SELECT count(nome) AS "conteggio province dopo update" FROM province where nome = 'dummy';

-- inizio della transazione
START TRANSACTION;

DELETE FROM clienti;
SELECT count(*) AS 'conteggio dopo delete' FROM clienti;

UPDATE province SET nome = 'dummy';
SELECT count(nome) AS "conteggio province dopo update" FROM province where nome = 'dummy';

-- fine della transazione
-- finisco in modo errore
ROLLBACK;

SELECT count(*) AS "conteggio dopo rollback" FROM clienti;
SELECT count(nome) AS "conteggio province dopo update" FROM province where nome = 'dummy';


-- -----------------------province_tmp
drop table if exists province_tmp;
create table if not exists province_tmp as select id, nome, sigla_automobilistica as targa from province;

select * from province_tmp;

-- in assenza di START (BEGIN) TRANSACTION il database si mette in modalita auto-commit
-- commit automatica ad ogni update
update province_tmp set targa = '?';


select * from province_tmp;

rollback;

-- restore delle sigle automobilistiche
update province_tmp pt
inner join province p
on pt.id = p.id
set pt.targa = p.sigla_automobilistica;


start transaction;

update province_tmp
set targa = lower(targa);

-- termina con successo e conferma (commit) gli aggiornamenti
commit;

start transaction;

update province_tmp
set nome = upper(nome);

-- termina con successo e conferma (commit) gli aggiornamenti
rollback;

select * from province_tmp;




