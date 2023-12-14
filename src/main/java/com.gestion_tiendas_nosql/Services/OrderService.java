package com.gestion_tiendas_nosql.Services;

import com.gestion_tiendas_nosql.DTOs.OrderDTO;
import com.gestion_tiendas_nosql.Exceptions.OrderNotFoundException;
import com.gestion_tiendas_nosql.Entities.Order;
import com.gestion_tiendas_nosql.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders(){ return orderRepository.findAll(); }

    public Order getOrderById(String id){
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            return order.get();
        }else{
            throw new OrderNotFoundException(id);
        }
    }

    public Order createOrder(OrderDTO orderDTO){
        Order order = Order
                .builder()
                .orderDate(orderDTO.getOrderDate())
                .client(orderDTO.getClient())
                .deliveryAddress(orderDTO.getDeliveryAddress())
                .status(orderDTO.getStatus())
                .store(orderDTO.getStore())
                .products(orderDTO.getProducts())
                .build();

        return orderRepository.save(order);
    }

    public Order updateOrder(String id, OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            existingOrder.setOrderDate(orderDTO.getOrderDate());
            existingOrder.setClient(orderDTO.getClient());
            existingOrder.setStatus(orderDTO.getStatus());
            existingOrder.setProducts(orderDTO.getProducts());
            existingOrder.setStore(orderDTO.getStore());
            existingOrder.setDeliveryAddress(orderDTO.getDeliveryAddress());
            return orderRepository.save(existingOrder);
        } else {
            throw new OrderNotFoundException(id);
        }
    }

    public boolean deleteOrder(String id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        } else {
            throw new OrderNotFoundException(id);
        }
    }
}
