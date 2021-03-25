package io.lee.rpcfx.demo.provider;

import io.lee.rpcfx.demo.api.User;
import io.lee.rpcfx.demo.api.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
