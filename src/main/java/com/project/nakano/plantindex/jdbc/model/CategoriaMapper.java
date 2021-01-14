package com.project.nakano.plantindex.jdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Fará mapeamento do banco do model indicado, ou seja, irá realizar
 * o de/para do resultSet para o modelo criado no java
 */
public class CategoriaMapper implements RowMapper<Categoria> {
	
	public Categoria mapRow(ResultSet resultSet, int i) throws SQLException {

		Categoria categoria = new Categoria();
		categoria.setId(resultSet.getInt("id"));
		categoria.setNome(resultSet.getString("nome"));
		
		return categoria;
	}
}
