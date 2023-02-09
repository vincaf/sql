
DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `id` int(11) unsigned NOT NULL,
  `id_regione` int(11) unsigned NOT NULL,
  `codice_citta_metropolitana` int(11) unsigned DEFAULT NULL,
  `nome` text NOT NULL,
  `sigla_automobilistica` varchar(2) NOT NULL,
  `latitudine` decimal(9,6) NOT NULL,
  `longitudine` decimal(9,6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `province` VALUES (1,1,201,'Torino','TO',45.063299,7.669289);
INSERT INTO `province` VALUES (2,1,NULL,'Vercelli','VC',45.320220,8.418508);
INSERT INTO `province` VALUES (3,1,NULL,'Novara','NO',45.548513,8.515079);
INSERT INTO `province` VALUES (4,1,NULL,'Cuneo','CN',44.597031,7.611422);
INSERT INTO `province` VALUES (5,1,NULL,'Asti','AT',44.900765,8.206432);
INSERT INTO `province` VALUES (6,1,NULL,'Alessandria','AL',44.817559,8.704663);
INSERT INTO `province` VALUES (7,2,NULL,'Valle d''Aosta/Vallée d''Aoste','AO',45.738888,7.426187);
INSERT INTO `province` VALUES (8,7,NULL,'Imperia','IM',43.941866,7.828637);
INSERT INTO `province` VALUES (9,7,NULL,'Savona','SV',44.288800,8.265058);
INSERT INTO `province` VALUES (10,7,210,'Genova','GE',44.446625,9.145615);
INSERT INTO `province` VALUES (11,7,NULL,'La Spezia','SP',44.102450,9.824083);
INSERT INTO `province` VALUES (12,3,NULL,'Varese','VA',45.799026,8.730095);
INSERT INTO `province` VALUES (13,3,NULL,'Como','CO',45.808042,9.085179);
INSERT INTO `province` VALUES (14,3,NULL,'Sondrio','SO',46.172764,9.799492);
INSERT INTO `province` VALUES (15,3,215,'Milano','MI',45.458626,9.181873);
INSERT INTO `province` VALUES (16,3,NULL,'Bergamo','BG',45.857830,9.881998);
INSERT INTO `province` VALUES (17,3,NULL,'Brescia','BS',45.659677,10.385672);
INSERT INTO `province` VALUES (18,3,NULL,'Pavia','PV',45.321817,8.846624);
INSERT INTO `province` VALUES (19,3,NULL,'Cremona','CR',45.201438,9.983658);
INSERT INTO `province` VALUES (20,3,NULL,'Mantova','MN',45.156417,10.791375);
INSERT INTO `province` VALUES (21,4,NULL,'Bolzano/Bozen','BZ',46.734096,11.288802);
INSERT INTO `province` VALUES (22,4,NULL,'Trento','TN',46.051200,11.117539);
INSERT INTO `province` VALUES (23,5,NULL,'Verona','VR',45.441850,11.073532);
INSERT INTO `province` VALUES (24,5,NULL,'Vicenza','VI',45.545479,11.535421);
INSERT INTO `province` VALUES (25,5,NULL,'Belluno','BL',46.249766,12.196957);
INSERT INTO `province` VALUES (26,5,NULL,'Treviso','TV',45.666852,12.243062);
INSERT INTO `province` VALUES (27,5,227,'Venezia','VE',45.493048,12.417700);
INSERT INTO `province` VALUES (28,5,NULL,'Padova','PD',45.366186,11.820914);
INSERT INTO `province` VALUES (29,5,NULL,'Rovigo','RO',45.024182,11.823816);
INSERT INTO `province` VALUES (30,6,NULL,'Udine','UD',46.140797,13.166290);
INSERT INTO `province` VALUES (31,6,NULL,'Gorizia','GO',45.905390,13.516373);
INSERT INTO `province` VALUES (32,6,NULL,'Trieste','TS',45.689482,13.783307);
INSERT INTO `province` VALUES (33,8,NULL,'Piacenza','PC',44.826311,9.529145);
INSERT INTO `province` VALUES (34,8,NULL,'Parma','PR',44.801532,10.327935);
INSERT INTO `province` VALUES (35,8,NULL,'Reggio nell''Emilia','RE',44.585658,10.556474);
INSERT INTO `province` VALUES (36,8,NULL,'Modena','MO',44.551380,10.918048);
INSERT INTO `province` VALUES (37,8,237,'Bologna','BO',44.500510,11.304784);
INSERT INTO `province` VALUES (38,8,NULL,'Ferrara','FE',44.766368,11.764407);
INSERT INTO `province` VALUES (39,8,NULL,'Ravenna','RA',44.418444,12.203600);
INSERT INTO `province` VALUES (40,8,NULL,'Forlì-Cesena','FC',44.222500,12.040833);
INSERT INTO `province` VALUES (41,11,NULL,'Pesaro e Urbino','PU',43.613012,12.713512);
INSERT INTO `province` VALUES (42,11,NULL,'Ancona','AN',43.549325,13.266348);
INSERT INTO `province` VALUES (43,11,NULL,'Macerata','MC',43.245932,13.266348);
INSERT INTO `province` VALUES (44,11,NULL,'Ascoli Piceno','AP',42.863893,13.589973);
INSERT INTO `province` VALUES (45,9,NULL,'Massa-Carrara','MS',44.079325,10.097677);
INSERT INTO `province` VALUES (46,9,NULL,'Lucca','LU',43.837674,10.495053);
INSERT INTO `province` VALUES (47,9,NULL,'Pistoia','PT',43.954373,10.890310);
INSERT INTO `province` VALUES (48,9,248,'Firenze','FI',43.767918,11.252379);
INSERT INTO `province` VALUES (49,9,NULL,'Livorno','LI',43.023985,10.664710);
INSERT INTO `province` VALUES (50,9,NULL,'Pisa','PI',43.722832,10.401719);
INSERT INTO `province` VALUES (51,9,NULL,'Arezzo','AR',43.466896,11.882360);
INSERT INTO `province` VALUES (52,9,NULL,'Siena','SI',43.293773,11.433915);
INSERT INTO `province` VALUES (53,9,NULL,'Grosseto','GR',42.851801,11.252379);
INSERT INTO `province` VALUES (54,10,NULL,'Perugia','PG',42.938004,12.621621);
INSERT INTO `province` VALUES (55,10,NULL,'Terni','TR',42.563453,12.529803);
INSERT INTO `province` VALUES (56,12,NULL,'Viterbo','VT',42.420677,12.107669);
INSERT INTO `province` VALUES (57,12,NULL,'Rieti','RI',42.367441,12.897510);
INSERT INTO `province` VALUES (58,12,258,'Roma','RM',41.872411,12.480225);
INSERT INTO `province` VALUES (59,12,NULL,'Latina','LT',41.408748,13.081790);
INSERT INTO `province` VALUES (60,12,NULL,'Frosinone','FR',41.657653,13.636272);
INSERT INTO `province` VALUES (61,15,NULL,'Caserta','CE',41.207835,14.100133);
INSERT INTO `province` VALUES (62,15,NULL,'Benevento','BN',41.203509,14.752094);
INSERT INTO `province` VALUES (63,15,263,'Napoli','NA',40.901975,14.332644);
INSERT INTO `province` VALUES (64,15,NULL,'Avellino','AV',40.996451,15.125896);
INSERT INTO `province` VALUES (65,15,NULL,'Salerno','SA',40.428783,15.219481);
INSERT INTO `province` VALUES (66,13,NULL,'L''Aquila','AQ',42.349848,13.399509);
INSERT INTO `province` VALUES (67,13,NULL,'Teramo','TE',42.589561,13.636272);
INSERT INTO `province` VALUES (68,13,NULL,'Pescara','PE',42.357066,13.960809);
INSERT INTO `province` VALUES (69,13,NULL,'Chieti','CH',42.033443,14.379191);
INSERT INTO `province` VALUES (70,14,NULL,'Campobasso','CB',41.673887,14.752094);
INSERT INTO `province` VALUES (71,16,NULL,'Foggia','FG',41.638448,15.594339);
INSERT INTO `province` VALUES (72,16,272,'Bari','BA',41.117123,16.871976);
INSERT INTO `province` VALUES (73,16,NULL,'Taranto','TA',40.574090,17.242998);
INSERT INTO `province` VALUES (74,16,NULL,'Brindisi','BR',40.611266,17.763621);
INSERT INTO `province` VALUES (75,16,NULL,'Lecce','LE',40.234739,18.142867);
INSERT INTO `province` VALUES (76,17,NULL,'Potenza','PZ',40.418219,15.876004);
INSERT INTO `province` VALUES (77,17,NULL,'Matera','MT',40.666350,16.604364);
INSERT INTO `province` VALUES (78,18,NULL,'Cosenza','CS',39.564411,16.252214);
INSERT INTO `province` VALUES (79,18,NULL,'Catanzaro','CZ',38.889635,16.440587);
INSERT INTO `province` VALUES (80,18,NULL,'Reggio di Calabria','RC',38.111301,15.647291);
INSERT INTO `province` VALUES (81,19,NULL,'Trapani','TP',37.877740,12.713512);
INSERT INTO `province` VALUES (82,19,NULL,'Palermo','PA',38.115621,13.361318);
INSERT INTO `province` VALUES (83,19,NULL,'Messina','ME',38.063240,14.985618);
INSERT INTO `province` VALUES (84,19,NULL,'Agrigento','AG',37.311090,13.576548);
INSERT INTO `province` VALUES (85,19,NULL,'Caltanissetta','CL',37.490112,14.062893);
INSERT INTO `province` VALUES (86,19,NULL,'Enna','EN',37.516481,14.379191);
INSERT INTO `province` VALUES (87,19,NULL,'Catania','CT',37.612598,14.938885);
INSERT INTO `province` VALUES (88,19,NULL,'Ragusa','RG',36.930622,14.705431);
INSERT INTO `province` VALUES (89,19,NULL,'Siracusa','SR',37.075437,15.286593);
INSERT INTO `province` VALUES (90,20,NULL,'Sassari','SS',40.796791,8.575041);
INSERT INTO `province` VALUES (91,20,NULL,'Nuoro','NU',40.328690,9.456155);
INSERT INTO `province` VALUES (92,20,NULL,'Cagliari','CA',39.223763,9.121867);
INSERT INTO `province` VALUES (93,6,NULL,'Pordenone','PN',46.037886,12.710835);
INSERT INTO `province` VALUES (94,14,NULL,'Isernia','IS',41.589156,14.193092);
INSERT INTO `province` VALUES (95,20,NULL,'Oristano','OR',40.059907,8.748117);
INSERT INTO `province` VALUES (96,1,NULL,'Biella','BI',45.562818,8.058272);
INSERT INTO `province` VALUES (97,3,NULL,'Lecco','LC',45.938294,9.385729);
INSERT INTO `province` VALUES (98,3,NULL,'Lodi','LO',45.240504,9.529251);
INSERT INTO `province` VALUES (99,8,NULL,'Rimini','RN',43.967605,12.575703);
INSERT INTO `province` VALUES (100,9,NULL,'Prato','PO',44.045390,11.116445);
INSERT INTO `province` VALUES (101,18,NULL,'Crotone','KR',39.130986,17.006703);
INSERT INTO `province` VALUES (102,18,NULL,'Vibo Valentia','VV',38.637857,16.205148);
INSERT INTO `province` VALUES (103,1,NULL,'Verbano-Cusio-Ossola','VB',46.139969,8.272465);
INSERT INTO `province` VALUES (104,20,NULL,'Olbia-Tempio','OT',40.826838,9.278558);
INSERT INTO `province` VALUES (105,20,NULL,'Ogliastra','OG',39.841054,9.456155);
INSERT INTO `province` VALUES (106,20,NULL,'Medio Campidano','VS',39.531739,8.704075);
INSERT INTO `province` VALUES (107,20,NULL,'Carbonia-Iglesias','CI',39.253466,8.572102);
INSERT INTO `province` VALUES (108,3,NULL,'Monza e della Brianza','MB',45.623599,9.258802);
INSERT INTO `province` VALUES (109,11,NULL,'Fermo','FM',43.093137,13.589973);
INSERT INTO `province` VALUES (110,16,NULL,'Barletta-Andria-Trani','BT',41.200454,16.205148);

