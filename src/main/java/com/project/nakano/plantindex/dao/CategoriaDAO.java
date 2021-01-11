package com.project.nakano.plantindex.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.project.nakano.plantindex.model.Categoria;
import com.project.nakano.plantindex.model.CategoriaMapper;

@Component
public class CategoriaDAO {
	
	JdbcTemplate jdbcTemplate;

	private final String SQL_GET_CATEGORIA = "select * from categoria where nome = ?";
	private final String SQL_DELETE_CATEGORIA = "delete from categoria where nome = ?";
	private final String SQL_GET_ALL = "select * from categoria";
	private final String SQL_INSERT_CATEGORIA = "insert into categoria(nome) values(?)";
	
	@Autowired
	public CategoriaDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Categoria getCategoriaByName(String nome) {
		return jdbcTemplate.queryForObject(SQL_GET_CATEGORIA, new Object[] { nome }, new CategoriaMapper());
	}

	public List<Categoria> getAllCategories() {
		return jdbcTemplate.query(SQL_GET_ALL, new CategoriaMapper());
	}

	public boolean deleteCategoria(Categoria categoria) {
		return jdbcTemplate.update(SQL_DELETE_CATEGORIA, categoria.getNome()) > 0;
	}

	public boolean createCategoria(Categoria categoria) {
		return jdbcTemplate.update(SQL_INSERT_CATEGORIA, categoria.getNome()) > 0;
	}

}
