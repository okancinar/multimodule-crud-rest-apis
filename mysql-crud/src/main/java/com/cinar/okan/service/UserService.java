package com.cinar.okan.service;
import com.cinar.okan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;




public interface UserService {
    User createUser(User user); // service katmanına bu metodu yazarken public abstract yazmaya gerek yok ama bu kısmı tam anlamadım.
    List<User> getUsers();
    Page<User> getAllByLimit(int page, int limit);

    List<User> getUser();
    User getUser(Long id);

    User updateUser(Long id, User user);

    Boolean deleteUser(Long id);

}
