CREATE TABLE IF NOT EXISTS income_sources (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    source_name VARCHAR(100) NOT NULL,
    source_type VARCHAR(50) NOT NULL,
    amount DECIMAL(20, 8) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    frequency VARCHAR(20) NOT NULL,
    description TEXT,
    status VARCHAR(10) NOT NULL CHECK (status IN ('ACTIVE', 'INACTIVE')),
    created_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creator_id BIGINT,
    creator_name VARCHAR(100),
    modifier_id BIGINT,
    modifier_name VARCHAR(100),
    CONSTRAINT fk_user_income FOREIGN KEY (user_id) REFERENCES users (id)
);
