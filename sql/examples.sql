SELECT * FROM "country";

SELECT id, name, population FROM city;

SELECT * FROM city WHERE country_id = 1;

SELECT id, name, population FROM city WHERE population > 1000000;

DELETE FROM mainland WHERE id = 5;

ALTER TABLE Mainland ADD existing boolean NOT NULL default TRUE;

UPDATE Mainland
SET existing = FALSE WHERE name = 'Pangea';

alter table city
    add constraint check_population
        check (population >= 0);