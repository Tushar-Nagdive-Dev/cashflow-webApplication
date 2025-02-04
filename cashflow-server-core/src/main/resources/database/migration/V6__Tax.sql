CREATE TABLE tax_categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255),
    rate DECIMAL(5, 2) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creator_id BIGINT,
    creator_name VARCHAR(100),
    modifier_id BIGINT,
    modifier_name VARCHAR(100)
);

CREATE TABLE tax_records (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    tax_category_id BIGINT NOT NULL,
    taxable_amount DECIMAL(20, 8) NOT NULL,
    tax_amount DECIMAL(20, 8) NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creator_id BIGINT,
    creator_name VARCHAR(100),
    modifier_id BIGINT,
    modifier_name VARCHAR(100),
    FOREIGN KEY (tax_category_id) REFERENCES tax_categories (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE tax_payments (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    tax_record_id BIGINT NOT NULL,
    payment_date TIMESTAMP NOT NULL,
    payment_amount DECIMAL(20, 8) NOT NULL,
    receipt_url VARCHAR(255),
    created_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creator_id BIGINT,
    creator_name VARCHAR(100),
    modifier_id BIGINT,
    modifier_name VARCHAR(100),
    FOREIGN KEY (tax_record_id) REFERENCES tax_records (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

