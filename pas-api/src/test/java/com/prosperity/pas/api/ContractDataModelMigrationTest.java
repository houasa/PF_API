package com.prosperity.pas.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Verifies the V1 baseline migration applies on H2 (PostgreSQL mode) and creates
 * the contract data model — a representative table from each tier is queryable,
 * and the full table count matches the ERD (34 tables).
 */
@SpringBootTest
class ContractDataModelMigrationTest {

    @Autowired
    private JdbcTemplate jdbc;

    @Test
    void migrationCreatesAllErdTables() {
        Integer tableCount = jdbc.queryForObject(
                "SELECT count(*) FROM information_schema.tables "
                        + "WHERE table_type = 'BASE TABLE' AND UPPER(table_schema) = 'PUBLIC' "
                        + "AND UPPER(table_name) <> 'FLYWAY_SCHEMA_HISTORY'",
                Integer.class);
        assertEquals(34, tableCount, "ERD defines 34 tables");
    }

    @Test
    void representativeTablesFromEachTierExist() {
        // base / system
        assertTrue(rowCount("policy") >= 0);
        assertTrue(rowCount("party") >= 0);
        assertTrue(rowCount("policy_glwb") >= 0);
        assertTrue(rowCount("product_config") >= 0);
        // In-Force Year 1
        assertTrue(rowCount("additional_premium") >= 0);
        assertTrue(rowCount("contract_year_closing_state") >= 0);
        // First-Year Anniversary
        assertTrue(rowCount("anniversary_run") >= 0);
        assertTrue(rowCount("indexed_term") >= 0);
        assertTrue(rowCount("payout_simulation") >= 0);
    }

    private int rowCount(String table) {
        Integer n = jdbc.queryForObject("SELECT count(*) FROM " + table, Integer.class);
        return n == null ? -1 : n;
    }
}
