package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@Import(EmployeeRepository.class)
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("ค้นหาข้อมูลสำเร็จ id = 1")
    void case01() {
        // Arrange
        Employee employee = new Employee();
        employee.setName("Mock name");
        employeeRepository.save(employee);
        // Act
        Optional<Employee> result = employeeRepository.findById(1);
        // Assert
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals("Mock name", result.get().getName());
    }

    @Test
    @DisplayName("ค้นหาข้อมูล employee id = 1 ไม่เจอ")
    void case02() {
        // Arrange
        Employee employee = new Employee();
        employee.setName("Mock name");
        employeeRepository.save(employee);
        // Act
        Optional<Employee> result = employeeRepository.findById(1);
        // Assert
        assertFalse(result.isPresent());
    }

}