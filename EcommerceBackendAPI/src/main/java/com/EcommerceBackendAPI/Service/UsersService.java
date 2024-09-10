package com.EcommerceBackendAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceBackendAPI.Entity.Users;
import com.EcommerceBackendAPI.Repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository repository;

	/*
	 * Save User
	 */
	public Users saveUser(Users user) {
		return repository.save(user);
	}

	/*
	 * Save All User
	 */
	public List<Users> saveUsers(List<Users> users) {
		return repository.saveAll(users);
	}

	/*
	 * Get Users
	 */
	public List<Users> getUsers() {
		return repository.findAll();
	}

	/*
	 * Get User By Email and Password (Login)
	 */
	public Users getUserByEmailPassword(String email, String password) {
		return repository.findbyemaillAndpassword(email, password);
	}

	/*
	 * Get User By ID
	 */
	public Users getUsersById(int Id) {
		return repository.findById(Id).orElse(null);
	}

	/*
	 * Delete User
	 */
	public String deleteUser(int id) {
		repository.deleteById(id);
		return "User removed !! " + id;
	}

	/*
	 * Update User
	 */
	public Users updateUser(Users user) {
		Users existingUser = repository.findById(user.getUserid()).orElse(null);
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setPhoneno(user.getPhoneno());
		existingUser.setCity(user.getCity());
		existingUser.setDistrict(user.getDistrict());
		existingUser.setSubDistrict(user.getSubDistrict());
		existingUser.setPostalCode(user.getPostalCode());
		return repository.save(existingUser);
	}
}
