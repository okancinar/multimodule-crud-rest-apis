package com.cinar.okan.Service;

import com.cinar.okan.Entity.User;
import com.cinar.okan.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        user.setId(id);
        return userRepository.updateUser(id, user);
    }


    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Boolean deleteUser(Long id) {
        return userRepository.findAll().remove(id);
    }

}
