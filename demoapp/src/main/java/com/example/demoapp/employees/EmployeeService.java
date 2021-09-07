package com.example.demoapp.employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.employees
 * @contact nattawat.k@kbtg.tech
 * @date 9/6/2021 4:41 PM
 */
@Service
@AllArgsConstructor
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeResponse getById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            // Map data from entity to response
            EmployeeResponse employeeResponse = new EmployeeResponse();
            Employee employee = result.get();
            employeeResponse.setId(employee.getId());
            employeeResponse.setName(employee.getName());
            return employeeResponse;
        }
        throw new EmployeeNotFoundException("Employee not found id=" + id);
    }

}
