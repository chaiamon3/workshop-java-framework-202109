package com.example.demoapp.employees;

import org.springframework.stereotype.Service;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.employees
 * @contact nattawat.k@kbtg.tech
 * @date 9/6/2021 4:41 PM
 */
@Service
public class EmployeeService {

    public EmployeeResponse getById(int id) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(id);
        employeeResponse.setName("Nattawat");
        return employeeResponse;
    }

}
