package com.kt.java.project.phoneshop_springboot.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kt.java.project.phoneshop_springboot.entity.Brand;
import com.kt.java.project.phoneshop_springboot.exceptions.ResourceNotFoundException;
import com.kt.java.project.phoneshop_springboot.repository.BrandRepository;
import com.kt.java.project.phoneshop_springboot.service.BrandService;
import com.kt.java.project.phoneshop_springboot.spec.BrandFilter;
import com.kt.java.project.phoneshop_springboot.spec.BrandSpec;
//BrandSpec;
import com.kt.java.project.phoneshop_springboot.util.PageUtil;

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
		return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", id));

	}

	@Override
	public Brand updatebrand(Integer id, Brand brandupdate) {
		Brand brandById = getById(id);
		brandById.setName(brandupdate.getName());
		return brandRepository.save(brandById);
	}

	// Own get value using parameter
	@Override
	public List<Brand> getAllBrands(String name) {

		return brandRepository.findBrandBynameIgnoreCase(name);

	}

	// JPA Specification - Method
	@Override
	public Page<Brand> getAllBrands(Map<String, String> params) {
		
		BrandFilter brandFilter = new BrandFilter();

		if (params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}

		if (params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}

		int pageLimit = PageUtil.DEFUALT_PAGE_LIMIT;
		if (params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		int pageNumber = PageUtil.DEFUALT_PAGE_NUMBER;
		if (params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
		Page<Brand> page = brandRepository.findAll(brandSpec, pageable);
		return page;
	}

}
