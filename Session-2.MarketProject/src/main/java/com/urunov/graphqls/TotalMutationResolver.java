package com.urunov.graphqls;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.urunov.dataresource.CategoryResource;
import com.urunov.dataresource.ProductResource;
import com.urunov.exceptions.InvalidArgumentException;
import com.urunov.exceptions.ProductNotFoundException;
import com.urunov.graphqls.AdjustValues.AdjustProduct;
import com.urunov.input.Category;
import com.urunov.input.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Optional;


public class TotalMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private CategoryResource categoryResource;

    @Autowired
    private ProductResource productResource;

    /***          Category       */
    public Category addCategory(String name){
        //
        Category category = new Category();
        category.setName(name);

        return categoryResource.saveAndFlush(category);
    }

    /***----------------------------------*/
    public TotalMutationResolver(ProductResource productResource) {


        this.productResource = productResource;
    }

    public Product addProduct(Long category_id, String name, String slug, String image, String type, String unit, Integer price, Double salePrice, Double disc_in_pros, String per_unit, Integer quantity, Date creation_date) {

        Category category = categoryResource.findById(category_id).orElseThrow(null);

        Product product = new Product();

        product.setProduct_id(category_id);
        product.setName(name);
        product.setSlug(slug);
        product.setImage(image);
        product.setType(type);
        product.setUnit(unit);
        product.setPrice(price);
        product.setSalePrice(salePrice);
        product.setDisc_in_pros(product.getDisc_in_pros());
        product.setPer_unit(product.getPer_unit());
        product.setQuantity(product.getQuantity());
        product.setDescription(product.getDescription());
        product.setCreation_date(product.getCreation_date());

        return productResource.saveAndFlush(product);
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



    public Boolean deleteCategory(Long id){
        categoryResource.deleteById(id);
        return true;
    }

    public boolean deleteProduct(Long id) {
        productResource.deleteById(id);
        return true;
    }

}
