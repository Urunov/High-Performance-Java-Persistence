package com.urunov.rest.serviceRun;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Product;
import com.urunov.rest.repository.ProductResource;
import com.urunov.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceRun implements ProductService {
    //
    @Autowired
    private ProductResource productResource;


    @Override
    public List<Product> AllProducts() {
        return productResource.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long productId){

        return productResource.findById(productId);
    }

    @Override
    public void addProduct(Product product, long id) {

        Optional<Product> optionalProduct = productResource.findById(id);

        if(optionalProduct.isPresent()){
            throw new RuntimeException("Product already in the Database: " + id);
        }else{
            this.productResource.save(product);
        }
    }


    @Override
    public Map<String, Boolean> deleteProductById(long id) throws ResourceNotFoundException{

        Product product = productResource.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found id:" + id));

        productResource.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

    @Override
    public Product updateProduct(long id, Product productDetails) throws ResourceNotFoundException{

        Product product1 = productResource.findById(id)
                .orElseThrow(()-> new ResolutionException("Product not found id::" + id));

        product1.setName(productDetails.getName());
        product1.setCode(productDetails.getCode());
        product1.setImage(productDetails.getImage());
        product1.setDisc_in_pros(productDetails.getDisc_in_pros());
        product1.setPer_unit(productDetails.getPer_unit());
        product1.setPrice(productDetails.getPrice());
        product1.setQuantity(productDetails.getQuantity());
        product1.setDescription(productDetails.getDescription());

        final Product updateProduct = productResource.save(product1);
        return updateProduct;
    }
}
