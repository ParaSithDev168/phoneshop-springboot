package com.kt.java.project.phoneshop_springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kt.java.project.phoneshop_springboot.entity.Brand;

public interface BrandService {
	Brand save(Brand brand);
	Brand getById(Integer id);
	Brand updatebrand(Integer id, Brand brand);
	List<Brand> getAllBrands(String name);
	//List<Brand> getAllBrands(Map<String, String> params);
	Page<Brand> getAllBrands(Map<String, String> params);
}
