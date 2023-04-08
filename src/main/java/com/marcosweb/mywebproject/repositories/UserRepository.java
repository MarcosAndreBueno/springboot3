package com.marcosweb.mywebproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosweb.mywebproject.entities.User;

//classe para instânciar objetos repositories
public interface UserRepository extends JpaRepository<User, Long> {

}
