package com.marcosweb.mywebproject.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosweb.mywebproject.entities.User;
import com.marcosweb.mywebproject.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//classe da camada controladora (lembrando que a aplicação ta dividida em: front/controladores/serviços/banco de dados)
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	//enviar para a camada de serviço, que contém as regras de negócios, o pedido
	//autowired faz injeção de dependência
	@Autowired 
	private UserService service;

	//testar no postman localhost:8080/users
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	//testar no postman localhost:8080/users/2
	//@pathvariable para spring reconhecer o valor inserido como Long
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}