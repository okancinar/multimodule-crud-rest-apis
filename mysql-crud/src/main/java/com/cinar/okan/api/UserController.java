package com.cinar.okan.api;


import com.cinar.okan.entity.User;
import com.cinar.okan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // post metodu public tanımladık çünkü dışarı açıcaz.4
    // dönüş tipini ise springden gelen resposeentity yapıyoruz. böylece metodlarımıza ortak bir imza yeteneği kazandırmış oluyoruz.

    @PostMapping("/create") //Path verdik.
    //RequestBody anotasyonuyla json nesnemizi user classlamızda eşleştirmeyi sağlıyoruz.
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {

        User user = userService.getUser(id); // servicedeki dönen değeri user nesnesinde tutalım.
        return ResponseEntity.ok(user); //Responseentitty içerisinde nesnemizi gönderiyoruz.
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){ // id parametresiyle kaydı kontrol edeceiz eğer varsa yeni kaydı user nesnesine atacağız.
        User resultUser = userService.updateUser(id,user);
        return ResponseEntity.ok(resultUser);
        //Buraya kadar yazıp service katmanımızda bu metodu oluşturuyoruz.
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {
        //ResponseEntity içine boolean değer yazdık eğer kayıt başarılı silinirse true, silinmezse false dönecek.
        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }
}
