package com.example.demoapp.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.employees
 * @contact nattawat.k@kbtg.tech
 * @date 9/6/2021 2:20 PM
 */
@RestController
public class EmployeeController {

    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable int id) {
        // Validate input
        // Cleansing data
        EmployeeResponse employee01 = new EmployeeResponse();
        employee01.setId(id);
        employee01.setName("Nattawat");
        return employee01;
    }

    @GetMapping("/employees")
    public EmployeeResponse[] listEmployee() {
        EmployeeResponse employee01 = new EmployeeResponse();
        employee01.setId(1);
        employee01.setName("Nattawat");
        EmployeeResponse employee02 = new EmployeeResponse();
        employee02.setId(2);
        employee02.setName("Nattawat 2");
        return new EmployeeResponse[]{employee01, employee02};
    }

}
