package com.marcosweb.mywebproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosweb.mywebproject.entities.User;
import com.marcosweb.mywebproject.repositories.UserRepository;

//classe da camada de serviço (lembrando que a aplicação ta dividida em: front/controladores/serviços/banco de dados)
//se não registrar a classe com uma anotation, então o spring não conseguirá autoinjetar a dependência nas classes que a usam.
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	//neste caso o findAll não tem operações envolvendo regra de negócios, mesmo assim passa-se dá camada controlador para serviço, pois assim evita-se desvios do padrão de arquitetura escolhido.
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) { 
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	//por padrão o save já retorna o objeto salvo
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}