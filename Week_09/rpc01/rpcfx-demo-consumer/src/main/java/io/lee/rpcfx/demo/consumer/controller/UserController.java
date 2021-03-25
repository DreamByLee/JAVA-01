package io.lee.rpcfx.demo.consumer.controller;

import io.lee.rpcfx.annotation.Service;
import io.lee.rpcfx.demo.api.Order;
import io.lee.rpcfx.demo.api.OrderService;
import io.lee.rpcfx.demo.api.User;
import io.lee.rpcfx.demo.api.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动后请求 http://localhost:8082/getUser
 * @author Leeyj
 * @date 2021/3/25 22:06
 */
@RestController
public class UserController {

    @Service(hostUrl = "http://localhost:8081/")
    private UserService userService;
    @Service(hostUrl = "http://localhost:8081/")
    private OrderService orderService;

    @RequestMapping("/getUser")
    public void getUser() {
        User user = userService.findById(1);
        System.out.println("find user id=1 from server: " + user.getName());

        Order order = orderService.findOrderById(1992129);
        System.out.println(String.format("find order name=%s, amount=%f", order.getName(), order.getAmount()));
    }
}
