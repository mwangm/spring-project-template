package com.example.order;

import com.example.order.api.response.KeyDetailResponse;
import com.example.order.service.KeyService;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class KeyControllerTests extends AbstractControllerTest {
    @MockBean
    KeyService keyService;

    @Test
    public void getKey() throws Exception {
        when(keyService.getKey(1L)).thenReturn(
                KeyDetailResponse.builder()
                        .id(1L)
                        .number("key_number1")
                        .build());

        mockMvc.perform(get("/keys/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.number", is("key_number1")))
                .andReturn();
    }
}
