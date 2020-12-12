package com.project.nakano.plantindex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.nakano.plantindex.dao.CategoriaDAO;
import com.project.nakano.plantindex.model.PlantDetails;

@RestController
public class UpdateDatabaseController {

	private final String minhasPlantas = "https://minhasplantas.com.br/plantas/";
	private String pagination = "?page=/paginationCounter/&querystring_key=page";
	private Document doc;
	
	private ArrayList<String> plantNames = new ArrayList<String>();
	private MultiValueMap<String, String> map = new MultiValueMap<String, String>();
	private List<PlantDetails> ListPlantDetails = new ArrayList<PlantDetails>();

	@Autowired
	private CategoriaDAO categoriaDAO;

	@GetMapping("/updatedatabase")
	public String updateDatase(@RequestParam(value = "categoria", defaultValue = "") String categoria)
			throws IOException {

		String status = "status";

		try {
			this.searchPlantNames(categoria);
		} catch (Exception e) {
			System.out.println("[ERROR] - " + e);
		}

		this.plantNames.forEach(pl -> {
			try {
				// Busca a planta pelo nome normalizado para site.
				searchPlantDetails(StringUtils
						.stripAccents(pl.trim().replace(" ", "-").toLowerCase()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		this.ListPlantDetails.forEach(act -> {
			System.out.println();
			System.out.println(act.toString()); 
			System.out.println();
		});

		return status;
	}

	private void searchPlantDetails(String plantName) throws IOException {

		//Nome no site está incorreto
		if (plantName.contains("begona")) plantName = plantName.replace("begona-beleaf", "begonia-beleaf");
		
		try {
			this.map.clear();
	
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
				this.map.put(
					rowsA.get(i).getElementsByClass("Label").text(), 
					rowsA.get(i).getElementsByClass("Value").text()
				);
			}
			
			for(int i = 0, l = rowsB.size(); i < l; i++) {
				this.map.put(
					rowsB.get(i).getElementsByClass("Label").text(),
					rowsB.get(i).getElementsByClass("Value").text()
				);
			}
			
			//Retirar parte com o texto sobre a planta
			Elements text = doc.select("div.Text");
			
			//Inserindo no Map
			this.map.put("infos", Jsoup.clean(text.toString(), Whitelist.none().addTags("h2", "h3")));
			
					
		} catch (HttpStatusException e) {
			System.out.println(e);
		}

		this.setRecoveredPlantDetails(map);
		
	}

	private void searchPlantNames(String categoria) throws IOException {

		try {

			// Apagar array antes de começar a iterar
			this.plantNames.clear();

			// URL e contador da paginacao
			String baseUrl = categoria.isEmpty() ? minhasPlantas : minhasPlantas + "categorias/" + categoria + "";
			Integer paginationCounter = 1;

			do {
				// Paginacao da tela
				String url = baseUrl + pagination.replaceAll("/paginationCounter/", paginationCounter.toString());

				this.doc = Jsoup.connect(url).get();
				Elements value = this.doc.getElementsByClass("Name");

				for (int i = 0, l = value.size(); i < l; i++) {
					String valueString = value.get(i).text();
					this.plantNames.add(valueString);
				}

				paginationCounter++;

				// Paginar enquanto houver a classe endless_more OU até paginação 20 de limite
			} while (!this.doc.getElementsByClass("endless_more").isEmpty() && paginationCounter <= 20);

		} catch (HttpStatusException e) {
			System.out.println(e);
		}

	}

	private void setRecoveredPlantDetails(MultiValueMap<String, String> map) {	
		if(!map.isEmpty()) {
			this.ListPlantDetails.add(new PlantDetails(
					map.get("Nome popular").toString(),
					map.get("Outros nomes").toString(), 
					map.get("Ordem").toString(), 
					map.get("Floração").toString(), 
					map.get("Gênero").toString(), 
					map.get("Rega").toString(), 
					map.get("Tamanho").toString(), 
					map.get("Perfumada").toString(), 
					map.get("Tribo").toString(), 
					map.get("Família").toString(), 
					map.get("Origem").toString(), 
					map.get("Propagação").toString(), 
					map.get("Subfamília").toString(), 
					map.get("Categoria").toString(), 
					map.get("Subtribo").toString(), 
					map.get("Espécie").toString(), 
					map.get("Iluminação").toString(), 
					map.get("Plantio").toString(), 
					map.get("infos").toString(), 
					map.get("Frutos").toString()
					)
			);
		}
	}
}
