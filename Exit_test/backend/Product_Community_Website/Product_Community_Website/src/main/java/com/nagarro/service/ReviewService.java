package com.nagarro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.exception.ProductNotFound;
import com.nagarro.exception.ReviewNotFound;
import com.nagarro.model.Product;
import com.nagarro.model.Review;
import com.nagarro.repository.ProductRepository;
import com.nagarro.repository.ReviewRepository;

@Service
public class ReviewService {
	
	   @Autowired
	    private ReviewRepository repo;
	   @Autowired
	    private ProductRepository prepo;
//	
//	   public List<Review> requestedview(){
//		   List<Review> r =  repo.reviewedres();
//		return r;
//    }
	
	public List<Review> getAllReviewProductById( Long productId) {
	    if (!prepo.existsById(productId)) {
	      throw new ReviewNotFound("NO product found = " + productId);
	    }
	    List<Review> reviews = repo.findByProductId(productId);
	    return reviews;
	  }
	public Review getReviewByProductId( Long id) {
	    Review review = repo.findById(id)
	        .orElseThrow(() -> new ReviewNotFound("Not found Comment with id = " + id));

	    return review;
	  }
	public Review createReview( Long productId, Review reviewdata) {
	    Review re = prepo.findById(productId).map(product -> {
	      reviewdata.setProduct(product);
	      return repo.save(reviewdata);
	    }).orElseThrow(() -> new ReviewNotFound("Not found Tutorial with id = " + productId));

	    return re;
	  }
	public int approvedReviews(long id) {
		int review=repo.approvedReview(id);
		return review;
	}
	public void deleteReviews(long id) {
		 repo.deleteById(id);
	}
	public List avgRatingCount(long id) {
		return repo.avgRating(id);
		
	}


}
