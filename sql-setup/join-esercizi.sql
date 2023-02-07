drop table if exists motherchild;
create table motherchild (mother varchar(20) , child varchar(20) );
insert into motherchild values('Lisa', 'Mary');
insert into motherchild values('Lisa', 'Greg');
insert into motherchild values('Anne', 'Kim');
insert into motherchild values('Anne', 'Phil');
insert into motherchild values('Mary', 'Andy');
insert into motherchild values('Mary', 'Rob');

drop table if exists fatherchild;
create table fatherchild ( father varchar(20), child varchar(20) );
insert into fatherchild values('Steve', 'Frank');
insert into fatherchild values('Greg', 'Kim');
insert into fatherchild values('Greg', 'Phil');
insert into fatherchild values('Frank', 'Andy');
insert into fatherchild values('Frank', 'Rob');

drop table if exists person;
create table person (name varchar(20) , age int , income int );
insert into person values('Andy', 27, 21000);
insert into person values('Rob', 25, 15000);
insert into person values('Mary', 55, 42000);
insert into person values('Anne', 50, 35000);
insert into person values('Phil', 26, 30000);
insert into person values('Greg', 50, 40000);
insert into person values('Frank', 60, 20000);
insert into person values('Kim', 30, 41000);
insert into person values('Mike', 85, 35000);
insert into person values('Lisa', 75, 87000);

-- lista madre, figlio, età del figlio
select m.mother, m.child, p.age
from motherchild m
inner join person p
on m.child = p.name; 

-- tramite la right join verificare se il db ha problemi
select m.mother, m.child, p.name, p.age
from person p
left join motherchild m
on m.child = p.name;

select m.mother, m.child, p.name, p.age
from motherchild m
right join person p
on m.child = p.name;

-- nome del padre mancante nella tabella person
SELECT f.father, p.age
FROM fatherchild f
LEFT JOIN person p
ON f.father = p.name
WHERE p.age IS NULL;

SELECT f.father, p.age
FROM person p
RIGHT JOIN fatherchild f 
ON f.father = p.name
WHERE p.age IS NULL;

-- riempire i campi vuoti di Steve
insert into person values('Steve', 80, 90000);

SELECT f.father, p.name, p.age, p.income 
FROM fatherchild f
LEFT JOIN person p
ON f.father = p.name;

-- elencare i padri e i loro stipendi insieme ai propri figli e ai loro stipendi
select f.father, p.income, f.child, p2.income
from person p
join fatherchild f 
on p.name = f.father 
join person p2 
on p2.name = f.child;

-- aggiungere anche lo stipendio della madre, includendo solo i risultati che soddisfano tutte le condizioni
select f.father, pf.income, f.child, pc.income, m.mother, pm.income
from person pf
join fatherchild f 
on pf.name = f.father 
join person pc
on pc.name = f.child
join motherchild m 
on f.child = m.child
join person pm
on pm.name = m.mother;

-- elencare nome, stipendio ed età dei figli insieme a quelli dei rispettivi genitori (se non presenti restituisce null)
SELECT p.name, p.income, p.age, fc.father, pf.income, pf.age, mc.mother, pm.income, pm.age
from person p 
left join fatherchild fc
on fc.child = p.name 
left join motherchild mc
on mc.child = p.name
left join person pf
on pf.name = fc.father
left join person pm
on pm.name = mc.mother ;




