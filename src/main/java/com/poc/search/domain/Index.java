package com.poc.search.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Index {

	@JsonProperty
	String word;

	@JsonProperty
	private List<Count> data;

	public Index(){

	}

	public Index(String word) {
		this.word = word;
		this.data = new ArrayList<>();
	}

	public void addCount(String fileName, long count){

		this.data.add(new Count(fileName,count));
	}

	public String getWord() {
		return word;
	}

	public List<Count> getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Index{" +
				"word='" + word + '\'' +
				", data=" + data +
				'}';
	}
}
