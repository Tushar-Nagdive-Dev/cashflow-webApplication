CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    username VARCHAR(100) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    roles VARCHAR(50) NOT NULL, -- Example: 'ADMIN', 'USER'
    password VARCHAR(255) NOT NULL,
    created_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    creator_id BIGINT,
    creator_name VARCHAR(100),
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modifier_id BIGINT,
    modifier_name VARCHAR(100)
);
