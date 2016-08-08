package com.poc.search.service.method;

import com.poc.search.dao.method.SearchDao;
import com.poc.search.dao.method.SearchStringMatchDaoImpl;
import com.poc.search.domain.Response;

public class SearchMethodStringMatchServiceImpl implements SearchMethodService{

	SearchDao searchStringMatchDaoImpl = new SearchStringMatchDaoImpl();

	@Override
	public Response search(String q) {
		return searchStringMatchDaoImpl.search(q);
	}
}
