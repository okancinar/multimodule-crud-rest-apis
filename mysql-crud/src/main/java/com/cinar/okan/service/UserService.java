package com.cinar.okan.service;
import com.cinar.okan.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user); // service katmanına bu metodu yazarken public abstract yazmaya gerek yok ama bu kısmı tam anlamadım.
    List<User> getUsers();
    User getUser(Long id);

    User updateUser(Long id, User user);

    Boolean deleteUser(Long id);










}
