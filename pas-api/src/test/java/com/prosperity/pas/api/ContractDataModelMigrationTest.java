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
    void migrationCreatesAllErdTablesAcrossModuleSchemas() {
        Integer tableCount = jdbc.queryForObject(
                "SELECT count(*) FROM information_schema.tables "
                        + "WHERE table_type = 'BASE TABLE' AND LOWER(table_schema) IN "
                        + "('product_config','newbusiness','policy','servicing','anniversary') "
                        + "AND LOWER(table_name) <> 'reserved_contract_number'",  // system work table (V2), not ERD
                Integer.class);
        assertEquals(34, tableCount, "ERD defines 34 tables across the 5 module schemas");
    }

    @Test
    void representativeTablesFromEachModuleSchemaExist() {
        assertTrue(rowCount("product_config.product_config") >= 0);   // product-engine
        assertTrue(rowCount("newbusiness.nb_submission") >= 0);       // pas-newbusiness
        assertTrue(rowCount("policy.policy") >= 0);                   // pas-policy
        assertTrue(rowCount("policy.party") >= 0);
        assertTrue(rowCount("policy.policy_glwb") >= 0);
        assertTrue(rowCount("servicing.additional_premium") >= 0);   // pas-servicing (In-Force)
        assertTrue(rowCount("servicing.contract_year_closing_state") >= 0);
        assertTrue(rowCount("anniversary.anniversary_run") >= 0);    // pas-anniversary
        assertTrue(rowCount("anniversary.indexed_term") >= 0);
        assertTrue(rowCount("anniversary.payout_simulation") >= 0);
    }

    private int rowCount(String table) {
        Integer n = jdbc.queryForObject("SELECT count(*) FROM " + table, Integer.class);
        return n == null ? -1 : n;
    }
}
