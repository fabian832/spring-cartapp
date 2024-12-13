DROP TABLE IF EXISTS tr_detail;

CREATE TABLE tr_detail(
    id SERIAL PRIMARY KEY NOT NULL,
    transaction_id INT4 NOT NULL,
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

SELECT * FROM tr_detail