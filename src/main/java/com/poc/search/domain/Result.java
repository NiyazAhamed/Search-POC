package com.poc.search.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
	@JsonProperty
	String fileName;

	@JsonProperty
	Long matches;

	public Result(String fileName, Long matches) {
		this.fileName = fileName;
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "Result{" +
				"fileName='" + fileName + '\'' +
				", matches=" + matches +
				'}';
	}
}
