package com.poc.search.service.method;

import com.poc.search.dao.method.SearchIndexDaoImpl;
import com.poc.search.domain.Response;
import org.springframework.stereotype.Service;

@Service
public class SearchMethodIndexServiceImpl implements SearchMethodService {

	SearchIndexDaoImpl searchIndexDao = new SearchIndexDaoImpl();

	public Response search(String q) {
		return searchIndexDao.search(q);
	}
}
