package com.EcommerceBackendAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.EcommerceBackendAPI.Entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	// Retrieve data By Email and Password
	@Query("SELECT u FROM Users u WHERE (u.email = :email) and (u.password = :password)")
	Users findbyemaillAndpassword(@Param("email") String email, @Param("password") String password);
}