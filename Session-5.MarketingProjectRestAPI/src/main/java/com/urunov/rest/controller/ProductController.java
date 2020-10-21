package com.urunov.rest.controller;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Product;
import com.urunov.rest.repository.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductResource productResource;

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productResource.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable (value = "id") Long productId) throws ResourceNotFoundException {

        Product product = productResource.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found for this"+ productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/product")
    public Product createProduct(@Valid @RequestBody Product product){
        return productResource.save(product);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
                                                 @Valid @RequestBody Product productDetails) throws ResourceNotFoundException{
        //
        Product product = productResource.findById(productId).orElseThrow(()-> new ResolutionException("Product not found for this" + productId));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setImage(productDetails.getImage());
        product.setPer_unit(productDetails.getPer_unit());
        product.setQuantity(productDetails.getQuantity());
        product.setDisc_in_pros(productDetails.getDisc_in_pros());
        product.setPrice(productDetails.getPrice());
        product.setSalePrice(productDetails.getSalePrice());

        final Product updateProduct = productResource.save(product);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/product/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException{


        Product product = productResource.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found for this id::" + productId));

        productResource.delete(product);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
