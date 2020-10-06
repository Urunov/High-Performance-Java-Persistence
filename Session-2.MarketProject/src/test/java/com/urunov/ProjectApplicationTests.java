package com.urunov;

import com.urunov.dataresource.CategoryResource;
import com.urunov.dataresource.CustomerResource;
import com.urunov.dataresource.OrdersResource;
import com.urunov.dataresource.ProductResource;
import com.urunov.input.Category;
import com.urunov.input.Customer;
import com.urunov.input.Orders;
import com.urunov.input.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class ProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private ProductResource productResource;

    @Autowired
    private CategoryResource categoryResource;

    @Autowired
    private OrdersResource ordersResource;

    @Autowired
    private CustomerResource customerResource;

    @Test
    public void testRelationships() {

        Product product = new Product();
        product.setProductName("Padding-Warm");
        product.setDescription("Uzbekistan Catton ");
        product.setDisc_in_pros(43);
        product.setPrice(6);
        product.setImage("http://amazon.com/free/images/clothes/");
        product.setPer_unit(32);
        product.setSalePrice(3.53f);
        product.setQuantity(20);
        product.setType("clothes");
        product.setUnit("43");
        product.setSlug("clothes");
        productResource.save(product);


        Category category = new Category();
        category.setName("Clothes");
        category.setIcon("http://amazon.com/clothes/icons/");
        category.setSlug("padding");
        category.setType("clothe");
        category.setValue("42");
        categoryResource.save(category);

        Customer customer = new Customer();
        customer.setAddress("Seoul, Korea. Jongro-gu, ");
        customer.setEmail("myindexu@gmail.com");
        customer.setImage("amazon.com/lir/");
        customer.setTotalOrder(4);
        customer.setTotalOrderAmount(83833);
        customer.setCustom_id((long) 1);

        customerResource.save(customer);


        Orders orders = new Orders();
        orders.setAmount(2.0f);
        orders.setDescription("Booking and buy");
        orders.setDeliveryAddress("Seoul, Korea. ");
        orders.setContactNumber("010-9898-9090");
        orders.setPaymentMethod("Visa Card");
        orders.setDiscount("33");
        orders.setDeliveryFee(2.4f);
        orders.setOrder_id((long) 1);
        orders.setStatus("pending");

        ordersResource.save(orders);





        productResource.findAll();
        for(Product product1: productResource.findAll()){
           System.out.println(productResource.findAllById(Collections.singleton((Long) product1.getProduct_id())));
        }

    }

}

