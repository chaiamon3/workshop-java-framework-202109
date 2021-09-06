package com.example.demoapp.employees;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.employees
 * @contact nattawat.k@kbtg.tech
 * @date 9/6/2021 4:15 PM
 */
@WebMvcTest(EmployeeController.class)
class EmployeeControllerWebMvcTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    EmployeeService employeeService;

    @Test
    void success_getEmployeeById() throws Exception {
        int id = 100;
        // Arrange
        EmployeeResponse mockResponse = new EmployeeResponse();
        mockResponse.setId(100);
        mockResponse.setName("Mock name");
        when(employeeService.getById(100)).thenReturn(mockResponse);
        // Act
        MvcResult result = mvc.perform(get("/employees/" + id))
                .andExpect(status().isOk())
                .andReturn();
        // Response body
        byte[] json = result.getResponse().getContentAsByteArray();
        ObjectMapper mapper = new ObjectMapper();
        EmployeeResponse response = mapper.readValue(json, EmployeeResponse.class);
        assertEquals(id, response.getId());
        assertEquals("Mock name", response.getName());
    }

}
