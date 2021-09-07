package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.employees
 * @contact nattawat.k@kbtg.tech
 * @date 9/7/2021 2:15 PM
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void success_case() {
        // Arrange
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Nattawat");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        // Act
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        EmployeeResponse result = employeeService.getById(1);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("Nattawat", result.getName());
    }

    @Test
    public void employee_not_found_case() {
        // Arrange
        int id = 1;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        // Act
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        try {
            employeeService.getById(1);
            fail();
        } catch (EmployeeNotFoundException ex) {
            // Pass
            if (!"Employee not found id=1".equals(ex.getMessage()))
                fail("Message fail with=" + ex.getMessage());
        }
    }

    @Test
    public void employee_not_found_case_with_junit5() {
        // Arrange
        int id = 1;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        // Act
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> employeeService.getById(1));
        assertEquals("Employee not found id=1", exception.getMessage());
    }

}
