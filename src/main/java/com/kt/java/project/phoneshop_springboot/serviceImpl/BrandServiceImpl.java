package com.kt.java.project.phoneshop_springboot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
//		Optional<Brand> brandOptional = brandRepository.findById(id);
//		if(brandOptional.isPresent()) {
//			return brandOptional.get();
//		} else
//		{
			//* Able to use format for java under 17
//			throw new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("Brand with id %d is not found", id));
			//* use this line for java 17 up
			// throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id %d is not found".formatted(id));
//		}
		return brandRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, 
				"Brand with id %d is not found".formatted(id)
				));
	}

}
