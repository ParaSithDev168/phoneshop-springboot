package com.kt.java.project.phoneshop_springboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kt.java.project.phoneshop_springboot.dto.BrandDTO;
import com.kt.java.project.phoneshop_springboot.entity.Brand;
import com.kt.java.project.phoneshop_springboot.mapper.BrandMapper;
import com.kt.java.project.phoneshop_springboot.service.BrandService;

@RestController
@RequestMapping("/brands")
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.save(brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getbrandById(@PathVariable("id") Integer brandId){
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateBrand(@PathVariable("id") Integer BrandId , @RequestBody BrandDTO brandDto){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDto);
		Brand updateBrand = brandService.updatebrand(BrandId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updateBrand));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBrands(){
		 List<BrandDTO> list = brandService.getAllBrands()
		 	.stream()
		 	.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
		 	.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("filter")
	public ResponseEntity<?> getAllBrands(@RequestParam String name){
		 List<BrandDTO> list = brandService.getAllBrands(name)
		 	.stream()
		 	.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
		 	.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
}
	