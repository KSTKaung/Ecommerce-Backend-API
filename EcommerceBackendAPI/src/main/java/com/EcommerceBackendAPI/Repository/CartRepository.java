package com.EcommerceBackendAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EcommerceBackendAPI.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
