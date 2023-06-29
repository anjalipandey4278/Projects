package com.nagarro.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>  {

	@Query("SELECT u FROM Review u WHERE u.isapproved = 0 AND u.id = ?1")
	public List<Review> reviewedres(Long productId);
	
	@Query("SELECT u.rating FROM Review u WHERE u.isapproved = 1 AND u.id = ?1")
	public List<Review> avgRating(Long productId);
	
	@Modifying
	@Transactional
	@Query("update Review  Set isapproved =1  where id = ?1" ) 
	public int approvedReview(Long id);
	
	List<Review> findByProductId(Long postId);
}
