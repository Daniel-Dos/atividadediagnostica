package br.com.mastertech.danieldias.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mastertech.danieldias.model.Ponto;

public interface PontoRepositorio extends JpaRepository<Ponto, Integer>{ }
