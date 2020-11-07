package com.project.nakano.plantindex;

import java.io.IOException;
import java.util.regex.Pattern;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchPlantsController {

	private static final String minhasPlantas = "https://minhasplantas.com.br/plantas/";
	private String docHtml = "";

	@GetMapping("/search")
	public SearchResult search(@RequestParam(value = "categoria", defaultValue = "") String categoria) throws IOException {
		try {
				Document doc = Jsoup.connect(categoria.isEmpty() ? minhasPlantas : minhasPlantas + "categorias/" + categoria).get();
				Pattern patternElements = Pattern.compile("^(Name|Cat)$", Pattern.CASE_INSENSITIVE);
				Elements entries = doc.getElementsByAttributeValueMatching("class", patternElements);
				this.docHtml = entries.toString();
			
		} catch (HttpStatusException e) {				
			System.out.println(e);
			this.docHtml = "Falha"; 
		}
		return new SearchResult(this.docHtml);
	}
}
