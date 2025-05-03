CREATE TABLE sales (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       customer_id BIGINT NOT NULL,
                       total_price DECIMAL(10, 2) NOT NULL,
                       date_of_sale DATETIME NOT NULL,
                       FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE sale_products (
                               sale_id BIGINT NOT NULL,
                               product_id BIGINT NOT NULL,
                               PRIMARY KEY (sale_id, product_id),
                               FOREIGN KEY (sale_id) REFERENCES sales(id),
                               FOREIGN KEY (product_id) REFERENCES products(id)
);
