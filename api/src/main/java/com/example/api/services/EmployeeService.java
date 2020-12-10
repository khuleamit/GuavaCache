package com.example.api.services;

import com.example.api.entities.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    public Employee getEmployeeByID(String id)
    {
        try
        {
            //Simulate backend service by forcing thread to sleep
            System.out.println("Going to sleep for 5 Secs... to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Return dummy Employee record
        return new Employee(id,"Employee Name " + id ,"Engineer");
    }
}
