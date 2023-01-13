CREATE TABLE product(
                        id SERIAL PRIMARY KEY,
                        name VARCHAR (30)  NOT NULL,
                        price FLOAT     NOT NULL
);

ALTER TABLE product
    OWNER TO "Yevhen";

CREATE TABLE cart(
                               id SERIAL PRIMARY KEY,
                               name VARCHAR (30)  NOT NULL
);

ALTER TABLE cart
    OWNER TO "Yevhen";

CREATE TABLE cart_product(
                             cart_id INT,
                             product_id INT,
                             PRIMARY KEY (cart_id, product_id),
                             CONSTRAINT fk_cart FOREIGN KEY(cart_id) REFERENCES cart(id),
                             CONSTRAINT fk_product FOREIGN KEY(product_id) REFERENCES product(id)
);

ALTER TABLE cart_product
    OWNER TO "Yevhen";