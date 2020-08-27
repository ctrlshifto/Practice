package com.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019-3-17 15:15:17
 * @Modified by:
 */
@Data
@AllArgsConstructor
public class Employee {

    private String name;
    private int salary;
    private String office;

    /**
     * 雇员的家庭成员名字
     */
    private List<String> familyName;
}