package com.poc.search;

import com.poc.search.dao.method.SearchIndexDaoImpl;
import com.poc.search.domain.Method;
import com.poc.search.domain.Response;
import com.poc.search.service.SearchService;
import com.poc.search.service.SearchServiceImpl;

public class SearchApplication {

	public static void main(String args[]) {
		SearchService service = new SearchServiceImpl();



		long startTime = System.currentTimeMillis();

		for (long i=0; i <=3 ; i++){
			Response response = service.search(Method.RegularExpression,"century");
			System.out.println(response);
		}

		System.out.println(System.currentTimeMillis() - startTime);


	}
}
