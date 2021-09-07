package com.example.demoapp.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    EmployeeRepository employeeRepository;

//    @BeforeEach
//    void initialDataForTest() {
//        Employee employee = new Employee();
//        employee.setName("Nattawat");
//        employeeRepository.save(employee);
//    }

    @AfterEach
    void deleteDataForTest() {
        employeeRepository.deleteAll();
    }

    @Test
    void listEmployee() {
       // Act
        EmployeeResponse[] results = testRestTemplate.getForObject("/employees", EmployeeResponse[].class);
        // Assert
        assertEquals(2, results.length);
        assertEquals(1, results[0].getId());
        assertEquals("Nattawat", results[0].getName());
    }

    @Test
    void getEmployeeById() {
        // Arrange
        int id = 1;
        Employee employee = new Employee();
        employee.setName("Nattawat");
        employeeRepository.save(employee);
        // Act
        EmployeeResponse result = testRestTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
        // Assert
        assertEquals(id, result.getId());
        assertEquals("Nattawat", result.getName());
    }

}