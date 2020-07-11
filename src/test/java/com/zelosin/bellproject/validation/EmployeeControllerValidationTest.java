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
public class EmployeeControllerValidationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void validIncorectEmployeeSave_NoFirstName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"officeId\":1," +
                        "\"position\":\"Junior developer\"}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validIncorectEmployeeSave_NoOfficeId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"firstName\":\"firstNameTest\"," +
                        "\"position\":\"Junior developer\"}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validCorectEmployeeSave_NoPosition() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"officeId\":1," +
                        "\"firstName\":\"firstNameTest\"}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validCorectEmployeeSave() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"officeId\":1," +
                        "\"firstName\":\"firstNameTest\"," +
                        "\"position\":\"Junior developer\"}"))
                .andExpect(jsonPath("$.result").exists());
    }

    @Test
    public void validIncorectEmployeeList_NoOfficeId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"firstName\":\"firstNameTest\"}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validCorectEmployeeList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"officeId\":1}"))
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void validCorectEmployeeUpdate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1," +
                        "\"officeId\":2," +
                        "\"firstName\":\"firstNest\"," +
                        "\"position\":\"testPos\"}"))
                .andExpect(jsonPath("$.result").exists());
    }

    @Test
    public void validIncorectEmployeeUpdate_NoId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"officeId\":2," +
                        "\"firstName\":\"firstNest\"," +
                        "\"position\":\"testPos\"}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validIncorectEmployeeUpdate_NoOfficeId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1," +
                        "\"firstName\":\"firstNest\"," +
                        "\"position\":\"testPos\"}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validIncorectEmployeeUpdate_NoFirstName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1," +
                        "\"officeId\":2," +
                        "\"position\":\"testPos\"}"))
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    public void validIncorectEmployeeUpdate_NoPosition() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1," +
                        "\"officeId\":2," +
                        "\"firstName\":\"firstNest\"}"))
                .andExpect(jsonPath("$.error").exists());
    }
}
