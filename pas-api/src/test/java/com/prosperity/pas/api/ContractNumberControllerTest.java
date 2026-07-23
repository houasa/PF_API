package com.prosperity.pas.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * PAS-1 end-to-end: POST /pas/v1/contract-numbers:reserve → 201 with a
 * PWM-YYYY-NNNNNN contract number, persisted via the service on H2.
 */
@SpringBootTest
class ContractNumberControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Test
    void reserveReturnsFormattedContractNumber() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        mockMvc.perform(post("/pas/v1/contract-numbers:reserve")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"applicationRef\":\"APP-0001\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.contractNumber", matchesPattern("PWM-\\d{4}-\\d{6}")));
    }

    @Test
    void reserveIssuesDistinctNumbers() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        String first = reserve(mockMvc, "APP-A");
        String second = reserve(mockMvc, "APP-B");
        org.junit.jupiter.api.Assertions.assertNotEquals(first, second);
    }

    private String reserve(MockMvc mockMvc, String appRef) throws Exception {
        String body = mockMvc.perform(post("/pas/v1/contract-numbers:reserve")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"applicationRef\":\"" + appRef + "\"}"))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        return body;
    }
}
