package com.cinar.okan;

import com.cinar.okan.Repository.UserDao;
import com.cinar.okan.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
@RestController
@RequestMapping("/user")
public class SpringBootRestApiApplication {



	
	@Autowired
	private UserDao dao;

	@PostMapping("/create")
	public User save(@RequestBody User user) {

		return dao.save(user);
	}

	@GetMapping("getAll")
	public List<User> getAllProducts() {

		return dao.findAll();
	}

	@GetMapping("/getById/{id}")
	public User findProduct(@PathVariable Long id) {

		return dao.findUserById(id);
	}
	@DeleteMapping("/remove/{id}")
	public Boolean remove(@PathVariable Long id)   {

		return dao.deleteUser(id);
	}


	public static void main(String[] args) {

		SpringApplication.run(SpringBootRestApiApplication.class, args);
	}
}
