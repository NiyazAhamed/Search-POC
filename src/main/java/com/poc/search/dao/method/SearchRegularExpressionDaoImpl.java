package com.poc.search.dao.method;

import com.poc.search.domain.Count;
import com.poc.search.domain.Method;
import com.poc.search.domain.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SearchRegularExpressionDaoImpl implements SearchDao{


	private final String DATA_PATH = "/var/search/data/sample_text";





	@Override
	public Response search(String q) {


		long startTime = System.currentTimeMillis();

		List<Count> results = getResults(q);

		long elapsedTime = System.currentTimeMillis() - startTime;

		return new Response(q, Method.RegularExpression,results,elapsedTime);
	}


	private List<Count> getResults(String q) {
		List<Count> results = new ArrayList<>();

		Pattern pattern = Pattern.compile(q);

		try {
			Files.walk(Paths.get(DATA_PATH))
					.filter(Files::isRegularFile)
					.forEach(file -> {

						try  {
							long count = 0;
							String content = new String(Files.readAllBytes(file));
							Matcher m = pattern.matcher(content);
							while(m.find()){
								count++;
							}
							results.add(new Count(file.getFileName().toString(),count));
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
