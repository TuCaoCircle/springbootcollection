package com.message.mycache.controller;

import com.message.mycache.bean.Employee;
import com.message.mycache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        return employeeService.getEmp(id);
    }

    @PutMapping("/emp")
    public Employee updateEmployee(Employee employee){
        System.out.println(employee);
        return employeeService.updateEmp(employee);
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmp(id);
        return "shanchu";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmployeeByLastName(@PathVariable("lastName") String lastName){
        return  employeeService.getByLastName(lastName);
    }

}
