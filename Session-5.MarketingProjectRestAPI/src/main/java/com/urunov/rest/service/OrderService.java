package com.urunov.rest.service;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Orders;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderService {



   Optional<Orders> getOrderById(Long orderId);

   List<Orders> getAllOrders();

   void addOrder(Order order, long id);
   Order updateOrder(long id, Order orderDetails) throws ResourceNotFoundException;
   Map<String, Boolean> deleteOrderById(long id) throws ResourceNotFoundException;


}
