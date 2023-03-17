package com.cinar.okan.Service;



import com.cinar.okan.Entity.User;
import com.cinar.okan.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<User> getAllEmployeesByLimit(int limit) {
        Pageable pageable = PageRequest.of(0, limit, Sort.Direction.ASC, "id");
        Page<User> results = userRepository.findAll(pageable);
        return results.stream().toList();
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
