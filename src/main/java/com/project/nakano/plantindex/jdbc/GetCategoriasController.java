package com.project.nakano.plantindex.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.nakano.plantindex.jdbc.dao.CategoriaDAO;
import com.project.nakano.plantindex.jdbc.model.Categoria;

@RestController
public class GetCategoriasController {

	@Autowired
	private CategoriaDAO categoriaDAO;

	@GetMapping("/categoriasDB")
	public void categorias() {

		System.out.println("As categorias são:");
		for (Categoria p : categoriaDAO.getAllCategories()) {
			System.out.println(p);
		}
	}
}
