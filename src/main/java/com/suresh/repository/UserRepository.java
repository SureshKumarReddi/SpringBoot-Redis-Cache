package com.suresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suresh.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
