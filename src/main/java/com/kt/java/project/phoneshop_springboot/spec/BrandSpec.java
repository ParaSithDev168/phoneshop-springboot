package com.kt.java.project.phoneshop_springboot.spec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.kt.java.project.phoneshop_springboot.entity.Brand;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.Data;

@Data
public class BrandSpec implements Specification<Brand>{
	
	private static final long serialVersionUID = 1L;

	private final BrandFilter brandFilter;
	
	List<Predicate> predicate = new ArrayList<>();
	
	@Override
	public Predicate toPredicate(Root<Brand> brand, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		if(brandFilter.getName() != null) {
			//Predicate name = brand.get("name").in(brandFilter.getName());
			Predicate name = cb.like(cb.upper(brand.get("name")), "%" + brandFilter.getName().toUpperCase() + "%");
			predicate.add(name);
		}
		
		if(brandFilter.getId() != null) {
			Predicate id = brand.get("id").in(brandFilter.getId());
			predicate.add(id);
		}
		
		return cb.and(predicate.toArray(Predicate[]::new));
	}

}
