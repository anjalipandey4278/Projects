package com.nagarro.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nagarro.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT u FROM Product u WHERE " +
	            "u.productName LIKE CONCAT('%',:query, '%')" +
	            "Or u.productBrand LIKE CONCAT('%', :query, '%')" +
	            "Or u.id LIKE CONCAT('%',:query, '%')")
	    public List<Product> searchqsl(String query);

	
 
}
