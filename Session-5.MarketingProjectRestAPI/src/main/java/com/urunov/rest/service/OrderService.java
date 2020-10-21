package com.urunov.rest.service;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Orders;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderService {



   Optional<Orders> getOrdersById(Long orderId);

   List<Orders> getAllOrders();

   void addOrders(Orders order, long id);
   Orders updateOrders(long id, Orders ordersDetails) throws ResourceNotFoundException;
   Map<String, Boolean> deleteOrdersById(long id) throws ResourceNotFoundException;


}
