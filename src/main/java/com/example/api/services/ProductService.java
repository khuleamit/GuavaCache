package com.example.api.services;

import com.example.api.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product getProductByID(String id)
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

        //Return dummy Product record
        return new Product(id,"Product Name " + id , "$10.00");
    }

}
