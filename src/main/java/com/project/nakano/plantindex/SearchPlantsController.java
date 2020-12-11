package com.project.nakano.plantindex;

import java.io.IOException;

import org.apache.commons.collections4.map.MultiValueMap;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchPlantsController {

	private final String minhasPlantas = "https://minhasplantas.com.br/plantas/";
	private String pagination = "?page=/paginationCounter/&querystring_key=page";
	private MultiValueMap<String, String> map = new MultiValueMap<String, String>();
	private Document doc;

	@GetMapping("/search")
	public SearchedPlantsResult search(@RequestParam(value = "categoria", defaultValue = "") String categoria)
			throws IOException {
		try {
			//Apagar o map antes de pesquisar
			this.map.clear();
			
			//URL e contador da paginacao
			String baseUrl = categoria.isEmpty() ? minhasPlantas : minhasPlantas + "categorias/" + categoria + "";
			Integer paginationCounter = 1;

			do {
				// Paginacao da tela
				String url = baseUrl + pagination.replaceAll("/paginationCounter/", paginationCounter.toString());
				
				this.doc = Jsoup.connect(url).get();
				Elements key = this.doc.getElementsByClass("Cat");
				Elements value = this.doc.getElementsByClass("Name");

				for (int i = 0, l = key.size( ) <= value.size() ? key.size() : value.size(); i < l; i++) {
					String keyString = key.get(i).text();
					String valueString = value.get(i).text();
					this.map.put(keyString, valueString);
				}
				paginationCounter++;
		
			// Paginar enquanto houver a classe endless_more OU até paginação 20 de limite
			} while (!this.doc.getElementsByClass("endless_more").isEmpty() && paginationCounter <= 20);
			
		} catch (HttpStatusException e) {
			System.out.println(e);
		}
		return new SearchedPlantsResult(this.map);
	}
	
}
