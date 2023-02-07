### (default da sito)docker run --detach --name some-mariadb --env MARIADB_USER=example-user --env MARIADB_PASSWORD=my_cool_secret --env MARIADB_ROOT_PASSWORD=my-secret-pw  mariadb:latest

# Start mariadb docker container
docker run --rm --detach --name db-mariadb --env MARIADB_ROOT_PASSWORD=root -v mariadb-corso-fs-2301:/var/lib/mysql -p 3306:3306 mariadb:latest

exit

# creazione del volume dati
docker volume create nome-del-volume # es: docker volume create mariadb-corso-fs-2301

# rimozione volume dati
docker volume rm nome-del-volume # es: docker volume rm mariadb-corso-fs-2301

# dettagli volume dati
docker volume inspect nome-del-volume # es: docker volume inspect mariadb-corso-fs-2301


# per fermare il container
docker stop db-mariadb

# ispeziona i dati del container (es: indirizzo di rete)
docker container inspect db-mariadb

## collegamento all'interno del container tramite la shell bash (apre un terminale interattivo)
docker exec -it db-mariadb bash







## collegamento al container via client mysql
docker run -it --rm mariadb mysql -h 172.17.0.2 -u master -p

## collegamento a mariadb monitor
docker exec -it db-mariadb mariadb --user root -proot

## backup del database
docker exec db-mariadb sh -c 'exec mariadb-dump --add-drop-database --flush-privileges -umaster -pmanager --databases corso ' > corso_backup.sql

## backup di una tabella
docker exec db-mariadb sh -c 'exec mariadb-dump -umaster -pmanager --lock-tables corso clienti ' > clienti_backup.sql
## per windows cmd
docker exec db-mariadb sh -c "exec mariadb-dump -umaster -pmanager --lock-tables corso clienti " > clienti_backup.sql

## restore del database bash e cmd
docker exec -i db-mariadb sh -c "exec mysql -h localhost -umaster -pmanager" < corso_backup.sql
## restore del database powershell da verificare
###docker exec -i db-mariadb sh -c "exec mysql -h localhost -umaster -pmanager" -RedirectStandardInput corso_backup.sql


