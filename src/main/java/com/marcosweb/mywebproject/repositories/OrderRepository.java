package com.marcosweb.mywebproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosweb.mywebproject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
