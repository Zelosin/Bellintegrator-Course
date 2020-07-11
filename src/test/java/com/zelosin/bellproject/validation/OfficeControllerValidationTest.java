package com.zelosin.bellproject.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Transactional
public class OfficeControllerValidationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void validIncorectOfficeSave_NoOrgId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"name\":\"a47b-69b206503e50\"," +
                        "\"address\":\"9f739fcd-16b0\"," +
                        "\"isActive\":true," +
                        "\"baseCountryCode\":250}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validCorectOfficeSave() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"orgId\":2," +
                        "\"name\":\"a47b-69b206503e50\"," +
                        "\"address\":\"9f739fcd-16b0\"," +
                        "\"isActive\":true," +
                        "\"baseCountryCode\":250}"))
                .andExpect(jsonPath("$.result").exists());
    }

    @Test
    public void validIncorectOfficeList_NoOrgId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"isActive\":true," +
                        "\"name\":\"Yandex SP\"}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validCorectOfficeList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"orgId\":1," +
                        "\"isActive\":true," +
                        "\"name\":\"Yandex SP\"}"))
                .andExpect(jsonPath("$.data").isArray());
    }


    @Test
    public void validIncorectOfficeUpdate_NoOrgId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"name\":\"a47b-69b206503e50\"," +
                        "\"address\":\"address\"," +
                        "\"isActive\":true," +
                        "\"baseCountryCode\":250}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validIncorectOfficeUpdate_NoName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1," +
                        "\"address\":\"address\"," +
                        "\"isActive\":true," +
                        "\"baseCountryCode\":250}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validIncorectOfficeUpdate_NoAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1," +
                        "\"name\":\"a47b-69b206503e50\"," +
                        "\"address\":\"address\"," +
                        "\"isActive\":true}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validCorectOfficeUpdate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1," +
                        "\"name\":\"a47b-69b206503e50\"," +
                        "\"address\":\"address\"," +
                        "\"isActive\":true," +
                        "\"baseCountryCode\":250}"))
                .andExpect(jsonPath("$.result").exists());
    }
}
