package com.urunov.rest;

import com.urunov.rest.model.Product;
import org.junit.runner.RunWith;
 import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(){
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void getAllProduct(){
       //
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(getRootUrl() + "/ product",
                HttpMethod.GET, entity, String.class);
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void getProductById(){
        Product product = restTemplate.getForObject(getRootUrl() + "/product/1", Product.class);
        System.out.println(product.getName());

        assertNotNull(product);
    }

    @Test
    public void createProduct(){
        Product product = new Product();
        product.setName("Book CTCI, 6 th edition.");
        product.setDescription("interview book and using  possible");
        product.setQuantity(1);
        product.setCode("2323DF");
        product.setPer_unit(32);
        product.setImage("http://alo.com/by");

        ResponseEntity<Product> postResponse = restTemplate.postForEntity(getRootUrl(), "/product" + product, Product.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void updateProduct(){
        int id  = 1;

        Product product = restTemplate.getForObject(getRootUrl() + "/product/" + id, Product.class);
        product.setName("Programming Interviews Exposed");
        product.setImage("http://amazon.com/image/");
        product.setDescription("Interview Programming Book Exposed");
        restTemplate.put(getRootUrl() + "/product/" + id, product);
        Product updateProduct = restTemplate.getForObject(getRootUrl() + "/produt/" + id, Product.class);
        assertNotNull(updateProduct);
    }

    @Test
    public void deleteProductById(){
        int id = 2;
        Product product = restTemplate.getForObject(getRootUrl() + "/product/" + id, Product.class);
        assertNotNull(product);
        restTemplate.delete(getRootUrl() + "/product/" + id);

        try {
            restTemplate.getForObject(getRootUrl() + "/product/ " + id, Product.class);
        } catch (final HttpClientErrorException ec){
            assertEquals(ec.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
