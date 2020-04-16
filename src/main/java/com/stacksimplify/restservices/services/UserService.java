package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * @return
	 */
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * @param user
	 * @return
	 */
	public User createUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	/**
	 * @param user
	 * @param id
	 * @return
	 */
	public User updateUserById(User user, Long id) {
		user.setId(id);
		return userRepository.save(user);
	}

	/**
	 * @param id
	 */
	public void deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}

	/**
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
