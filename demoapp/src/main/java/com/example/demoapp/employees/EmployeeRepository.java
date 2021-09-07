package com.example.demoapp.employees;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.employees
 * @contact nattawat.k@kbtg.tech
 * @date 9/7/2021 9:26 AM
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
