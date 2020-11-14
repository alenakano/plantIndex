package com.project.nakano.plantindex;

import org.apache.commons.collections4.map.MultiValueMap;

public class SearchResult {
	
	private MultiValueMap<String, String> content = new MultiValueMap<String, String>();

	public SearchResult(MultiValueMap<String, String> content) {
		this.content = content;
	}

	public MultiValueMap<String, String> getContent() {
		return content;
	}
	
	public void setContent(String key, String value) {
		this.content.put(key, value);
	}
}
