DROP TABLE IF EXISTS ms_product;

CREATE TABLE ms_product(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    stock INT4 NOT NULL,
    type VARCHAR(50) NOT NULL,
    price INT4 NOT NULL,
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

SELECT * FROM ms_product