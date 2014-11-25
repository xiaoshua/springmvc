package com.jiuyan.service;

import com.jiuyan.dao.UserDao;
import com.jiuyan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaoshua on 2014/11/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAll() {
        List<User> userList = userDao.getAll();
        return userList;
    }

    public User getById(Long id) {
        List<User> userList = userDao.getById(id);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(Long id) {
        userDao.delete(id);
    }

    public int create(User user) {
        return userDao.create(user);
    }

    public User getByName(String name) {
        List<User> userList = userDao.getByName(name);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }
}
