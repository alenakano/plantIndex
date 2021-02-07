package com.project.nakano.plantindex.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.nakano.plantindex.jpa.model.OutroNome;

public interface OutroNomeRepository extends JpaRepository<OutroNome, Long> {
	OutroNome findByNome(String nome);
}
