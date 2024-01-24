--TASK 1
SELECT *
FROM "country";

SELECT id, name, population
FROM city;

SELECT *
FROM city
WHERE country_id = 1;

SELECT id, name, population
FROM city
WHERE population > 1000000;

DELETE
FROM mainland
WHERE id = 5;

ALTER TABLE Mainland
ADD existing boolean NOT NULL DEFAULT TRUE;

UPDATE Mainland
SET existing = FALSE
WHERE name = 'Pangea';

ALTER TABLE city
ADD CONSTRAINT check_population
CHECK (population >= 0);

--TASK 2
SELECT ci.name city_name, c.name country_name
FROM city ci
LEFT JOIN country c ON c.id = ci.country_id;

SELECT population
FROM city
WHERE name = 'Kiev';

SELECT SUM(population)
FROM city
WHERE country_id = 1;

SELECT country_id, AVG(population)
FROM city
GROUP BY country_id;

UPDATE city
SET population = 4000000
WHERE name = 'Lima';
COMMIT;

DELETE
FROM city
WHERE id >= 3;
COMMIT;

SELECT c.name name_of_country, count(ci.id) number_of_cities
FROM country c
JOIN city ci ON c.id = ci.country_id
GROUP BY c.id;