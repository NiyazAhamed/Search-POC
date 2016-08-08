package com.poc.search.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Count {
	@JsonProperty
	String fielName;

	@JsonProperty
	Long count;

	public Count(){

	}

	public Count(String fielName, Long count) {
		this.fielName = fielName;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Count{" +
				"fielName='" + fielName + '\'' +
				", count=" + count +
				'}';
	}
}
