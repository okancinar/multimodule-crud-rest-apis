package com.cinar.okan.Repository;

import com.cinar.okan.Entity.User;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository

public class UserRepository {


    private final Map<Long, User> users;

    public UserRepository(HazelcastInstance hazelcastInstance) {

        this.users = hazelcastInstance.getMap("users");
    }

    public User save(User user) {
        users.putIfAbsent(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        return users.get(id);
    }


    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User deleteUser(Long id) {return users.remove(id);}

    public User updateUser(Long id, User user) {users.put(id, user); return user;}

    public List<User> findAllByLimit(int limit) {
        return new ArrayList<>(users.values().stream().limit(limit).toList());
    }

}
