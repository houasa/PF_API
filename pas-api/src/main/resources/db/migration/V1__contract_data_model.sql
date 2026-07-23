-- Prosperity PathWay Max — Contract Data Model
-- New Business + In-Force Year 1 + First-Year Anniversary (per ERD).
-- Portable DDL: runs on H2 (PostgreSQL mode) locally and Aurora PostgreSQL.
-- Money is integer minor units (BIGINT, *_minor); rates/percents are NUMERIC.
-- Ledger, audit, and calculation trace live in DynamoDB and are out of scope here.
-- Tables are created in dependency order so inline FK references resolve.

-- =====================================================================
-- Base / system-derived
-- =====================================================================

CREATE TABLE product_config (
    config_version               VARCHAR(64) PRIMARY KEY,
    product_id                   VARCHAR(64),
    rates_caps_participation     TEXT,
    index_account_catalog        TEXT,
    preset_models                TEXT,
    withdrawal_charge_schedules  TEXT,
    bonus_rates                  TEXT,
    glwb_option_catalog          TEXT,
    eligibility_rules            TEXT
);

CREATE TABLE nb_submission (
    submission_id               UUID PRIMARY KEY,
    trans_ref_guid              VARCHAR(64),
    trans_type                  VARCHAR(16),
    trans_sub_type              VARCHAR(16),
    trans_exe_date              DATE,
    trans_exe_time              TIME,
    trans_mode                  VARCHAR(32),
    test_indicator              VARCHAR(8),
    vendor_name                 VARCHAR(256),
    ho_assigned_app_number      VARCHAR(64),
    tracking_id                 VARCHAR(64),
    application_type            VARCHAR(32),
    application_jurisdiction    VARCHAR(8),
    application_country         VARCHAR(8),
    signed_date                 DATE,
    submission_date             DATE,
    submission_type             VARCHAR(32),
    application_signature_type  VARCHAR(32),
    application_signed_state    VARCHAR(8),
    associated_firm_id          VARCHAR(64)
);

CREATE TABLE party (
    party_id          UUID PRIMARY KEY,
    party_type_code   VARCHAR(16),          -- Person / Org
    full_name         VARCHAR(256),
    org_name          VARCHAR(256),
    first_name        VARCHAR(128),
    middle_name       VARCHAR(128),
    last_name         VARCHAR(128),
    gender            VARCHAR(8),
    birth_date        DATE,
    govt_id           VARCHAR(64),          -- masked
    govt_id_tc        VARCHAR(16),          -- type code (e.g. SSN)
    org_form          VARCHAR(64)
);

CREATE TABLE policy (
    policy_id                    UUID PRIMARY KEY,
    submission_id                UUID REFERENCES nb_submission (submission_id),
    config_version               VARCHAR(64) REFERENCES product_config (config_version),
    pol_number                   VARCHAR(64),   -- contract number
    holding_type_code            VARCHAR(32),
    holding_status               VARCHAR(32),
    policy_status                VARCHAR(32),
    line_of_business             VARCHAR(32),
    currency_type_code           VARCHAR(8),
    issue_nation                 VARCHAR(8),
    jurisdiction                 VARCHAR(8),    -- issue state
    cusip_num                    VARCHAR(16),
    carrier_code                 VARCHAR(32),
    carrier_comm_code            VARCHAR(32),
    tot_comm_retained            NUMERIC(18,6),
    distributor_client_acct_num  VARCHAR(64),
    policy_value                 NUMERIC(18,2),
    qual_plan_type               VARCHAR(32),   -- tax qualification
    ee_contrib_amt               NUMERIC(18,2),
    surrender_charge             NUMERIC(18,6),
    status                       VARCHAR(16),   -- sys: Pending / Active / Terminated
    termination_reason           VARCHAR(128),  -- sys
    issue_date                   DATE,          -- sys
    suitability_decision         BOOLEAN,       -- sys
    accumulation_value_minor     BIGINT,        -- sys
    gmv_minor                    BIGINT,        -- sys
    next_anniversary_date        DATE,          -- IF
    cumulative_premium_minor     BIGINT,        -- IF
    gmcsv_minor                  BIGINT         -- IF
);

CREATE TABLE party_role (
    role_id             UUID PRIMARY KEY,
    policy_id           UUID NOT NULL REFERENCES policy (policy_id),
    party_id            UUID NOT NULL REFERENCES party (party_id),
    relation_role_code  VARCHAR(32),
    interest_percent    NUMERIC(9,4),
    irrevocable_flag    BOOLEAN            -- IF
);

CREATE TABLE party_address (
    address_id          UUID PRIMARY KEY,
    party_id            UUID NOT NULL REFERENCES party (party_id),
    address_type_code   VARCHAR(16),       -- Home / Mailing
    line1               VARCHAR(256),
    city                VARCHAR(128),
    address_state_tc    VARCHAR(8),
    zip                 VARCHAR(16),
    address_country_tc  VARCHAR(8)
);

CREATE TABLE party_phone (
    phone_id         UUID PRIMARY KEY,
    party_id         UUID NOT NULL REFERENCES party (party_id),
    phone_type_code  VARCHAR(16),
    area_code        VARCHAR(8),
    dial_number      VARCHAR(32)
);

CREATE TABLE party_email (
    email_id     UUID PRIMARY KEY,
    party_id     UUID NOT NULL REFERENCES party (party_id),
    email_type   VARCHAR(16),
    addr_line    VARCHAR(256)
);

CREATE TABLE producer_of_record (
    producer_row_id             UUID PRIMARY KEY,
    party_id                    UUID NOT NULL REFERENCES party (party_id),
    nipr_number                 VARCHAR(32),
    company_producer_id         VARCHAR(64),   -- agent number
    company_producer_id_source  VARCHAR(32),
    carrier_appt_type_code      VARCHAR(32)
);

CREATE TABLE elected_rider (
    id            UUID PRIMARY KEY,
    policy_id     UUID NOT NULL REFERENCES policy (policy_id),
    rider_code    VARCHAR(32),
    description   VARCHAR(256),
    feature_name  VARCHAR(128)
);

CREATE TABLE elected_allocation (
    id           UUID PRIMARY KEY,
    policy_id    UUID NOT NULL REFERENCES policy (policy_id),
    invest_type  VARCHAR(32),
    base_rate    NUMERIC(18,6)
);

CREATE TABLE elected_allocation_line (
    id             UUID PRIMARY KEY,
    allocation_id  UUID NOT NULL REFERENCES elected_allocation (id),
    product_code   VARCHAR(64),
    transfer_pct   NUMERIC(9,4)
);

CREATE TABLE financial_activity (
    id                 UUID PRIMARY KEY,
    policy_id          UUID NOT NULL REFERENCES policy (policy_id),
    fin_activity_type  VARCHAR(32),
    payment_form       VARCHAR(32),
    payment_amt        NUMERIC(18,2),
    payment_method     VARCHAR(32)
);

CREATE TABLE form_instance (
    id                       UUID PRIMARY KEY,
    policy_id                UUID NOT NULL REFERENCES policy (policy_id),
    document_control_number  VARCHAR(64),
    document_control_type    VARCHAR(32),
    provider_form_number     VARCHAR(64),
    original_input_mode      VARCHAR(32)
);

CREATE TABLE form_response (
    id                UUID PRIMARY KEY,
    form_instance_id  UUID NOT NULL REFERENCES form_instance (id),
    question_number   VARCHAR(32),
    question_text     VARCHAR(512),
    question_type     VARCHAR(32),
    response_code     VARCHAR(32),
    response_text     VARCHAR(512),
    response_data     TEXT
);

CREATE TABLE policy_glwb (
    id                           UUID PRIMARY KEY,
    policy_id                    UUID NOT NULL REFERENCES policy (policy_id),
    elected_option               VARCHAR(8),        -- GLN / GLS / GLC (via rider)
    income_base_minor            BIGINT,
    payout_basis                 VARCHAR(8),        -- SINGLE / JOINT
    guaranteed_withdrawal_pct    NUMERIC(9,6),
    income_base_principal_minor  BIGINT             -- IF (GLS)
);

CREATE TABLE free_look (
    id           UUID PRIMARY KEY,
    policy_id    UUID NOT NULL REFERENCES policy (policy_id),
    window_days  INTEGER,
    starts_on    DATE,
    ends_on      DATE
);

CREATE TABLE policy_account (
    account_id     UUID PRIMARY KEY,
    policy_id      UUID NOT NULL REFERENCES policy (policy_id),
    account_key    VARCHAR(64),
    balance_minor  BIGINT,
    account_type   VARCHAR(16)        -- IF: FIXED / INDEXED
);

-- =====================================================================
-- In-Force Year 1 extension
-- =====================================================================

CREATE TABLE additional_premium (
    receivable_id                  UUID PRIMARY KEY,
    policy_id                      UUID NOT NULL REFERENCES policy (policy_id),
    amount_minor                   BIGINT,
    funding_type                   VARCHAR(16),   -- CASH / 1035 / ROLLOVER / TRANSFER
    received_date                  DATE,
    settlement_date                DATE,
    decision                       VARCHAR(16),   -- ACCEPT / FLAG_HO / REJECT
    status                         VARCHAR(24),   -- PEND_SETTLE / PEND_APPROVAL / SETTLED / REJECTED
    premium_bonus_minor            BIGINT,
    rider_bonus_minor              BIGINT,
    cumulative_premium_after_minor BIGINT,
    idempotency_key                VARCHAR(128),
    calc_version                   VARCHAR(64)
);

CREATE TABLE pending_reallocation (
    instruction_id           UUID PRIMARY KEY,
    policy_id                UUID NOT NULL REFERENCES policy (policy_id),
    mode                     VARCHAR(16),   -- PRESET / CUSTOM
    preset_model             VARCHAR(16),   -- GROWTH / BALANCED / CONSERVATIVE
    auto_rebalance           BOOLEAN,
    cutoff_date              DATE,
    effective_at_next_anniv  BOOLEAN,
    status                   VARCHAR(16),   -- PENDING / SUPERSEDED / CANCELLED
    submitted_at             TIMESTAMP,
    calc_version             VARCHAR(64)
);

CREATE TABLE pending_reallocation_line (
    id              UUID PRIMARY KEY,
    instruction_id  UUID NOT NULL REFERENCES pending_reallocation (instruction_id),
    account_key     VARCHAR(64),           -- account_key / product_code
    target_pct      NUMERIC(9,4)
);

CREATE TABLE rider_charge (
    charge_id                   UUID PRIMARY KEY,
    policy_id                   UUID NOT NULL REFERENCES policy (policy_id),
    charge_date                 DATE,          -- inception or anniversary
    charge_rate                 NUMERIC(9,6),
    income_base_at_charge_minor BIGINT,
    charge_amount_minor         BIGINT,
    calc_version                VARCHAR(64)
);

CREATE TABLE fixed_interest_tranche (
    tranche_id       UUID PRIMARY KEY,
    policy_id        UUID NOT NULL REFERENCES policy (policy_id),
    receivable_id    UUID REFERENCES additional_premium (receivable_id),   -- null = opening
    principal_minor  BIGINT,
    declared_rate    NUMERIC(9,6),
    start_date       DATE,
    source           VARCHAR(16)        -- OPENING / ADDL_PREMIUM
);

CREATE TABLE income_base_segment (
    segment_id          UUID PRIMARY KEY,
    policy_id           UUID NOT NULL REFERENCES policy (policy_id),
    receivable_id       UUID REFERENCES additional_premium (receivable_id),  -- null = opening
    segment_start_date  DATE,
    method              VARCHAR(16),       -- COMPOUND / SIMPLE
    roll_up_rate        NUMERIC(9,6),
    base_at_start_minor BIGINT,
    principal_minor     BIGINT,            -- GLS
    source              VARCHAR(16)
);

CREATE TABLE gmcsv_tranche (
    tranche_id             UUID PRIMARY KEY,
    policy_id              UUID NOT NULL REFERENCES policy (policy_id),
    receivable_id          UUID REFERENCES additional_premium (receivable_id),  -- null = initial
    premium_tranche_minor  BIGINT,
    receipt_date           DATE,
    gmcsv_pct              NUMERIC(9,6),      -- 0.875
    gmcsv_rate             NUMERIC(9,6)       -- 0.03
);

CREATE TABLE contract_year_closing_state (
    id                            UUID PRIMARY KEY,
    policy_id                     UUID NOT NULL REFERENCES policy (policy_id),
    pending_instruction_id        UUID REFERENCES pending_reallocation (instruction_id),  -- nullable
    as_of_date                    DATE,          -- contract anniversary
    accumulation_value_minor      BIGINT,
    fixed_account_value_minor     BIGINT,
    income_base_minor             BIGINT,
    held_additional_premium_minor BIGINT,
    gmv_minor                     BIGINT,
    gmcsv_minor                   BIGINT,
    handoff_status                VARCHAR(24)
);

-- =====================================================================
-- First-Year Anniversary extension
-- =====================================================================

CREATE TABLE index_value (
    index_id        VARCHAR(64),
    business_date   DATE,
    close_value     NUMERIC(18,6),
    published_at    TIMESTAMP,
    source          VARCHAR(64),
    selection_note  VARCHAR(256),
    PRIMARY KEY (index_id, business_date)
);

CREATE TABLE anniversary_run (
    run_id           UUID PRIMARY KEY,
    policy_id        UUID NOT NULL REFERENCES policy (policy_id),
    snapshot_id      UUID REFERENCES contract_year_closing_state (id),
    anniversary_date DATE,          -- effective D
    execution_date   DATE,          -- D+1
    status           VARCHAR(16),   -- PENDING / RUNNING / DONE / FAILED / QUARANTINED
    lease_owner      VARCHAR(128),
    lease_expires_at TIMESTAMP,
    idempotency_key  VARCHAR(128),
    calc_version     VARCHAR(64)
);

CREATE TABLE anniversary_run_step (
    step_id       UUID PRIMARY KEY,
    run_id        UUID NOT NULL REFERENCES anniversary_run (run_id),
    step_code     VARCHAR(16),      -- PAS-2 … PAS-9
    status        VARCHAR(16),      -- PENDING / DONE / FAILED
    completed_at  TIMESTAMP
);

CREATE TABLE year_close_reconciliation (
    recon_id                   UUID PRIMARY KEY,
    policy_id                  UUID NOT NULL REFERENCES policy (policy_id),
    run_id                     UUID NOT NULL REFERENCES anniversary_run (run_id),
    anniversary_date           DATE,
    pre_av_minor               BIGINT,
    post_av_minor              BIGINT,
    rounding_residual_minor    BIGINT,
    opening_next_year_av_minor BIGINT,
    status                     VARCHAR(24)
);

CREATE TABLE indexed_term (
    term_id                 UUID PRIMARY KEY,
    policy_id               UUID NOT NULL REFERENCES policy (policy_id),
    account_id              UUID NOT NULL REFERENCES policy_account (account_id),
    index_id                VARCHAR(64),       -- provenance ref to index_value (soft)
    contract_year           INTEGER,
    term_start_date         DATE,
    term_end_date           DATE,              -- anniversary
    crediting_method        VARCHAR(8),        -- CAP / PAR
    cap_rate                NUMERIC(9,6),
    participation_rate      NUMERIC(9,6),
    spread                  NUMERIC(9,6),
    floor                   NUMERIC(9,6),      -- 0%
    start_index_value       NUMERIC(18,6),
    end_index_value         NUMERIC(18,6),
    growth_rate             NUMERIC(12,6),
    credited_interest_minor BIGINT,
    credited_at             TIMESTAMP
);

CREATE TABLE reallocation_application (
    application_id            UUID PRIMARY KEY,
    policy_id                 UUID NOT NULL REFERENCES policy (policy_id),
    run_id                    UUID NOT NULL REFERENCES anniversary_run (run_id),
    source_instruction_id     UUID REFERENCES pending_reallocation (instruction_id),  -- null = default
    anniversary_date          DATE,
    auto_rebalance_applied    BOOLEAN,
    held_premium_moved_minor  BIGINT
);

CREATE TABLE payout_simulation (
    simulation_id             UUID PRIMARY KEY,
    policy_id                 UUID NOT NULL REFERENCES policy (policy_id),
    run_id                    UUID NOT NULL REFERENCES anniversary_run (run_id),
    anniversary_date          DATE,
    basis                     VARCHAR(8),        -- SINGLE / JOINT
    assumed_election_age      INTEGER,
    income_base_at_sim_minor  BIGINT,
    guaranteed_withdrawal_pct NUMERIC(9,6),
    mawb_minor                BIGINT
);

CREATE TABLE anniversary_statement (
    statement_id         UUID PRIMARY KEY,
    policy_id            UUID NOT NULL REFERENCES policy (policy_id),
    run_id               UUID NOT NULL REFERENCES anniversary_run (run_id),
    anniversary_date     DATE,
    payload_ref          VARCHAR(256),      -- XML payload reference
    generated_at         TIMESTAMP,
    doc_gen_status       VARCHAR(24),
    notification_status  VARCHAR(24),
    idempotency_key      VARCHAR(128)
);
