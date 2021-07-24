package com.project.nakano.plantindex.jpa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class PlantNamesFinder extends MinhasPlantasData {

 /** Realiza a busca dos nomes das plantas no site MinhasPlantas.
  *
  * @param categoria
  *
  * @return List(String)
  * @throws IOException
  *
 */
  public List<String> searchPlantNames(String categoria) throws IOException {
  
    List<String> plantNames = new ArrayList<>();
  
    try {
      Document doc;
  
      // URL e contador da paginacao
      String baseUrl = categoria.isEmpty() ? minhasPlantas + "/plantas"
          : minhasPlantas + "/plantas/categorias/" + categoria + "";
      Integer paginationCounter = 1;
  
      do {
        // Paginacao da tela
        String url = baseUrl + pagination.replaceAll("/paginationCounter/", paginationCounter.toString());
        doc = connect(url).get();
        Elements value = doc.select("article.Entry > a:nth-child(2)");
        
        for (Element link : value) {
        	plantNames.add(link.attr("href"));
        }
        
        paginationCounter++;
        
        // Paginar enquanto houver a classe endless_more OU até paginação 20 de limite
      } while (!doc.getElementsByClass("endless_more").isEmpty() && paginationCounter <= 20);

    } catch (HttpStatusException e) {
    	System.out.println(e);
    } 
    return plantNames;
  }
  
  Connection connect(String url) {
    return Jsoup.connect(url);
  }
}
