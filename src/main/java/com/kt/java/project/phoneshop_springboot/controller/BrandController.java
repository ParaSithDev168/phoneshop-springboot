package com.kt.java.project.phoneshop_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt.java.project.phoneshop_springboot.dto.BrandDTO;
import com.kt.java.project.phoneshop_springboot.entity.Brand;
import com.kt.java.project.phoneshop_springboot.service.BrandService;
import com.kt.java.project.phoneshop_springboot.util.Mapper;

@RestController
@RequestMapping("/brands")
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = Mapper.toBrand(brandDTO);
		brand = brandService.save(brand);
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getbrandById(@PathVariable("id") Integer brandId){
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateBrand(@PathVariable("id") Integer BrandId , @RequestBody BrandDTO brandDto){
		Brand brand = Mapper.toBrand(brandDto);
		Brand updateBrand = brandService.updatebrand(BrandId, brand);
		return ResponseEntity.ok(Mapper.toBrandDTO(updateBrand));
	}
}
	