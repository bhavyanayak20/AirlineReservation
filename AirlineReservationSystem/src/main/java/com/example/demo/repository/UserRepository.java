package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

//	boolean existsByEmail(String email);

//	Object findByUsername(String username);

//	Optional<User> emailpassordVerify(String email, String password);

	Users findByEmail(String username);

}