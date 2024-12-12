DROP TABLE IF EXISTS ms_cart_detail;

CREATE TABLE ms_cart_detail(
    id SERIAL PRIMARY KEY NOT NULL,
    cart_id INT4 NOT NULL,
    product_id INT4 NOT NULL,
    quantity INT4 NOT NULL,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NULL,
    deleted_date TIMESTAMP NULL,
    rec_status VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)

WITH(
    OIDS=FALSE
);

SELECT * FROM ms_cart_detail