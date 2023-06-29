package com.nagarro.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.email= ?1")
	public User getuserbyemail(String email);
	
	@Query("select count(u) from User u where u.activeUser = 1")
	public Long getonlinuser();
	
	@Modifying
	@Transactional
	@Query("update User  Set activeUser =1  where userid = ?1" ) 
	public void setonline(Long userid);
	
	@Modifying
	@Transactional
	@Query("update User  Set activeUser =0  where userid = ?1" ) 
	public void setoffline(Long userid);

	 public User findByEmailAndPassword(String email,String password);
	
	

}
