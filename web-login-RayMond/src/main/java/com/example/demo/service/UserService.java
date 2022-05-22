package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.NewUser;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<NewUser> findAll() {
		return userRepository.findAll();
	}
	
	
	  public Optional<NewUser> findById(Long id) {
	        return userRepository.findById(id);
	    }

	public NewUser save(NewUser newUser) {
		return userRepository.save(newUser);
	}


	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

	
}
