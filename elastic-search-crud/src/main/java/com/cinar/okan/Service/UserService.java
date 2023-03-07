package com.cinar.okan.Service;



import com.cinar.okan.Entity.User;
import com.cinar.okan.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllEmployees() {
        List<User> employees = new ArrayList<>();
        userRepository.findAll().forEach(employees::add);
        return employees;
    }

    public User getEmployeeById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addEmployee(User employee) {
       return userRepository.save(employee);
    }

    public void updateEmployee(Long id, User employee) {
        employee.setId(id);
        userRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        userRepository.deleteById(id);
    }

}
