package com.kt.java.project.phoneshop_springboot.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface PageUtil {
	
	int DEFUALT_PAGE_LIMIT = 2;
	int DEFUALT_PAGE_NUMBER = 1;
	String PAGE_LIMIT = "_limit";
	String PAGE_NUMBER = "_page";

	static Pageable getPageable(int pageNumber, int pageSize) {

		if (pageNumber < DEFUALT_PAGE_NUMBER) {
			pageNumber = DEFUALT_PAGE_NUMBER;
		}

		if (pageSize < 1) {
			pageSize = DEFUALT_PAGE_LIMIT;
		}

		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);

		return pageable;
	}
}
