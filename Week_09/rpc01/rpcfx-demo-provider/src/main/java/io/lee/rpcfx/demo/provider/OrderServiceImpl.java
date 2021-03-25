package io.lee.rpcfx.demo.provider;

import io.lee.rpcfx.demo.api.Order;
import io.lee.rpcfx.demo.api.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }
}
