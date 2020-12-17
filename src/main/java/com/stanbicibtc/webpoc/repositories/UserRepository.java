package com.stanbicibtc.webpoc.repositories;


import org.springframework.data.repository.CrudRepository;

import com.stanbicibtc.webpoc.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
		
	User findByEmail(String email);
	
	User findByPhoneNumber(String phoneNumber);

	User findByPhoneNumberOrEmail(String phoneNumber,String email);
	
}
