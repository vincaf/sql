
ALTER table comuni
ADD CONSTRAINT fk_comuni_regioni
FOREIGN key(id_regione)
REFERENCES regioni(id);

ALTER table comuni
ADD CONSTRAINT fk_comuni_province
FOREIGN key(id_provincia)
REFERENCES province(id);

ALTER table province
ADD CONSTRAINT fk_province_regioni
FOREIGN key(id_regione)
REFERENCES regioni(id);

