package com.kt.java.project.phoneshop_springboot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kt.java.project.phoneshop_springboot.entity.Brand;
import com.kt.java.project.phoneshop_springboot.repository.BrandRepository;
import com.kt.java.project.phoneshop_springboot.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	BrandRepository brandRepository;	
	
	@Override
	public Brand save(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
