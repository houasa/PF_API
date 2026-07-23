-- PAS-1 reserveContractNumber support.
-- A durable relational record in Aurora PostgreSQL (the system of record): the
-- reserved contract number for an application reference, held before any policy
-- row exists. Not transient (unlike msd_settlement_staging). It was simply not
-- drawn on the ERD. Portable across H2 (PostgreSQL mode) and Aurora PostgreSQL.

CREATE SEQUENCE IF NOT EXISTS newbusiness.contract_number_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE newbusiness.reserved_contract_number (
    id               UUID PRIMARY KEY,
    application_ref  VARCHAR(64) NOT NULL,
    contract_number  VARCHAR(32) NOT NULL UNIQUE,
    reserved_at      TIMESTAMP   NOT NULL
);
