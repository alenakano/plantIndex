package com.project.nakano.plantindex.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.project.nakano.plantindex.model.PlantDetails;
import com.project.nakano.plantindex.model.PlantDetailsMapper;

@Component
public class PlantDetailsDAO {
	
	JdbcTemplate jdbcTemplate;

	private final String SQL_GET_PLANT = "select * from planta where nome = ?";
	private final String SQL_DELETE_PLANT = "delete from planta where nome = ?";
	private final String SQL_GET_ALL = "select * from planta";
	private final String SQL_INSERT_PLANT = 
			"insert into planta("
			+ "NOME, OUTROS_NOMES, ORDEM, FLORACAO, REGA, TAMANHO, PERFUMADA, TRIBO, ORIGEM, PROPAGACAO, SUBFAMILIA, CATEGORIA, SUBTRIBO, ESPECIE, ILUMINACAO, PLANTIO, FRUTOS, INFOS"
			+ ") values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	@Autowired
	public PlantDetailsDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public PlantDetails getPlantsByName(String nome) {
		return jdbcTemplate.queryForObject(SQL_GET_PLANT, new Object[] { nome }, new PlantDetailsMapper());
	}

	public List<PlantDetails> getAllPlants() {
		return jdbcTemplate.query(SQL_GET_ALL, new PlantDetailsMapper());
	}

	public boolean deletePlant(PlantDetails plant) {
		return jdbcTemplate.update(SQL_DELETE_PLANT, plant.getNome()) > 0;
	}

	public boolean createPlant(PlantDetails plant) {
		return jdbcTemplate.update(
				SQL_INSERT_PLANT, 
				plant.getNome(),
				plant.getOutrosNomes(),
				plant.getOrdem(),
				plant.getFloracao(),
				plant.getRega(),
				plant.getTamanho(),
				plant.getPerfumada(),
				plant.getTribo(),
				plant.getOrigem(),
				plant.getPropagacao(),
				plant.getSubfamilia(),
				plant.getCategoria(),
				plant.getSubtribo(),
				plant.getEspecie(),
				plant.getIluminacao(),
				plant.getPlantio(),
				plant.getFrutos(),
				plant.getTexto()
				) > 0;
	}

}
