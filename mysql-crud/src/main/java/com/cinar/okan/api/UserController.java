package com.cinar.okan.api;


import com.cinar.okan.entity.User;
import com.cinar.okan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/create") //Path verdik.
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/getAllByLimit/{limit}")
    public ResponseEntity<List<User>> getAllByLimit(@PathVariable("limit") int limit , @RequestParam(defaultValue = "0") int page) {
        Page<User> users = userService.getAllByLimit(page, limit);
        List<User> userList = users.getContent(); // ResponseEntity<Page> yerine ResponseEntity<List> yaptık ve bu satırı ekledik. Çünkü page bilgilerini istemiyorduk.

        return ResponseEntity.ok(userList);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {

        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        User resultUser = userService.updateUser(id,user);
        return ResponseEntity.ok(resultUser);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {

        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }
}
