package com.poc.search;

import com.poc.search.dao.method.SearchIndexDaoImpl;
import com.poc.search.domain.Method;
import com.poc.search.domain.Response;
import com.poc.search.service.SearchService;
import com.poc.search.service.SearchServiceImpl;

public class SearchApplication {

	public static void main(String args[]) {
		SearchService service = new SearchServiceImpl();

		Response response = service.search(Method.RegularExpression,"century");

		System.out.println(response);

		response = service.search(Method.Indexed,"century");

		System.out.println(response);

		response = service.search(Method.StringMatch,"century");

		System.out.println(response);

	}
}
