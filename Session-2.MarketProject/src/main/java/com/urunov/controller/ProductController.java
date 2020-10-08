package com.urunov.controller;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.urunov.dataresource.ProductResource;
import com.urunov.input.Product;

public class ProductController implements GraphQLResolver<Product> {

    private ProductResource productResource;

    public ProductController(ProductResource productResource) {
        this.productResource = productResource;
    }


}
