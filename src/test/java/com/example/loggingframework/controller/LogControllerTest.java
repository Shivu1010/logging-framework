package com.example.loggingframework.controller;

import com.example.loggingframework.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LogController.class)
class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DemoService demoService;

    @Test
    void testProcessInput() throws Exception {
        when(demoService.performAction("test")).thenReturn("Processed: test");
        mockMvc.perform(get("/process").param("input", "test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Processed: test"));
    }
}