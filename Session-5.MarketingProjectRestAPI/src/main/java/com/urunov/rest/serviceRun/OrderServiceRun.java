package com.urunov.rest.serviceRun;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Orders;
import com.urunov.rest.repository.OrdersResource;
import com.urunov.rest.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderServiceRun implements OrderService {

    private OrdersResource ordersResource;

    @Override
    public Optional<Orders> getOrdersById(Long orderId) {
        return ordersResource.findById(orderId);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersResource.findAll();
    }

    @Override
    public void addOrders(Orders order, long id) {

    }


    @Override
    public Orders updateOrders(long id, Orders orderDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Map<String, Boolean> deleteOrdersById(long id) throws ResourceNotFoundException {
        return null;
    }
}
