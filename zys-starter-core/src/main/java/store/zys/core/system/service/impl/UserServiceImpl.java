package store.zys.core.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.zys.core.system.dto.User;
import store.zys.core.system.mapper.UserMapper;
import store.zys.core.system.service.UserService;
import tk.mybatis.mapper.entity.Example;


import java.util.List;

/**
 * @Author: zengyusheng
 * @Date: 2019/9/24 16:28
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired

    private UserMapper userMapper;


    @Override
    @Transactional
    @CachePut(value = "user",key = "#record.userId")
    public User insert(User record) {

        System.out.println(record);
        int i = userMapper.insertSelective(record);
        if (i <= 0) {
            return null;
        }
        System.out.println(i);
        return record;
    }

    @Override
    public List<User> insert(List<User> recordList) {
        return null;
    }

    @Override
    public User insertSelective(User record) {
        return null;
    }

    @Override
    public List<User> insertSelective(List<User> recordList) {
        return null;
    }

    @Override
    @Transactional
    @CachePut(value = "user",key = "#record.userId")
    public User update(User record) {
        int i = userMapper.updateByPrimaryKeySelective(record);
        if (i <= 0) {
            return null;
        }
        System.out.println(i);
        return record;


    }

    @Override
    public List<User> update(List<User> recordList) {
        return null;
    }

    @Override
    public User updateSelective(User record) {
        return null;
    }

    @Override
    public List<User> updateSelective(List<User> recordList) {
        return null;
    }

    @Override
    @Transactional
    @CacheEvict(value = "user",key = "#p0")
    public int delete(Long id) {
        User user = new User();
        user.setUserId(id);
        int delete = userMapper.delete(user);
        return delete;
    }

    @Override
    public int delete(Long[] ids) {
        return 0;
    }

    @Override
    public int delete(User record) {
        return 0;
    }

    @Override
    public int delete(List<User> recordList) {
        return 0;
    }

    @Override
    public User persist(User record) {
        return null;
    }

    @Override
    public List<User> persist(List<User> recordList) {
        return null;
    }

    @Override
    public User persistSelective(User record) {
        return null;
    }

    @Override
    public List<User> persistSelective(List<User> recordList) {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User get(User record) {
        return null;
    }

    @Override
    public User get(String key, Object value) {
        return null;
    }

    @Override
    public List<User> select(String ids) {
        return null;
    }

    @Override
    public List<User> select(User record) {
        return null;
    }

    @Override
    public List<User> select(String key, Object value) {
        return null;
    }

    @Override
    public List<User> select(User record, int pageNum, int pageSize) {
        return null;
    }

    @Override
    @Cacheable(value = "user")
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override


    public int count(User record) {
        return 0;
    }
}
