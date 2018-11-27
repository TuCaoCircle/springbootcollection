package com.message.mycache;

import com.message.mycache.bean.Employee;
import com.message.mycache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MycacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);

    }

}
