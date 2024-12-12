DROP TABLE IF EXISTS ms_cart_detail;

CREATE TABLE ms_cart_detail(
    id SERIAL PRIMARY KEY NOT NULL,
    cart_id INT4 NOT NULL,
    product_id INT4 NOT NULL,
    quantity INT4 NOT NULL,
    created_date TIMESTAMP NOT NULL,
    creator_id INT4 NOT NULL,
    updated_date TIMESTAMP NULL,
    updator_id INT4 NULL,
    deleted_date TIMESTAMP NULL,
    deletor_id INT4 NULL,
    rec_status VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)

WITH(
    OIDS=FALSE
);

SELECT * FROM ms_cart_detail