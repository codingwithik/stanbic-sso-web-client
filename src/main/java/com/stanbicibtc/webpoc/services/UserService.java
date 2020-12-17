package com.stanbicibtc.webpoc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stanbicibtc.webpoc.entities.User;
import com.stanbicibtc.webpoc.pojo.ResponseDTO;
import com.stanbicibtc.webpoc.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	public ResponseDTO doLogin(String username, String password) {
		
		System.out.println("Do Login");
		ResponseDTO response = new ResponseDTO();
		
		try {
			User usr = findByEmail(username);
			System.out.println("Here"+username);
			if(usr == null) {
				response.setStatus("USER_NONEXISTS");
				response.setMessage("User Does Not Exist");
				return response;
			}
			if(!usr.getPassword().equals(password)) {
				response.setStatus("INCORRECT_CREDENTIALS");
				response.setMessage("Username or Password Incorrect");
				return response;
			}
			
			response.setData(usr);
			response.setStatus("SUCCESS");
			response.setMessage("Login Successful");
		}catch(Exception e) {
			System.out.println("Error While Doing Login "+e);
			response.setStatus("FAILURE");
			response.setMessage("Login Failed");
		}
		
		return response;
	}

	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findByPhoneNumber(String phoneNumber) {
		return userRepository.findByPhoneNumber(phoneNumber);
	}
	

	public User findByPhoneNumberOrEmail(String string) {
		return userRepository.findByPhoneNumberOrEmail(string,string);
	}
	
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	public void delete(User user) {
		userRepository.delete(user);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void saveAll(List<User> users) {
		userRepository.saveAll(users);
	}

	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	public long count() {
		return userRepository.count();
	}

	public void deleteAll(List<User> users) {
		userRepository.deleteAll(users);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}

}
