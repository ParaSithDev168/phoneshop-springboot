package com.kt.java.project.phoneshop_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kt.java.project.phoneshop_springboot.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>,JpaSpecificationExecutor<Brand> {
	
	List<Brand> findBrandBynameIgnoreCase(String name);
	
}
