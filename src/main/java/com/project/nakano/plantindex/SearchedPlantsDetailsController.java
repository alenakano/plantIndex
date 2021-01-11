package com.project.nakano.plantindex;

import java.io.IOException;

import org.apache.commons.collections4.map.MultiValueMap;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchedPlantsDetailsController {
	
	private MultiValueMap<String, String> map = new MultiValueMap<String, String>();
	private final String minhasPlantas = "https://minhasplantas.com.br/plantas/";
	
	@GetMapping("/plants")
	public SearchedPlantDetailsResult searchPlant(@RequestParam(value = "plantName", defaultValue = "") String plantName)
			throws IOException {
		try {
			this.map.clear();
			if (plantName.isEmpty()) {
				
				return new SearchedPlantDetailsResult(this.map);
			}
			String url = this.minhasPlantas + plantName;
			
			//GET html e tratar retirando tags publicitárias
			Document doc = Jsoup.connect(url).get();
			doc.select(
					"h2:contains(CONTEÚDO PUBLICITÁRIO),"
					+ " h2:contains(Minhas Plantas recomenda),"
					+ " script,"
					+ " ins"
			).remove();
			doc.select("div.Text").last().remove();
	
			//Selecionando dados da tabela de informação da planta
			Elements rowsA = doc.select("li.A");
			Elements rowsB = doc.select("li.B");
			
			
			//Inserção das informações no MultivalueMap
			for(int i = 0, l = rowsA.size(); i < l; i++) {
				map.put(
					rowsA.get(i).getElementsByClass("Label").text(), 
					rowsA.get(i).getElementsByClass("Value").text()
				);
			}
			for(int i = 0, l = rowsB.size(); i < l; i++) {
				map.put(
					rowsB.get(i).getElementsByClass("Label").text(),
					rowsB.get(i).getElementsByClass("Value").text()
				);
			}
			
			//Retirar parte com o texto sobre a planta
			Elements text = doc.select("div.Text");
			
			//Inserindo no Map
			map.put("infos", Jsoup.clean(text.toString(), Whitelist.none().addTags("h2", "h3")));
			
					
		} catch (HttpStatusException e) {
			System.out.println(e);
		}
		return new SearchedPlantDetailsResult(this.map);
	}
}
