package com.learn.swagger.controller;

import com.learn.swagger.model.Donor;
import com.learn.swagger.model.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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



    @PostMapping
    @ApiOperation(value = "Create a new donor", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a new donor"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<Donor> createDonor(@RequestBody Donor donor){
            //Donor savedDonor = donorRepository.save(donor);
            return new ResponseEntity<Donor>(donor, HttpStatus.OK);

    }

    @DeleteMapping(value ="/product/{id}")
    @ApiOperation(value = "Deletes specific donor with the supplied donor id")
    public void delete(@PathVariable("id") Long id){
        //TODO
    }
}
