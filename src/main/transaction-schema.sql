DROP TABLE IF EXISTS tr_header;

CREATE TABLE tr_header(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NULL,
    deleted_date TIMESTAMP NULL,
    rec_status VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)

WITH(
    OIDS=FALSE
);

SELECT * FROM tr_header