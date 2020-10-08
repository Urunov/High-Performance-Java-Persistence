package com.urunov.graphqls;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.urunov.dataresource.ProductResource;
import com.urunov.exceptions.InvalidArgumentException;
import com.urunov.exceptions.ProductNotFoundException;
import com.urunov.graphqls.AdjustValues.AdjustProduct;
import com.urunov.input.Product;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ProductMutation implements GraphQLMutationResolver {

    private ProductResource productResource;

    public ProductMutation(ProductResource productResource) {
        this.productResource = productResource;
    }

    public Product addProduct() {

        Product product = new Product();

        product.setName(product.getName());
        product.setSlug(product.getSlug());
        product.setImage(product.getImage());
        product.setType(product.getType());
        product.setUnit(product.getUnit());
        product.setPrice(product.getPrice());
        product.setSalePrice(product.getSalePrice());
        product.setDisc_in_pros(product.getDisc_in_pros());
        product.setPer_unit(product.getPer_unit());
        product.setQuantity(product.getQuantity());
        product.setDescription(product.getDescription());
        product.setCreation_date(product.getCreation_date());

        return productResource.save(product);
    }

    public boolean deleteProduct(Long id) {
        productResource.deleteById(id);
        return true;
    }

    public Product updateProduct(AdjustProduct adjustProduct){

       Product product = productResource.findById(adjustProduct.getProduct_id())
               .orElseThrow(()-> new ProductNotFoundException("The product to be updated was found", adjustProduct.getProduct_id()));

       Optional.ofNullable(adjustProduct.getName())
               .orElseThrow(()-> new InvalidArgumentException("Name cannot be null, fill in please.", adjustProduct.getName()));

        Optional.ofNullable(adjustProduct.getSlug())
                .orElseThrow(()-> new InvalidArgumentException("Slug cannot be null, fill in please.", adjustProduct.getSlug()));

        Optional.ofNullable(adjustProduct.getType())
                .orElseThrow(()-> new InvalidArgumentException("Type cannot be null, fill in please.", adjustProduct.getType()));

        Optional.ofNullable(adjustProduct.getUnit())
                .orElseThrow(()-> new InvalidArgumentException("Name cannot be null, fill in please.", adjustProduct.getUnit()));

        Optional.ofNullable(adjustProduct.getImage())
                .orElseThrow(()-> new InvalidArgumentException("Image cannot be null, fill in please.", adjustProduct.getImage()));

        Optional.ofNullable(adjustProduct.getDescription())
                .orElseThrow(()-> new InvalidArgumentException("Description cannot be null, fill in please.", adjustProduct.getDescription()));

        Optional.ofNullable(adjustProduct.getDisc_in_pros())
                .orElseThrow(()-> new InvalidArgumentException("Discount procentage cannot be null, fill in please.", adjustProduct.getDisc_in_pros()));

        Optional.ofNullable(adjustProduct.getPer_unit())
                .orElseThrow(()->new InvalidArgumentException("Price cannot be null, fill in please", adjustProduct.getPrice()));

        Optional.ofNullable(adjustProduct.getSalePrice())
                .orElseThrow(()-> new InvalidArgumentException("Sale price cannot be this, fill in please.", (int) adjustProduct.getSalePrice()));

        Optional.ofNullable(adjustProduct.getQuantity())
                .orElseThrow(()-> new InvalidArgumentException("Quantity cannot be null, fill in please.", adjustProduct.getQuantity()));

        return productResource.save(product);

    }
}
