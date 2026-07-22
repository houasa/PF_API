package com.prosperity.pas.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * End-to-end skeleton test: HTTP → Micro-PAS service → embedded OpenL Product Engine → response.
 * premium $231,000 (23100000 minor) → bonus 1848000 minor, AV 24948000 minor.
 */
@SpringBootTest
class PremiumBonusControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Test
    void premiumBonusEndpointReturnsBonusAvAndTrace() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        mockMvc.perform(post("/pas/v1/calc/premium-bonus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"premiumMinor\":23100000,\"currency\":\"USD\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.premiumBonusMinor").value(1_848_000))
                .andExpect(jsonPath("$.accumulationValueMinor").value(24_948_000))
                .andExpect(jsonPath("$.currency").value("USD"))
                .andExpect(jsonPath("$.trace.configVersion").value("v2026.2"))
                .andExpect(jsonPath("$.trace.rulesApplied[0]").value("NB.PE-4"));
    }
}
