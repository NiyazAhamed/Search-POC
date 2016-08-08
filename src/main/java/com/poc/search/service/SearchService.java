package com.poc.search.service;

import com.poc.search.domain.Method;
import com.poc.search.domain.Response;

public interface SearchService {

	Response search(Method method, String q);
}
