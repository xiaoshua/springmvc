package com.jiuyan.dao;

import com.jiuyan.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaoshua on 2014/11/18.
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
    public List<User> getAll() {
        return sqlSession.selectList("user.getAll");
    }

    public List<User> getById(Long id) {
        return sqlSession.selectList("user.getById", id);
    }

    public void update(User user) {
        sqlSession.update("user.update", user);
    }

    public List<User> getByName(String name) {
        return sqlSession.selectList("user.getByName", name);
    }

    public int create(User user) {
        return sqlSession.insert("user.insert", user);
    }

    public void delete(Long id) {
        sqlSession.delete("user.delete", id);
    }
}
