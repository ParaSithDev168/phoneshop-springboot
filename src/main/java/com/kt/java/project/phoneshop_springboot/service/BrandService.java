package com.kt.java.project.phoneshop_springboot.service;

import java.util.List;

import com.kt.java.project.phoneshop_springboot.entity.Brand;

public interface BrandService {
	Brand save(Brand brand);
	Brand getById(Integer id);
	Brand updatebrand(Integer id, Brand brand);
	List<Brand> getAllBrands();
	List<Brand> getAllBrands(String name);
	
}
