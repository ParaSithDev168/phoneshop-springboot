package com.kt.java.project.phoneshop_springboot.service;

import com.kt.java.project.phoneshop_springboot.entity.Brand;

public interface BrandService {
	Brand save(Brand brand);
	Brand getById(Integer id);
	Brand updatebrand(Integer id, Brand brand);
}
