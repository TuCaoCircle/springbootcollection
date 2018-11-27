package com.message.mycache.service;


import com.message.mycache.bean.Employee;
import com.message.mycache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;


@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    @Cacheable
    public Employee getEmp(int id ){
        System.out.println("查询id:"+id);
        Employee employee = employeeMapper.getEmpById(id);
        return  employee;
    }


    @CachePut(key = "#employee.id")
    public Employee updateEmp(Employee employee){
        System.out.println("Update"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }


    //allEntries 删除所有的缓存 默认false beforeInvocation 在方法执行后删除 默认false
    @CacheEvict(key = "#id" , allEntries = true)
    public void deleteEmp(int id){
     System.out.println("delete :" +id);
     //employeeMapper.deleteEmpById(id);

    }


    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp", key = "#result.id"),
                    @CachePut(value = "emp", key = "#result.email")
            }
    )
    public Employee getByLastName(String lastName){
       return employeeMapper.getEmpByLastName(lastName);
    }




}
