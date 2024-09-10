package com.EcommerceBackendAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.EcommerceBackendAPI.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	// Retrieve data by User ID
	@Query("SELECT o FROM Order o inner join fetch o.users WHERE o.users.userid = :userid")
	List<Order> findByUserID(@Param("userid") int userid);

	// Retrieve data by Product ID
	@Query("SELECT o FROM Order o inner join fetch o.product WHERE o.product.productid = :productid")
	List<Order> findByProductID(@Param("productid") int productid);
}
