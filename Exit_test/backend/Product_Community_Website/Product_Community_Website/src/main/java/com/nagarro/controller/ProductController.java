package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.nagarro.model.Product;
import com.nagarro.repository.ProductRepository;
import com.nagarro.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private ProductRepository repo;

    @GetMapping("/getproductCount")
	public int getAllData() {
		return service.getProductCount();
	}
    
    @GetMapping("/getallProducts")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
    
    
    @GetMapping("/Products/{id}")
	public Product getDatabyID(@PathVariable("id") Long id) {
		return  service.getDatabyId(id);
	}
 
    
    @PostMapping("/product")
    public ResponseEntity<String> AddProducts(@RequestBody Product e){
    	repo.save(e);
    	return ResponseEntity.ok("okkkk");
   
     
   
}
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(service.search(query));
    }
}