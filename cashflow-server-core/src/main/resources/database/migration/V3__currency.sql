CREATE TABLE currencies (
    id BIGSERIAL PRIMARY KEY,
    currency_code VARCHAR(3) NOT NULL UNIQUE,
    currency_name VARCHAR(100) NOT NULL,
    symbol VARCHAR(10),
    base_currency VARCHAR(3) NOT NULL,
    exchange_rate DECIMAL(10, 4) NOT NULL DEFAULT 1.0000,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    region VARCHAR(50),
    last_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    creator_id BIGINT,
    creator_name VARCHAR(100),
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modifier_id BIGINT,
    modifier_name VARCHAR(100)
);
