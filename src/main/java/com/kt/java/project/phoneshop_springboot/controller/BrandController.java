package com.kt.java.project.phoneshop_springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.kt.java.project.phoneshop_springboot.dto.PageDTO;
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
	public ResponseEntity<?> getbrandById(@PathVariable("id") Integer brandId) {
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateBrand(@PathVariable("id") Integer BrandId, @RequestBody BrandDTO brandDto) {
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDto);
		Brand updateBrand = brandService.updatebrand(BrandId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updateBrand));
	}

//	@GetMapping
//	public ResponseEntity<?> getAllBrands(){
//		 List<BrandDTO> list = brandService.getAllBrands()
//		 	.stream()
//		 	.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
//		 	.collect(Collectors.toList());
//		return ResponseEntity.ok(list);
//	}

	@GetMapping
	public ResponseEntity<?> getAllBrands(@RequestParam Map<String, String> params) {

		Page<Brand> page = brandService.getAllBrands(params);
//		 List<BrandDTO> list = brandService.getAllBrands(params)
//		 	.stream()
//		 	.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
//		 	.collect(Collectors.toList());
		PageDTO pageDTO = new PageDTO(page);
		
		return ResponseEntity.ok(pageDTO);
	}
}
