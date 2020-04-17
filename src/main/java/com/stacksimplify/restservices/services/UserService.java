package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
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
	// CreateUser Method
	public User createUser(User user) throws UserExistsException {
		// if user exist using username
		User existingUser = userRepository.findByUsername(user.getUsername());

		// if not exists throw UserExistsException
		if (existingUser != null) {
			throw new UserExistsException("User already exists in repository");
		}
		return userRepository.save(user);
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			throw new UserNotFoundException("User Not Found in the system");

		return null;
	}

	/**
	 * @param user
	 * @param id
	 * @return
	 */
	public User updateUserById(User user, Long id) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(id);

		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not found in user Repository, provide the correct user id");
		}

		user.setId(id);
		return userRepository.save(user);
	}

	/**
	 * @param id
	 */
	public void deleteUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"User Not found in user Repository, provide the correct user id");
		}

		userRepository.deleteById(id);
	}

	/**
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
