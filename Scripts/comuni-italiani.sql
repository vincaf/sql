SELECT * FROM comuni;

SELECT * FROM comuni_italiani;

-- vedere se le due tabelle hanno le caratteristiche minime per essere allineabili.

-- hanno lo stesso numero di righe?
-- comuni = 7999
-- comuni-italiani = 7978

SELECT
(SELECT count(*) FROM comuni) AS "comuni",
(SELECT count(*) FROM comuni_italiani) AS "comuni_italiani",
(SELECT count(*) FROM comuni) - (SELECT count(*) FROM comuni_italiani) AS delta;

-- comuni_italiani ha 21 righe in meno di comuni

-- esiste una colonna che ha il medesimo valore in entrambe le tabelle?
-- ovvero una colonna il cui valore potrebbe collegare le tabelle?

-- id, come faccio a verificare?
-- nome, come faccio a verificare?
-- codice_catastale, come faccio a verificare?
-- coordinate (troppo diffcile da verificare)

SELECT COUNT(*) from comuni WHERE id in (SELECT id from comuni_italiani); -- 1121, strada non percorribile

SELECT id, nome from { -- sono 15977
	select id, nome from comuni
	union
	select id, comune from comuni_italiani
} xxx;

SELECT (7999 + 7978); -- 15977, tutti gli abbinamenti id/nome sono diversi tra le due tabelle

select count(*) from ( -- sono 8133
	select nome from comuni
	union -- sopprime i record doppi
	select comune from comuni_italiani
) xxx;

select (7999 - 8133); -- 134
select (7978 - 8133); -- 155

select 155 - 134; -- 21

select 134 - 21; -- 113 comuni che non matchano il nome

-- vogliamo vedere quali sono i comuni di comuni_italiani che non hanno il nome uguale in comuni
-- sono 143
select comune
from comuni_italiani
where comune not in (select nome from comuni)
;

/*
 comune                                                     |
-----------------------------------------------------------+
Abetone Cutigliano                                         |
Aldino/Aldein                                              |
Alta Valle Intelvi                                         |
Andriano/Andrian                                           |
Anterivo/Altrei                                            |
Appiano sulla strada del vino/Eppan an der Weinstraße      |
Avelengo/Hafling                                           |
Badia/Abtei                                                |
Barbiano/Barbian                                           |
Bolzano/Bozen                                              |
Braies/Prags                                               |
Brennero/Brenner                                           |
Bressanone/Brixen                                          |
Bronzolo/Branzoll                                          |
Brunico/Bruneck                                            |
Caines/Kuens                                               |
Caldaro sulla strada del vino/Kaltern an der Weinstraße    |
Campo di Trens/Freienfeld                                  |
Campo Tures/Sand in Taufers                                |
Capaccio Paestum                                           |
Casali del Manco                                           |
Castelbello-Ciardes/Kastelbell-Tschars                     |
Castelrotto/Kastelruth                                     |
Cermes/Tscherms                                            |
Chienes/Kiens                                              |
Chiusa/Klausen                                             |
Colli al Metauro                                           |
Cornedo all'Isarco/Karneid                                 |
Cortaccia sulla strada del vino/Kurtatsch an der Weinstraße|
Cortina sulla strada del vino/Kurtinig an der Weinstraße   |
Corvara in Badia/Corvara                                   |
Costermano sul Garda                                       |
Curon Venosta/Graun im Vinschgau                           |
Dobbiaco/Toblach                                           |
Duino Aurisina - Devin Nabrezina                           |
Egna/Neumarkt                                              |
Falzes/Pfalzen                                             |
Fiè allo Sciliar/Völs am Schlern                           |
Fortezza/Franzensfeste                                     |
Fubine Monferrato                                          |
Funes/Villnöß                                              |
Gais/Gais                                                  |
Gargazzone/Gargazon                                        |
Glorenza/Glurns                                            |
Gornate-Olona                                              |
La Valle/Wengen                                            |
Laces/Latsch                                               |
Lagundo/Algund                                             |
Laion/Lajen                                                |
Laives/Leifers                                             |
Lana/Lana                                                  |
Lasa/Laas                                                  |
Lauregno/Laurein                                           |
Luni                                                       |
Luson/Lüsen                                                |
Magrè sulla strada del vino/Margreid an der Weinstraße     |
Malles Venosta/Mals                                        |
Mappano                                                    |
Marebbe/Enneberg                                           |
Marlengo/Marling                                           |
Martello/Martell                                           |
Meltina/Mölten                                             |
Merano/Meran                                               |
Monguelfo-Tesido/Welsberg-Taisten                          |
Monrupino - Repentabor                                     |
Montagna/Montan                                            |
Montebello Jonico                                          |
Moso in Passiria/Moos in Passeier                          |
Muggia - Muglae                                            |
Nalles/Nals                                                |
Naturno/Naturns                                            |
Naz-Sciaves/Natz-Schabs                                    |
Nova Levante/Welschnofen                                   |
Nova Ponente/Deutschnofen                                  |
Ora/Auer                                                   |
Ortisei/St' Ulrich                                         |
Parcines/Partschins                                        |
Perca/Percha                                               |
Plaus/Plaus                                                |
Ponte Gardena/Waidbruck                                    |
Postal/Burgstall                                           |
Prato allo Stelvio/Prad am Stilfserjoch                    |
Predoi/Prettau                                             |
Proves/Proveis                                             |
Puegnago del Garda                                         |
Racines/Ratschings                                         |
Rasun-Anterselva/Rasen-Antholz                             |
Reggio Calabria                                            |
Reggio Emilia                                              |
Renon/Ritten                                               |
Rifiano/Riffian                                            |
Rio di Pusteria/Mühlbach                                   |
Roccella Jonica                                            |
Rodengo/Rodeneck                                           |
Salorno/Salurn                                             |
San Candido/Innichen                                       |
San Genesio Atesino/Jenesien                               |
San Leonardo in Passiria/St' Leonha                        |
San Lorenzo di Sebato/St' Lorenz                           |
San Marcello Piteglio                                      |
San Martino in Badia/St' Martin                            |
San Martino in Passiria/St' Martin                         |
San Pancrazio/St' Pankra                                   |
Santa Cristina Valgardena/St' Christ                       |
Sarentino/Sarntal                                          |
Scena/Schenna                                              |
Selva dei Molini/Mühlwald                                  |
Selva di Val Gardena/Wolkenstein in Gröden                 |
Senales/Schnals                                            |
Senale-San Felice/Unsere Liebe Frau im Walde-St' Felix     |
Sermide e Felonica                                         |
Sesto/Sexten                                               |
Sgonico - Zgonik                                           |
Silandro/Schlanders                                        |
Sluderno/Schluderns                                        |
Soraga di Fassa                                            |
Stelvio/Stilfs                                             |
Terento/Terenten                                           |
Terlano/Terlan                                             |
Termeno sulla strada del vino/Tramin an der Weinstraße     |
Terre del Reno                                             |
Terre Roveresche                                           |
Tesimo/Tisens                                              |
Tires/Tiers                                                |
Tirolo/Tirol                                               |
Trodena nel parco naturale/Truden im Naturpark             |
Tubre/Taufers im Münstertal                                |
Ultimo/Ulten                                               |
Vadena/Pfatten                                             |
Val di Vizze/Pfitsch                                       |
Val Liona                                                  |
Valdaora/Olang                                             |
Valfornace                                                 |
Valle Aurina/Ahrntal                                       |
Valle di Casies/Gsies                                      |
Vandoies/Vintl                                             |
Varna/Vahrn                                                |
Velturno/Feldthurns                                        |
Verano/Vöran                                               |
Villabassa/Niederdorf                                      |
Villandro/Villanders                                       |
Vipiteno/Sterzing                                          |
Vò                                                         |
 */

