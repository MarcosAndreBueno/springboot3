package com.marcosweb.mywebproject.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosweb.mywebproject.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	//testar se aplicação já consegue retornar objeto criado em localhost:8080/users
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}