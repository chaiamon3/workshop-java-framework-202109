package com.example.demoapp.employees;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.employees
 * @contact nattawat.k@kbtg.tech
 * @date 9/7/2021 11:28 AM
 */
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private int code;
    private String detail;

}
