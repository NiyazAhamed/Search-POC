package com.poc.search.dao.method;

import com.poc.search.domain.Count;
import com.poc.search.domain.Method;
import com.poc.search.domain.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;


public class SearchStringMatchDaoImpl implements SearchDao{


	private final String DATA_PATH = "/var/search/data/sample_text";


	@Override
	public Response search(String q) {

		long startTime = System.currentTimeMillis();

		List<Count> results = getResults(q);

		long elapsedTime = System.currentTimeMillis() - startTime;

		return new Response(q, Method.StringMatch,results,elapsedTime);
	}


	private List<Count> getResults(String q) {
		List<Count> results = new ArrayList<>();


		try {
			Files.walk(Paths.get(DATA_PATH))
					.filter(Files::isRegularFile)
					.forEach(file -> {
						try {
							String content = new String(Files.readAllBytes(file));
							results.add(new Count(file.getFileName().toString(),(long)StringUtils.countMatches(content,q)));
						}catch (IOException e) {
							e.printStackTrace();
						}
					});
		} catch (IOException e) {
			e.printStackTrace();
		}

		return results;
	}



}
