package com.example.spring_boot_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.spring_boot_API.entity.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long>{

}
