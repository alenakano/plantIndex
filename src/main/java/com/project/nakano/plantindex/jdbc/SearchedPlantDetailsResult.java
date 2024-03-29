package com.project.nakano.plantindex.jdbc;

import org.apache.commons.collections4.map.MultiValueMap;

public class SearchedPlantDetailsResult {

	private MultiValueMap<String, String> content = new MultiValueMap<>();

	public SearchedPlantDetailsResult() {
	}
	
	public SearchedPlantDetailsResult(MultiValueMap<String, String> content) {
		this.content = content;
	}

	public MultiValueMap<String, String> getContent() {
		return content;
	}
	
	public void setContent(String key, String value) {
		this.content.put(key, value);
	}
	
	@Override
	public String toString() {
		return "SearchedPlantDetailsResult [content=" + content.toString() + "]";
	}
}
