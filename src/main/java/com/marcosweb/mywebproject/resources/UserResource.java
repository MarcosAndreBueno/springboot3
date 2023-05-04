package com.marcosweb.mywebproject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcosweb.mywebproject.entities.User;
import com.marcosweb.mywebproject.services.UserService;

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
	
	//PostMapping é um método do http para inserção de dados
	//RequestBody explicita que o objeto será enviado como Json na requisição e será desserializado em objeto User no Java
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		//retorna confirmação 201 do http de novo recurso criado (assim é mais correto do que apenas deixar igual os returns dos métodos acima)
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}