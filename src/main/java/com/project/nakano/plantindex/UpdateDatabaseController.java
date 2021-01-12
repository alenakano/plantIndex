package com.project.nakano.plantindex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.map.MultiValueMap;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.nakano.plantindex.dao.PlantDetailsDAO;
import com.project.nakano.plantindex.model.PlantDetails;

@RestController
public class UpdateDatabaseController {

	private final String minhasPlantas = "https://minhasplantas.com.br";
	private String pagination = "?page=/paginationCounter/&querystring_key=page";
	private Document doc;

	@Autowired
	private PlantDetailsDAO plantDetailsDAO;

	@GetMapping("/updatedatabase")
	public String updateDatase(@RequestParam(value = "categoria", defaultValue = "") String categoria)
			throws IOException {

		String status = "Sucesso";
		ArrayList<String> plantsToSearch = new ArrayList<String>();
		List<PlantDetails> listPlantDetails = new ArrayList<PlantDetails>();

		// Recuperar links href das plantas para pesquisa
		try {
			plantsToSearch = this.searchPlantNames(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			status = "Falha";
		}

		// Busca detlahes da planta pelo link href recuperado.
		plantsToSearch.forEach(pl -> {
			try {
				PlantDetails plantDetail = searchPlantDetails(pl);

				if (plantDetail.getNome() != null) {
					listPlantDetails.add(plantDetail);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		// Salva na base de dados
		try {
			listPlantDetails.forEach(plt -> {
				plantDetailsDAO.createPlant(plt);
			});
		} catch (Exception e) {
			status = "Falha";
			e.printStackTrace();
		}

		return status;
	}

	private PlantDetails searchPlantDetails(String plantURL) throws IOException {

		MultiValueMap<String, String> map = new MultiValueMap<String, String>();

		try {

			String url = this.minhasPlantas + plantURL;

			// GET html e tratar retirando tags publicitárias
			this.doc = Jsoup.connect(url).get();
			this.doc.select("h2:contains(CONTEÚDO PUBLICITÁRIO)," + " h2:contains(Minhas Plantas recomenda)," + " script,"
					+ " ins").remove();
			this.doc.select("div.Text").last().remove();

			// Selecionando dados da tabela de informação da planta
			Elements rowsA = doc.select("li.A");
			Elements rowsB = doc.select("li.B");

			// Inserção das informações no MultivalueMap
			for (int i = 0, l = rowsA.size(); i < l; i++) {
				map.put(rowsA.get(i).getElementsByClass("Label").text(),
						rowsA.get(i).getElementsByClass("Value").text());
			}

			for (int i = 0, l = rowsB.size(); i < l; i++) {
				map.put(rowsB.get(i).getElementsByClass("Label").text(),
						rowsB.get(i).getElementsByClass("Value").text());
			}

			// Retirar parte com o texto sobre a planta
			Elements text = this.doc.select("div.Text");

			// Inserindo no Map
			map.put("infos", Jsoup.clean(text.toString(), Whitelist.none().addTags("h2", "h3")));

		} catch (HttpStatusException e) {
			System.out.println(e);
		}

		return setRecoveredPlantDetails(map);

	}

	private ArrayList<String> searchPlantNames(String categoria) throws IOException {

		ArrayList<String> plantNames = new ArrayList<String>();

		try {
			// URL e contador da paginacao
			String baseUrl = categoria.isEmpty() ? minhasPlantas + "/plantas"
					: minhasPlantas + "/plantas/categorias/" + categoria + "";
			Integer paginationCounter = 1;

			do {
				// Paginacao da tela
				String url = baseUrl + pagination.replaceAll("/paginationCounter/", paginationCounter.toString());

				this.doc = Jsoup.connect(url).get();
				Elements value = this.doc.select("article.Entry > a:nth-child(2)");

				for (Element link : value) {
					plantNames.add(link.attr("href"));
				}

				paginationCounter++;

				// Paginar enquanto houver a classe endless_more OU até paginação 20 de limite
			} while (!this.doc.getElementsByClass("endless_more").isEmpty() && paginationCounter <= 20);

		} catch (HttpStatusException e) {
			System.out.println(e);
		}

		return plantNames;
	}

	private PlantDetails setRecoveredPlantDetails(MultiValueMap<String, String> map) {
		return new PlantDetails(map.get("Nome popular").toString().replaceAll("[\\[\\],]", ""),
				map.get("Outros nomes").toString().replaceAll("[\\[\\],]", ""),
				map.get("Ordem").toString().replaceAll("[\\[\\],]", ""),
				map.get("Floração").toString().replaceAll("[\\[\\],]", ""),
				map.get("Gênero").toString().replaceAll("[\\[\\],]", ""),
				map.get("Rega").toString().replaceAll("[\\[\\],]", ""),
				map.get("Tamanho").toString().replaceAll("[\\[\\],]", ""),
				map.get("Perfumada").toString().replaceAll("[\\[\\],]", ""),
				map.get("Tribo").toString().replaceAll("[\\[\\],]", ""),
				map.get("Família").toString().replaceAll("[\\[\\],]", ""),
				map.get("Origem").toString().replaceAll("[\\[\\],]", ""),
				map.get("Propagação").toString().replaceAll("[\\[\\],]", ""),
				map.get("Subfamília").toString().replaceAll("[\\[\\],]", ""),
				map.get("Categoria").toString().replaceAll("[\\[\\],]", ""),
				map.get("Subtribo").toString().replaceAll("[\\[\\],]", ""),
				map.get("Espécie").toString().replaceAll("[\\[\\],]", ""),
				map.get("Iluminação").toString().replaceAll("[\\[\\],]", ""),
				map.get("Plantio").toString().replaceAll("[\\[\\],]", ""),
				map.get("infos").toString().replaceAll("[\\[\\],]", ""),
				map.get("Frutos").toString().replaceAll("[\\[\\],]", ""));
	}
}
