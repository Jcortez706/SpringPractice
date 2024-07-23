package com.example.springtest;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private Details details;

    @Test
    void shouldReturnEmptyDataList() throws Exception {
        this.mockMvc.perform(get("/get")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Data []")));
    }

    @Test
    void shouldReturnPutDataResult() throws Exception{
        Details detailsTest = new Details(1,2);

        String json = objectMapper.writeValueAsString(detailsTest);
        this.mockMvc.perform(put("/put")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Data Updated")));
    }

    @Test
    void shouldReturnPostDataResult()throws Exception{
        Details detailsTest = new Details(1);

        String json = objectMapper.writeValueAsString(detailsTest);
        this.mockMvc.perform(post("/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Data Inserted")));
    }
    @Test
    void shouldReturnDeleteDataResult() throws Exception{
        Details detailsTest = new Details();
        detailsTest.insertData(1);

        this.mockMvc.perform(delete("/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Data Deleted")));
    }
}