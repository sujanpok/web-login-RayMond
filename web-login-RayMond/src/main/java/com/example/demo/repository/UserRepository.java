package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NewUser;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface UserRepository extends JpaRepository<NewUser, Integer> {

	Optional<NewUser> findById(int id);


	
}
