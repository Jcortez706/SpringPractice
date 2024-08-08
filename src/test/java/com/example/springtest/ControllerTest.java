package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTest {
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    WeatherRepository weatherRepository;
    @Test
    public void testFindLocationsByCity() {

        List<Location> Locations = locationRepository.findLocationByCity("Covington");
        assertThat(Locations).isNotEmpty(); // Ensure this assertion passes
    }
    @Test
    public void testFindWeatherByDate(){
        LocalDate date = LocalDate.parse("2024-08-08");
        List<Weather> Weather = weatherRepository.findWeatherByDate(date);
        assertThat(Weather).isNotEmpty();
    }

//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    @Test
//    void shouldReturnEmptyDataList() throws Exception {
//        this.mockMvc.perform(get("/get"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Data []")));
//    }
//
//
//
//    @Test
//    void shouldReturnPutDataResult() throws Exception{
//        Map<String, Integer> testMap = new HashMap<String, Integer>();
//        testMap.put("number", 1);
//        testMap.put("new", 2);
//        String json = objectMapper.writeValueAsString(testMap);
//        this.mockMvc.perform(put("/put")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Data Updated")));
//    }
//
//    @Test
//    void shouldReturnPostDataResult()throws Exception{
//        Map<String, Integer> testMap = new HashMap<String, Integer>();
//        testMap.put("number", 1);
//        String json = objectMapper.writeValueAsString(testMap);
//        this.mockMvc.perform(post("/post")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Data Inserted")));
//    }
//    @Test
//    void shouldReturnDeleteDataResult() throws Exception{
//        Map<String, Integer> numberMap = new HashMap<String, Integer>();
//        numberMap.put("number", 1);
//        Controller controller = new Controller();
//        controller.insertData(numberMap);
//        this.mockMvc.perform(delete("/1"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Data Deleted")));
//    }
}