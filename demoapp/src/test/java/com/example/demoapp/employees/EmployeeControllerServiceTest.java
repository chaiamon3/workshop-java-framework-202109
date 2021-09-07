package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.employees
 * @contact nattawat.k@kbtg.tech
 * @date 9/7/2021 1:36 PM
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerServiceTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Success case")
    void case01() {
        // Arrange
        int id = 1;
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Nattawat");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        // Act
        EmployeeResponse result = testRestTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
        // Assert
        assertEquals(id, result.getId());
        assertEquals("Nattawat", result.getName());
    }

    @Test
    @DisplayName("Failure case :: Employee not found id = 100")
    void case02() {
        // Arrange
        int id = 100;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        // Act
        ErrorResponse result = testRestTemplate.getForObject("/employees/" + id, ErrorResponse.class);
        // Assert
        assertEquals(404, result.getCode());
        assertEquals("Employee not found id=" + id, result.getDetail());
    }

}
