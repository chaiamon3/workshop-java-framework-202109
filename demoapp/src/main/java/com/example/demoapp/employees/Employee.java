package com.example.demoapp.employees;

import lombok.Data;

import javax.persistence.*;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.employees
 * @contact nattawat.k@kbtg.tech
 * @date 9/7/2021 9:29 AM
 */
@Entity
@Data
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

}
