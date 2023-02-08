CREATE TABLE "student"
(
    id SERIAL PRIMARY KEY NOT NULL ,
    name        VARCHAR(30) NOT NULL,
    email       VARCHAR(30) NOT NULL
);

ALTER TABLE "student"
    OWNER TO "Yevhen";

CREATE UNIQUE INDEX student_email_uindex
    ON "student" (email);