package com.urunov.rest.controller;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Orders;
import com.urunov.rest.repository.OrdersResource;
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
public class OrdersController {

    @Autowired
    private OrdersResource ordersResource;

    @GetMapping("/orders")
    public List<Orders> getAllOrders(){
        return ordersResource.findAll();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable(value = "id") Long orderId) throws ResourceNotFoundException {

        Orders orders = ordersResource.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found for this"+ orderId));
        return ResponseEntity.ok().body(orders);
    }

    @PostMapping("/orders")
    public Orders createOrders(@Valid @RequestBody Orders orders){
        return ordersResource.save(orders);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Orders> updateProduct(@PathVariable(value = "id") Long orderId,
                                                 @Valid @RequestBody Orders ordersDetails) throws ResourceNotFoundException{
        //
        Orders orders = ordersResource.findById(orderId).orElseThrow(()-> new ResolutionException("Order not found for this" + orderId));

        orders.setContactNumber(ordersDetails.getContactNumber());
        orders.setAmount(ordersDetails.getAmount());
        orders.setDeliveryAddress(ordersDetails.getDeliveryAddress());
        orders.setDeliveryFee(ordersDetails.getDeliveryFee());
        orders.setPaymentMethod(ordersDetails.getPaymentMethod());
        orders.setDescription(ordersDetails.getDescription());
        orders.setProducts(ordersDetails.getProducts());
        orders.setDiscount(ordersDetails.getDiscount());
        orders.setStatus(ordersDetails.getStatus());


        final Orders updateOrders = ordersResource.save(orders);
        return ResponseEntity.ok(updateOrders);
    }

    @DeleteMapping("/orders/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long orderId) throws ResourceNotFoundException{


        Orders orders = ordersResource.findById(orderId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id::" + orderId));

        ordersResource.delete(orders);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
