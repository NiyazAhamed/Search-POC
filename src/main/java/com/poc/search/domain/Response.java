package com.poc.search.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response {
	@JsonProperty
	private String searchTerm;

	@JsonProperty
	private Method method;

	@JsonProperty
	private List<Count> results;

	@JsonProperty
	private Long elapsedTime;


	public Response(String searchTerm, Method method, List<Count> results, Long elapsedTime) {
		this.searchTerm = searchTerm;
		this.method = method;
		this.results = results;
		this.elapsedTime = elapsedTime;
	}

	@Override
	public String toString() {
		return "Response{" +
				"searchTerm='" + searchTerm + '\'' +
				", method=" + method +
				", results=" + results +
				", elapsedTime=" + elapsedTime +
				'}';
	}
}
