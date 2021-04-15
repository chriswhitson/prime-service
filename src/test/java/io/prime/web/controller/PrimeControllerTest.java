package io.prime.web.controller;

import io.prime.service.PrimeCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PrimeController.class)
public class PrimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrimeCalculator primeCalculator;

    @Test
    void shouldReturnCalculatedPrimes() throws Exception {
        when(primeCalculator.calculatePrimes(5)).thenReturn(asList(1, 2, 3, 5));

        mockMvc.perform(MockMvcRequestBuilders.get("/primes").param("limit", "5"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.primes").value(contains(1, 2, 3, 5)));
    }

    @Test
    void shouldReturnBadRequestIfLimitNotSpecified() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/primes"))
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.errors").value(contains("Required Integer parameter 'limit' is not present")));
    }

    @Test
    void shouldReturnBadRequestIfLimitIsNotValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/primes").param("limit", "1"))
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.errors").value(contains("Limit must be greater than or equal to 2")));
    }
}
