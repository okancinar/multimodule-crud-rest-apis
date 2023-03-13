package com.cinar.okan.api;


import com.cinar.okan.Entity.User;
import com.cinar.okan.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")

public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }


    @PostMapping("/create") //Path verdik.

    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.addEmployee(user), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<List<User>>(userService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {

        return new ResponseEntity<User>(userService.getEmployeeById(id), HttpStatus.OK);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){ // id parametresiyle kaydı kontrol edeceiz eğer varsa yeni kaydı user nesnesine atacağız.
        userService.updateEmployee(id , user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
        //Buraya kadar yazıp service katmanımızda bu metodu oluşturuyoruz.
    }


    @DeleteMapping("/remove/{id}")
    public void deleteById(@PathVariable Long id) {

        userService.deleteEmployee(id);
    }
}
