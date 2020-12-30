package com.example.api.datacache;

import com.example.api.entities.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheStoreBeans {

    //Create Instance of LoadingCache for EmployeeService with Retention Period as 120 Seconds
    @Bean
    public LoadingCacheStore<Employee> employeeLoadingCache(ICacheLoaderService<Employee> employeeService) {
        return new LoadingCacheStore<>(120, TimeUnit.SECONDS, employeeService);
    }

    //Create Instance of LoadingCache for ProductService (fetching only productName string) Retention Period as 300 Seconds
    @Bean
    public LoadingCacheStore<String> productNameLoadingCache(ICacheLoaderService<String> productService) {
        return new LoadingCacheStore<>(300, TimeUnit.SECONDS, productService);
    }
}
