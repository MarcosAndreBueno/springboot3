package com.marcosweb.mywebproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcosweb.mywebproject.entities.Category;
import com.marcosweb.mywebproject.entities.Order;
import com.marcosweb.mywebproject.entities.OrderItem;
import com.marcosweb.mywebproject.entities.Payment;
import com.marcosweb.mywebproject.entities.Product;
import com.marcosweb.mywebproject.entities.User;
import com.marcosweb.mywebproject.entities.enums.OrderStatus;
import com.marcosweb.mywebproject.repositories.CategoryRepository;
import com.marcosweb.mywebproject.repositories.OrderItemRepository;
import com.marcosweb.mywebproject.repositories.OrderRepository;
import com.marcosweb.mywebproject.repositories.ProductRepository;
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

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	//tudo dentro de run será executado
	@Override
	public void run(String... args) throws Exception {

		//teste categorias
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		//teste produtos	
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		//salva os objetos da lista no BD
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		//teste join table
		//add categoria no produto, chave estrangeira
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		//salvar novamente os produtos (soa esquisito fazer isso, mas o JPA funciona diferente do SQL)
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");		
		
		//teste pedidos
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		//teste tabela OrderItem
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));	
		
		//teste Payment
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		//para salvar um objeto dependente em uma relação OneToOne, chama-se o repository do objeto independente
		orderRepository.save(o1);
	}
}