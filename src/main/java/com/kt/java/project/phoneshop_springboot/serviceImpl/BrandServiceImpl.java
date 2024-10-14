package com.kt.java.project.phoneshop_springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kt.java.project.phoneshop_springboot.entity.Brand;
import com.kt.java.project.phoneshop_springboot.exceptions.ResourceNotFoundException;
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
//		
		return brandRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	
	}

	@Override
	public Brand updatebrand(Integer id, Brand brandupdate) {
		Brand brandById = getById(id);
		brandById.setName(brandupdate.getName());
		return brandRepository.save(brandById);
	}

	@Override
	public List<Brand> getAllBrands() {
		return brandRepository.findAll();
	}

	@Override
	public List<Brand> getAllBrands(String name) {
		
		return brandRepository.findBrandBynameIgnoreCase(name);
				
	} 

}
