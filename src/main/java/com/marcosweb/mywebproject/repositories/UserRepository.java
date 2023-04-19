package com.marcosweb.mywebproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosweb.mywebproject.entities.User;

//classe para instânciar objetos repositories
//não precisa de anotation (@Repository ou @Component, etc) para registrá-la permitindo que o spring autoinjete-a em outras classes, pois ela herda de uma classe que já faz isso
public interface UserRepository extends JpaRepository<User, Long> {

}
