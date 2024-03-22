package com.security.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.security.model.User;

@Component
public interface UserRepositry extends JpaRepository<User, Long> {

	@Query("FROM USER WHERE user_name=:username")
	User findByUserName(@Param("username")String username);
}
