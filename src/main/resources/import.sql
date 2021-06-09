DROP TABLE IF EXISTS model;
DROP TABLE IF EXISTS make;

CREATE TABLE IF NOT EXISTS make
(
    id  int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name varchar(40) NOT NULL
);
CREATE TABLE IF NOT EXISTS model
(
    id  int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name varchar(40) NOT NULL,
    year_from integer,
    year_to integer,
    id_make int references make(id)
);
CREATE INDEX idx_id_make ON make(id);
CREATE INDEX idx_id_model ON model(id);

CREATE INDEX idx_year_from ON model(year_from);
CREATE INDEX idx_year_to ON model(year_to);

INSERT INTO make(name)
VALUES ('SKODA');
INSERT INTO make(name)
VALUES ('REANAULT');
INSERT INTO make(name)
VALUES ('BWM');
--SKODA
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('YETI', 2009, 2017, 1);
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('FABIA', 1999, 2021, 1);
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('KODIAQ', 2016, 2021, 1);
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('SUPERB', 2001, 2008, 1);
--RENAULT
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('CLIO', 1990, 2021, 2);
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('LAGUNA', 1993, 2015, 2);
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('TALISMAN', 2015, 2021, 2);
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('CAPTUR', 2013, 2021, 2);
--BMW
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('SERIA 1', 2004, 2011, 3);
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('SERIA 3', 1975, 1983, 3);
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('SERIA Z', 2008, 2021, 3);
INSERT INTO model(name, year_from, year_to, id_make)
VALUES ('SERIA M5', 1985, 1998, 3);
