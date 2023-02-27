select
	(select count(*) from clienti) as 'Clienti',
	(select count(*) from ordini) as 'Ordini',
	(select count(*) from fatture) as 'Fatture',
	(select count(*) from pagamenti) as 'Pagamenti'
;