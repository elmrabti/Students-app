package com.elmrabti.studentsapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.elmrabti.studentsapp.enteties.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	//Cette interface utilise l'interface générique JpaRepository et spring qui s'occupe de
	//l'implémentaion 
	
	List<Product> findByNameContains(String s);
	//On declare la methode en respectant les règles de nommage
	
	@Query("select p from Product p where p.name like :x")
	List<Product> search(@Param("x") String s);
	//Sinon On utilise l'annotation query :x c'est un parametre 
	
	List<Product> findByPriceGreaterThan(double prix);


	

}
