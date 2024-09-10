package com.EcommerceBackendAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EcommerceBackendAPI.Entity.Users;
import com.EcommerceBackendAPI.Service.UsersService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.PrimaryKeyJoinColumn;

@RestController
@Tag(name = "Users")
@PrimaryKeyJoinColumn(name = "id")
public class UsersController {
	@Autowired
	private UsersService service;

	@PostMapping("/addUser")
	@Description("Create User")
	public Users addUser(@RequestBody Users user) {
		return service.saveUser(user);
	}

	@PostMapping("/addUsers")
	@Description("Create List of Users")
	@ApiResponse(responseCode = "200", description = "Create User Successfully")
	public List<Users> addUsers(@RequestBody List<Users> users) {
		return service.saveUsers(users);
	}

	@GetMapping("/getAllUsers")
	@Description("Get All Users")
	public List<Users> findAllUsers() {
		return service.getUsers();
	}

	@GetMapping("/Login/{email}/{password}")
	@Description("Login")
	public Users Login(@PathVariable String email, @PathVariable String password) {
		return service.getUserByEmailPassword(email, password);
	}

	@PutMapping("/updateUser")
	@Description("Update User")
	@ApiResponse(responseCode = "200", description = "Update User Successfully")
	public Users updateUser(@RequestBody Users user) {
		return service.updateUser(user);
	}

	@DeleteMapping("/deleteUser/{Id}")
	@Description("Delete User")
	@ApiResponse(responseCode = "200", description = "Delete User Successfully")
	public String deleteUser(@PathVariable int Id) {
		return service.deleteUser(Id);
	}
}
