package com.learn.swagger.service;

import com.learn.swagger.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getProductList();

    void addProduct(Product product);
 }
