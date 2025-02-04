-- Step 1: Create `balance` table without foreign key constraints
CREATE TABLE IF NOT EXISTS balance (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    currency VARCHAR(3) NOT NULL,
    current_balance DECIMAL(20, 8) NOT NULL DEFAULT 0.00000000,
    reserved_balance DECIMAL(20, 8) NOT NULL DEFAULT 0.00000000,
    total_balance DECIMAL(20, 8) NOT NULL DEFAULT 0.00000000,
    minimum_balance DECIMAL(20, 8) NOT NULL DEFAULT 0.00000000,
    status VARCHAR(10) NOT NULL CHECK (status IN ('ACTIVE', 'FROZEN', 'CLOSED')),
    last_transaction_id BIGINT,
    created_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    creator_id BIGINT,
    creator_name VARCHAR(100),
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modifier_id BIGINT,
    modifier_name VARCHAR(100)
);

-- Step 2: Create `transactions` table without foreign key constraints
CREATE TABLE IF NOT EXISTS transactions (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    balance_id BIGINT,
    transaction_type VARCHAR(20) NOT NULL CHECK (transaction_type IN ('DEBIT', 'CREDIT', 'REFUND', 'ADJUSTMENT', 'TRANSFER')),
    amount DECIMAL(20, 8) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    exchange_rate DECIMAL(10, 4),
    reference_id VARCHAR(100),
    transaction_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL CHECK (status IN ('PENDING', 'SUCCESS', 'FAILED', 'CANCELLED')),
    description TEXT,
    related_transaction_id BIGINT,
    created_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    creator_id BIGINT,
    creator_name VARCHAR(100),
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modifier_id BIGINT,
    modifier_name VARCHAR(100)
);

-- Step 3: Add foreign key constraints after tables exist
ALTER TABLE balance
ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE transactions
ADD CONSTRAINT fk_user_transaction FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE transactions
ADD CONSTRAINT fk_balance_transaction FOREIGN KEY (balance_id) REFERENCES balance (id);

ALTER TABLE transactions
ADD CONSTRAINT fk_related_transaction FOREIGN KEY (related_transaction_id) REFERENCES transactions (id);

ALTER TABLE balance
ADD CONSTRAINT fk_transaction FOREIGN KEY (last_transaction_id) REFERENCES transactions (id);
