package com.himanshu.order_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.order_management.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
