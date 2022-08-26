package com.girteka.assignment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static com.girteka.assignment.constants.TestConstants.*;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCustomerDetailsTest() throws Exception {

        mockMvc.perform(get("/customer/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.fullName").value(JANE_DOE))
                .andExpect(jsonPath("$.type").value(BUSINESS))
                .andExpect(jsonPath("$.cards", isA(ArrayList.class)))
                .andExpect(jsonPath("$.cards[0].id").value(2))
                .andExpect(jsonPath("$.cards[1].id").value(3))
                .andExpect(jsonPath("$.cards[0].value").value(XXXX_XXXX_XXXX_7452_CREDIT))
                .andExpect(jsonPath("$.cards[1].value").value(XXXX_XXXX_XXXX_1245_DEBIT))
                .andExpect(jsonPath("$.accounts", isA(ArrayList.class)))
                .andExpect(jsonPath("$.accounts[0].id").value(2))
                .andExpect(jsonPath("$.accounts[1].id").value(3))
                .andExpect(jsonPath("$.accounts[0].value").value(SE_7280000810340009783242_6231_84_SEK))
                .andExpect(jsonPath("$.accounts[1].value").value(GB_33_BUKB_20201555555555_895_54_GBP));
    }

}
