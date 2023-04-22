package com.marcosweb.mywebproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcosweb.mywebproject.entities.Order;
import com.marcosweb.mywebproject.entities.User;
import com.marcosweb.mywebproject.repositories.OrderRepository;
import com.marcosweb.mywebproject.repositories.UserRepository;

//classe de configuração do perfil test. O perfil foi definido em /resources/aplication.properties
//Por enquanto usaremos para popular o BD
@Configuration
@Profile("test")
//Essa implementação faz esta classe ser executada quando o programa iniciar
public class TestConfig implements CommandLineRunner {

	//userRepository é a nossa classe responsável por salvar as informações no BD
	//@autowired serve para o spring injetar a dependência enquanto mantém o baixo acoplamento (SOLID)
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	//tudo dentro de run será executado
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		//salva os objetos da lista no BD
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		//teste pedidos
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}