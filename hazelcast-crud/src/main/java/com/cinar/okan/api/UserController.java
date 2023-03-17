package com.cinar.okan.api;



import com.cinar.okan.Entity.User;
import com.cinar.okan.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/create") //Path verdik.

    public ResponseEntity<User> createUser(@RequestBody User user) {
        User resultUser = userService.save(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {

        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllByLimit/{limit}")
    public ResponseEntity<List<User>> getAllByLimit(@PathVariable int limit) {
        List<User> users = userService.findAllByLimit(limit);
        return ResponseEntity.ok(users);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){ // id parametresiyle kaydı kontrol edeceiz eğer varsa yeni kaydı user nesnesine atacağız.
        User resultUser = userService.update(id, user);

        return ResponseEntity.ok(resultUser);
        //Buraya kadar yazıp service katmanımızda bu metodu oluşturuyoruz.
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {

        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }
}
