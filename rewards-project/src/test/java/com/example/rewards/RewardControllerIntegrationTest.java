package com.example.rewards;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RewardControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFetchRewards() throws Exception {

        mockMvc.perform(
                        get("/api/rewards"))
                .andExpect(
                        status().isOk());
    }

    @Test
    void shouldReturn404ForInvalidCustomer()
            throws Exception {

        mockMvc.perform(
                        get("/api/rewards/999"))
                .andExpect(
                        status().isNotFound());
    }
}