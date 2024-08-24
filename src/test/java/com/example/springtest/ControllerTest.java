package com.example.springtest;

import com.example.springtest.LocationCodeService.LocationCode;
import com.example.springtest.LocationCodeService.LocationCodeRepository;
import com.example.springtest.WeatherService.Weather;
import com.example.springtest.WeatherService.WeatherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    Controller controller;

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    LocationCodeRepository locationCodeRepository;

    @Test
    public void testFindWeatherByDate() {
        LocalDate date = LocalDate.parse("2024-08-09");
        List<Weather> Weather = weatherRepository.findWeatherByDate(date);
        assertThat(Weather).isNotEmpty();
    }

    @Test
    public void testFindLocationCodeId() {
        List<Integer> locationCode = locationCodeRepository.findAllLocations();
        assertThat(locationCode).isNotEmpty();
    }

    @Test
    public void testGetMethod() {
        String resultOfGetRequest = controller.getLocationCity("Covington&Georgia");
        assertThat(resultOfGetRequest).isEqualTo("[Covington, Georgia]");
    }
}

