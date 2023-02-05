CREATE TABLE products(
                        id SERIAL PRIMARY KEY,
                        name VARCHAR (30)  NOT NULL,
                        price FLOAT     NOT NULL
);

ALTER TABLE products
    OWNER TO "Yevhen";

CREATE TABLE orders(
                     id SERIAL PRIMARY KEY,
                     name VARCHAR (30)  NOT NULL,
                     price FLOAT  NOT NULL
);

ALTER TABLE orders
    OWNER TO "Yevhen";

CREATE TABLE orders_products(
                             orders_id INT,
                             products_id INT,
                             PRIMARY KEY (products_id),
                             CONSTRAINT fk_products FOREIGN KEY(products_id) REFERENCES products(id)
);

ALTER TABLE orders_products
    OWNER TO "Yevhen";
