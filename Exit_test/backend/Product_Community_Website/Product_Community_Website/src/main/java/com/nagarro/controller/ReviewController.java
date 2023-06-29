package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.model.Review;
import com.nagarro.repository.ReviewRepository;
import com.nagarro.service.ReviewService;;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReviewController {
	
	 
	 @Autowired
	    private ReviewService service;
	 @Autowired
	    private ReviewRepository repo;

	 
	 @GetMapping("/Product/{productId}/reviews")
	  public ResponseEntity<List<Review>> getAllReviewsProductById(@PathVariable(value = "productId") Long productId) {
		 return new ResponseEntity<>(service.getAllReviewProductById(productId), HttpStatus.OK);
	  }
	 
	 @GetMapping("/Product/{productId}/avgreview")
	 public int getAvgRating(@PathVariable(value = "productId")Long productId){
		 int avgrating = 0;
		 List<Review>list = repo.findByProductId(productId);
		 for(Review i : list) {
			 if(i.isIsapproved() == true) {
				 avgrating += i.getRating();
			 }
		 }
		 if(list.size()>0) {
			 avgrating/= list.size();
			 
		 }
		 
		 return avgrating;
		 
	 }
	 
	 @GetMapping("/review/{id}")
	  public ResponseEntity<Review> getReviewByProductId(@PathVariable(value = "id") Long id) {
	   
	    return new ResponseEntity<>(service.getReviewByProductId(id), HttpStatus.OK);
	  }
	 
	 @PostMapping("/Product/{productId}/reviews")
	  public ResponseEntity<Review> createReview(@PathVariable(value = "productId") Long productId,
	      @RequestBody Review reviewdata) { 
	    return new ResponseEntity<>(service.createReview(productId, reviewdata), HttpStatus.CREATED);
	  }
	
	 @PostMapping("/review")
	  public int approveReviewById(@RequestBody Long id) {
	   
	    return service.approvedReviews(id);
	  }
	 @GetMapping("/rating/{id}")
	 public List avgRateById(@PathVariable(value = "id") Long id) {
		 return service.avgRatingCount(id);
	 }
	 
	 @DeleteMapping("/review/{id}")
	  public void declineReviewById(@PathVariable(value = "id") Long id) {
	   
	     service.deleteReviews(id);
	  }
	
	 
	
	 
	
	 
}
