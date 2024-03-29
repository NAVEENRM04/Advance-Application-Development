package com.example.aqua.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.example.aqua.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String username);
	@Query("select u from User u where (u.role=USER OR u.role=MANAGER) AND u.isactive=true")
	public List<User> findAllByRole();
	@Query("select u from User u where (u.role=USER OR u.role=MANAGER) AND u.isactive=false")
	public List<User> findByBannedUser();
	@Query("select u from User u where (u.role=USER)And isactive = true")
	public List<User>findByActiveRoleForManager();
	
	
	
}
