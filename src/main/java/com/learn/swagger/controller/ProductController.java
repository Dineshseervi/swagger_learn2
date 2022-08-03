package com.learn.swagger.controller;

import com.learn.swagger.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.learn.swagger.service.IProductService;

import java.util.List;

/*
* https://stackoverflow.com/questions/40241843/failed-to-start-bean-documentationpluginsbootstrapper-in-spring-data-rest
*
* http://localhost:8080/swagger-ui/
*
* http://localhost:8080/v2/api-docs
*
* http://localhost:8080/product
* 
* */
@RestController
public class ProductController {


    @Autowired
    private IProductService productService;

    @GetMapping(value = "/product" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProduct()
    {
//finds all the products
        List<Product> products = productService.getProductList();
//returns the product list
        return products;
    }

    @PostMapping(value = "/product",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
    }
}
