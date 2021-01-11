package com.project.nakano.plantindex.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PlantDetailsMapper implements RowMapper<PlantDetails> {
	public PlantDetails mapRow(ResultSet resultSet, int i) throws SQLException {

		PlantDetails plantDetails = new PlantDetails();
		plantDetails.setId(resultSet.getInt("id"));
		plantDetails.setNome(resultSet.getString("nome"));
		plantDetails.setOutrosNomes(resultSet.getString("outros_nomes"));
		plantDetails.setOrdem(resultSet.getString("ordem"));
		plantDetails.setFloracao(resultSet.getString("floracao"));
		plantDetails.setRega(resultSet.getString("rega"));
		plantDetails.setTamanho(resultSet.getString("tamanho"));
		plantDetails.setPerfumada(resultSet.getString("perfumada"));
		plantDetails.setTribo(resultSet.getString("tribo"));
		plantDetails.setOrigem(resultSet.getString("origem"));
		plantDetails.setPropagacao(resultSet.getString("propagacao"));
		plantDetails.setSubfamilia(resultSet.getString("subfamilia"));
		plantDetails.setCategoria(resultSet.getString("categoria"));
		plantDetails.setSubtribo(resultSet.getString("subtribo"));
		plantDetails.setEspecie(resultSet.getString("especie"));
		plantDetails.setIluminacao(resultSet.getString("iluminacao"));
		plantDetails.setPlantio(resultSet.getString("plantio"));
		plantDetails.setFrutos(resultSet.getString("frutos"));
		plantDetails.setTexto(resultSet.getString("infos"));

		return plantDetails;
	}
}
