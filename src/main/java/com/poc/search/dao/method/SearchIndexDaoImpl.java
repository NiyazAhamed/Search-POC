package com.poc.search.dao.method;

import com.poc.search.domain.Count;
import com.poc.search.domain.Index;
import com.poc.search.domain.Method;
import com.poc.search.domain.Response;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class SearchIndexDaoImpl implements SearchDao{


	private final String DATA_PATH = "/var/search/data/sample_text";

	private Map<String, Index> dataStore = new HashMap<>();


	@Override
	public Response search(String q) {

		loadData();

		long startTime = System.currentTimeMillis();

		List<Count> results = getResults(q);

		long elapsedTime = System.currentTimeMillis() - startTime;

		return new Response(q, Method.StringMatch,results,elapsedTime);
	}


	private List<Count> getResults(String q) {
		Index index = dataStore.get(q);
		return index.getData();
	}



	private void loadData(){
		try {
			Files.walk(Paths.get(DATA_PATH))
					.filter(Files::isRegularFile)
					.forEach(file -> {
						try {
							String content = new String(Files.readAllBytes(file));

							List<String> stringList= Arrays.asList(content.split(" "));

							Map<String, Long> count = stringList.stream()
									.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
							store(file.getFileName().toString(),count);

						}catch (IOException e) {
							e.printStackTrace();
						}
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void store( String fileName, Map<String, Long> count){

		count.entrySet().stream().forEach(e -> {
			String word = e.getKey();
			Long value = e.getValue();
			Index index = dataStore.get(word);
			if( index == null){
				index = new Index(word);
			}
			index.addCount(fileName,value);
			dataStore.put(word,index);
		});
	}


}
