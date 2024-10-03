package com.kt.java.project.phoneshop_springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kt.java.project.phoneshop_springboot.dto.BrandDTO;
import com.kt.java.project.phoneshop_springboot.entity.Brand;

@Mapper
public interface BrandMapper {
	
	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
	
	Brand toBrand(BrandDTO brandDto);
	
	BrandDTO toBrandDTO(Brand brand);
}
