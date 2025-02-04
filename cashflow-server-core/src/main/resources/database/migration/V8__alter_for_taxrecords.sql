-- Step 1: Convert existing data to ordinal values
ALTER TABLE tax_records
ALTER COLUMN status TYPE SMALLINT USING 
CASE 
    WHEN status = 'PENDING' THEN 1
    WHEN status = 'PAID' THEN 0
    WHEN status = 'OVERDUE' THEN 2
END;

-- Step 2: Add a check constraint to ensure valid values
ALTER TABLE tax_records
ADD CONSTRAINT chk_tax_record_status CHECK (status IN (0, 1, 2));