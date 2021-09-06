package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void listEmployee() {
        // Act
        EmployeeResponse[] results = testRestTemplate.getForObject("/employees", EmployeeResponse[].class);
        // Assert
        assertEquals(2, results.length);
        assertEquals(1, results[0].getId());
        assertEquals("Nattawat", results[0].getName());
    }

}