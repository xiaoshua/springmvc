package com.jiuyan.dao;

import com.jiuyan.model.User;

import java.util.List;

/**
 * Created by xiaoshua on 2014/11/18.
 */
public interface UserDao {

    public int create(User user);

    public List<User> getAll();

    public List<User> getById(Long id);

    public void update(User user);

    public void delete(Long id);

    public List<User> getByName(String name);
}
