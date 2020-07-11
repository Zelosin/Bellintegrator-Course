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
public class OrganizationControllerValidationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void validIncorectOrganizationSave_NoName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"fullName\":\"9f739fcd-16b0\"," +
                        "\"INN\":0," +
                        "\"KPP\":0," +
                        "\"address\":\"address\"," +
                        "\"isActive\":false," +
                        "\"baseCountryCode\":250}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validIncorectOrganizationSave_NoFullName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"a47b-69b206503e50\"," +
                        "\"INN\":0," +
                        "\"KPP\":0," +
                        "\"address\":\"address\"," +
                        "\"isActive\":false," +
                        "\"baseCountryCode\":250}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validIncorectOrganizationSave_NoINN() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"a47b-69b206503e50\"," +
                        "\"KPP\":0," +
                        "\"address\":\"address\"," +
                        "\"isActive\":false," +
                        "\"baseCountryCode\":250}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validIncorectOrganizationSave_NoKPP() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"name\":\"a47b-69b206503e50\"," +
                        "\"fullName\":\"9f739fcd-16b0\"," +
                        "\"address\":\"ad22d2res2s3\"" +
                        "}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validIncorectOrganizationSave_NoAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"a47b-69b206503e50\"," +
                        "\"fullName\":\"9f739fcd-16b0\"," +
                        "\"INN\":0," +
                        "\"KPP\":0," +
                        "\"isActive\":false," +
                        "\"baseCountryCode\":250}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validCorectOrganizationSave() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"a47b-69b206503e50\"," +
                        "\"fullName\":\"9f739fcd-16b0\"," +
                        "\"INN\":0," +
                        "\"KPP\":0," +
                        "\"address\":\"address\"," +
                        "\"isActive\":false," +
                        "\"baseCountryCode\":250}"))
                .andExpect(jsonPath("$.result").exists());
    }

    @Test
    public void validIncorectOrganizationList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"inn\":2123456789," +
                        "\"isActive\":true}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validCorectOrganizationList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Google\"," +
                        "\"inn\":2123456789," +
                        "\"isActive\":true}"))
                .andExpect(jsonPath("$.data").isArray());
    }


    @Test
    public void validCorectOrganizationUpdate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1," +
                        "\"name\":\"a47b-69b206503e50\"," +
                        "\"fullName\":\"9f739fcd-16b0\"," +
                        "\"INN\":0," +
                        "\"KPP\":0," +
                        "\"address\":\"address\"}"))
                .andExpect(jsonPath("$.result").exists());
    }

    @Test
    public void validIncorectOrganizationUpdate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{"+
                        "\"name\":\"a47b-69b206503e50\"," +
                        "\"fullName\":\"9f739fcd-16b0\"," +
                        "\"INN\":0," +
                        "\"KPP\":0," +
                        "\"address\":\"address\"}"))
                .andExpect(jsonPath("$.error").exists());
    }
}
