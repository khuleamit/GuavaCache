package com.example.api.controller;

import com.example.api.datacache.LoadingCacheStore;
import com.example.api.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class ApiController {

    @Autowired
    LoadingCacheStore<Employee> employeeLoadingCache;

    @Autowired
    LoadingCacheStore<String> productNameLoadingCache;

    @GetMapping("/employee/{id}")
    public Employee searchEmployeeByID(@PathVariable String id) {
        System.out.println("Searching Employee by ID  : " + id);

        try {

            //Search Employee record in LoadingCache
            //LoadingCache will in turn fetch from backend service if record is not already present in Cache
            Employee empRecord = employeeLoadingCache.get(id);

            System.out.println("Employee record returned by "
                    + employeeLoadingCache.getClass().getSimpleName()
                    + " : " + empRecord.getName());

            return empRecord;

        } catch (ExecutionException e) {
            return null;
        }

    }

    @GetMapping("/product/{id}")
    public String searchProductNameByID(@PathVariable String id) {
        System.out.println("Searching Product Name by ID  : " + id);

        //Search Product Name in LoadingCache
        //LoadingCache will in turn fetch from backend service if record is not already present in Cache
        try {

            //Search Product Name in Cache
            String productName = productNameLoadingCache.get(id);

            System.out.println("Product name returned by Loadingcache : "
                    + productNameLoadingCache.getClass().getSimpleName()
                    + " : " + productName);

            return productName;

        } catch (ExecutionException e) {
            return null;
        }
    }

}
