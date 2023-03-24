package com.cinar.okan.service.impl;

import com.cinar.okan.entity.User;
import com.cinar.okan.repository.UserRepository;
import com.cinar.okan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    public Page<User> getAllByLimit(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }



    @Override
    public List<User> getUser() {
        return null;
    }

    @Override
    public User getUser(Long id) {

        // böyle bir kullanıcı olu olmadığını kontrol ediyoruz. Optionalı ve if i o yüzden ekledik.
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    @Override
    public User updateUser(Long id, User user) {
        // böyle bir kullanıcı olu olmadığını kontrol ediyoruz. Optionalı ve if i o yüzden ekledik.
        Optional<User> resultUser = userRepository.findById(id);

        if (resultUser.isPresent()) {
            resultUser.get().setFirstName(user.getFirstName());
            resultUser.get().setLastName(user.getLastName());
            return userRepository.save(resultUser.get());
        } else {
            return null;
        }
    }

    @Override
    public Boolean deleteUser(Long id) {
        // böyle bir kullanıcı olu olmadığını kontrol ediyoruz. Optionalı ve if i o yüzden ekledik.
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.deleteById((id));
            return true;
        } else {
            return false;
        }
    }
}
