package io.lee.rpcfx.demo.consumer.service;

import io.lee.rpcfx.annotation.Service;
import io.lee.rpcfx.demo.api.Order;
import io.lee.rpcfx.demo.api.OrderService;
import io.lee.rpcfx.demo.api.User;
import io.lee.rpcfx.demo.api.UserService;

/**
 * @author Leeyj
 * @date 2021/3/25 22:06
 */
public class ClientServiceImpl {

    @Service(hostUrl = "http://localhost:8081/")
    private UserService userService;
    @Service(hostUrl = "http://localhost:8081/")
    private OrderService orderService;


    public void getUser() {
        User user = userService.findById(1);
        System.out.println("find user id=1 from server: " + user.getName());

        Order order = orderService.findOrderById(199510);
        System.out.println(String.format("find order name=%s, amount=%f", order.getName(), order.getAmount()));
    }
}
