CREATE TABLE city(
                     id SERIAL PRIMARY KEY NOT NULL ,
                     name VARCHAR (30)  NOT NULL,
                     population INT     NOT NULL ,
                     country_id INT     NOT NULL REFERENCES country(id) ON DELETE CASCADE
);

ALTER TABLE city
    OWNER TO "Yevhen";

CREATE UNIQUE INDEX city_name_uindex
    ON city (name);

CREATE TABLE "country"
(
    id SERIAL PRIMARY KEY NOT NULL ,
    name        VARCHAR(30) NOT NULL ,
    mainland_id INT     NOT NULL REFERENCES mainland(id) ON DELETE CASCADE
);

ALTER TABLE "country"
    OWNER TO "Yevhen";

CREATE UNIQUE INDEX "country _name_uindex"
    ON "country" (name);

CREATE TABLE "mainland"
(
    id SERIAL PRIMARY KEY NOT NULL ,
    name        VARCHAR(30) NOT NULL
);

ALTER TABLE "mainland"
    OWNER TO "Yevhen";

CREATE UNIQUE INDEX "mainland_name_uindex"
    ON "mainland" (name);



create table "city-country"
(
    id         serial not null
        constraint "city-country_pk"
            primary key,
    city_id    integer not null
        constraint "city-country_city_id_fk"
            references city,
    country_id integer not null
        constraint "city-country_country_id_fk"
            references country
);

alter table "city-country"
    owner to "Yevhen";




CREATE TABLE "mainland"
(
    id SERIAL PRIMARY KEY NOT NULL ,
    name        VARCHAR(30) NOT NULL
);

ALTER TABLE "mainland"
    OWNER TO "Yevhen";

CREATE UNIQUE INDEX "mainland_name_uindex"
    ON "mainland" (name);

CREATE TABLE "country"
(
    id SERIAL PRIMARY KEY NOT NULL ,
    name        VARCHAR(30) NOT NULL ,
    mainland_id INT     NOT NULL REFERENCES mainland(id) ON DELETE CASCADE
);

ALTER TABLE "country"
    OWNER TO "Yevhen";

CREATE UNIQUE INDEX "country _name_uindex"
    ON "country" (name);

CREATE TABLE city(
                     id SERIAL PRIMARY KEY,
                     name VARCHAR (30)  NOT NULL,
                     population INT     NOT NULL ,
                     country_id INT     NOT NULL REFERENCES country(id) ON DELETE CASCADE
);

ALTER TABLE city
    OWNER TO "Yevhen";

CREATE UNIQUE INDEX city_name_uindex
    ON city (name);