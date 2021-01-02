package com.udacity.pricing.api;

import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingControllerTest {

    public static final int VALID_ID = 19;
    public static final int INVALID_ID = 20;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PricingService pricingService;

    @Test
    public void getPriceWithValidIdTest() throws Exception {
        this.mockMvc.perform(
                get(new URI("/services/price?vehicleId=" + VALID_ID))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void getPriceWithInvalidIdTest() throws Exception {
        this.mockMvc.perform(
                get(new URI("/services/price?vehicleId=" + INVALID_ID))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNotFound());
    }

}