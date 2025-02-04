-- Step 1: Update column type with explicit conversion
ALTER TABLE income_sources
ALTER COLUMN status TYPE SMALLINT USING 
CASE 
    WHEN status = 'ACTIVE' THEN 1
    WHEN status = 'INACTIVE' THEN 0
END;

-- Step 2: Add a check constraint for valid values
ALTER TABLE income_sources
ADD CONSTRAINT chk_status CHECK (status IN (0, 1));

