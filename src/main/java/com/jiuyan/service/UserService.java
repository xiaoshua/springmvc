package com.jiuyan.service;

import com.jiuyan.model.User;

import java.util.List;

/**
 * Created by xiaoshua on 2014/11/18.
 */
public interface UserService {
    public List<User> getAll();

    public User getById(Long id);

    public void update(User user);

    public void delete(Long id);

    public int create(User user);

    public User getByName(String name);
}
