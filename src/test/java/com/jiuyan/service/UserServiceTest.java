package com.jiuyan.service;

import com.jiuyan.base.BaseTest;
import com.jiuyan.model.User;
import junit.framework.Assert;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by xiaoshua on 2014/11/18.
 */


public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreate() {
        //create
        User user = new User();
        user.setName("CC");
        user.setPassWord("CC_PWD");
        int ret = userService.create(user);
        Assert.assertEquals(ret, 1);
    }

    @Test
    public void testRetrieve() {
        //Retrieve
        User user = userService.getById(1L);
        Assert.assertNotNull(user);
        System.out.println(ToStringBuilder.reflectionToString(user));
    }

    @Test
    public void testUpdate() {
        //update
        User user = userService.getById(1L);
        //name
        Assert.assertEquals(user.getName(), "Bob");

        System.out.println(ToStringBuilder.reflectionToString(user));
        user.setName("Alice");
        userService.update(user);
        User newUser = userService.getById(1L);
        Assert.assertEquals(newUser.getName(), "Alice");
        System.out.println(ToStringBuilder.reflectionToString(newUser));
    }

    @Test
    public void testDelete() {

        //delete
        User user = null;
        userService.delete(1L);
        user = userService.getById(1L);
        Assert.assertNull(user);
        System.out.println(ToStringBuilder.reflectionToString(user));
    }

    @Test
    public void testGetAll() {
        //getAll
        List<User> userList = userService.getAll();
        System.out.println("~~~~~~~~~~~~~");
        for (User u : userList) {
            System.out.println(ToStringBuilder.reflectionToString(u));
        }
    }

    @Test
    public void testGetByName() {
        User user = userService.getByName("Bob");
        Assert.assertNotNull(user);
        System.out.println(ToStringBuilder.reflectionToString(user));
    }
}
