package com.elmrabti.studentsapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elmrabti.studentsapp.enteties.Product;
import com.elmrabti.studentsapp.repository.ProductRepository;

@SpringBootApplication
public class StudentsApplication implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepository ; //injection

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		
		productRepository.save(new Product(null, "COMPUTER", 4500.0, 5) ) ;
		productRepository.save(new Product(null, "PRINTER", 1700.0, 3) ) ;
		productRepository.save(new Product(null, "SMARTPHONE", 3500.0, 10) ) ;
		
		List<Product> products = productRepository.findAll() ;
		products.forEach(p->{
			System.out.println(p.toString());
		});
		
		
		System.out.println("**********************");
		Product product = productRepository.findById(Long.valueOf(10)).get() ;
		System.out.println(product.toString() );
		System.out.println("**********************");

		List<Product> listProducts = productRepository.findByNameContains("C") ;
		listProducts.forEach(p->{
			System.out.println(p);
		});
		
		System.out.println("#######################");
		
		List<Product> listProducts2 = productRepository.search("%C%") ;
		listProducts2.forEach(p->{
			System.out.println(p);
		});
		
		System.out.println("#######################");
		
		List<Product> listProducts3 = productRepository.findByPriceGreaterThan(4000) ;
		listProducts3.forEach(p->{
			System.out.println(p);
		});	
		

		
		
		
		
		
		
	}

}
