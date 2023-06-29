package com.nagarro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.exception.ProductNotFound;

import com.nagarro.model.Product;
import com.nagarro.model.Review;
import com.nagarro.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;
     
   
    public List<Product> getAllProducts(){
    	List<Product> data = new ArrayList<>();
    	repo.findAll().forEach(data::add);
		System.out.print(data);
		return data;
    }
    public int getProductCount() {
    	return repo.findAll().size();
    }
    
    public Product getDatabyId(Long id) {
		 Optional<Product> p = repo.findById(id);
		 if (p.isEmpty())
	            throw new ProductNotFound("id-" + id);

	       
		return (Product) repo.findById(id).get();
	}
//    public List<Product> listAll(String keyword) {
public List<Product> search(String query) {
        List<Product> products = repo.searchqsl(query);
        return products;
    }
    
    
   
     
    
}
