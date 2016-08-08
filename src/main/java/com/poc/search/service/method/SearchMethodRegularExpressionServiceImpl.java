package com.poc.search.service.method;

import com.poc.search.dao.method.SearchDao;
import com.poc.search.dao.method.SearchRegularExpressionDaoImpl;
import com.poc.search.domain.Response;


public class SearchMethodRegularExpressionServiceImpl implements SearchMethodService{


	SearchDao searchRegularExpressionDaoImpl = new SearchRegularExpressionDaoImpl();

	@Override
	public Response search(String q) {
		return searchRegularExpressionDaoImpl.search(q);
	}
}
