package com.project.nakano.plantindex;

import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

public class SearchedPlantDetailsResult {

	private MultiValueMap<String, String> content = new MultiValueMap<String, String>();

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
