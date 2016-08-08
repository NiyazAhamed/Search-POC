package com.poc.search.service;

import com.poc.search.domain.Method;
import com.poc.search.domain.Response;
import com.poc.search.service.method.SearchMethodIndexServiceImpl;
import com.poc.search.service.method.SearchMethodRegularExpressionServiceImpl;
import com.poc.search.service.method.SearchMethodService;
import com.poc.search.service.method.SearchMethodStringMatchServiceImpl;


public class SearchServiceImpl implements SearchService {


	SearchMethodService searchMethodStringMatchServiceImpl = new SearchMethodStringMatchServiceImpl();

	SearchMethodService searchMethodRegularExpressionServiceImpl = new SearchMethodRegularExpressionServiceImpl();

	SearchMethodService searchMethodIndexServiceImpl = new SearchMethodIndexServiceImpl();


	@Override
	public Response search(Method method, String q) {

		switch(method){
			case StringMatch:
				return(searchMethodStringMatchServiceImpl.search(q));
			case RegularExpression:
				return(searchMethodRegularExpressionServiceImpl.search(q));
			case Indexed:
				return(searchMethodIndexServiceImpl.search(q));
			default:
				throw new RuntimeException("Unknown method");
		}

	}
}
