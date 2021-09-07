package com.example.demoapp.employees;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.employees
 * @contact nattawat.k@kbtg.tech
 * @date 9/7/2021 9:26 AM
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByIdAndName(int id, String name);

}
