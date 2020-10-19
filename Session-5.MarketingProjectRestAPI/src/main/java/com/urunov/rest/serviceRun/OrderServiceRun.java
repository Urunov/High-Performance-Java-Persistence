package com.urunov.rest.serviceRun;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Orders;
import com.urunov.rest.repository.OrdersResource;
import com.urunov.rest.service.OrderService;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderServiceRun implements OrderService {

    private OrdersResource ordersResource;

    @Override
    public Optional<Orders> getOrderById(Long orderId) {
        return ordersResource.findById(orderId);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersResource.findAll();
    }

    @Override
    public void addOrder(Order order, long id) {

    }

    @Override
    public Order updateOrder(long id, Order orderDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Map<String, Boolean> deleteOrderById(long id) throws ResourceNotFoundException {
        return null;
    }
}
