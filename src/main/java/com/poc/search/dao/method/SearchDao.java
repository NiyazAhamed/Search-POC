package com.poc.search.dao.method;

import com.poc.search.domain.Response;

public interface SearchDao {

	Response search(String q);
}
