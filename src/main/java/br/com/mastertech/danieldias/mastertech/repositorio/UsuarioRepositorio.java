package br.com.mastertech.danieldias.mastertech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mastertech.danieldias.model.Ponto;

public interface UsuarioRepositorio extends JpaRepository<Ponto, Integer>{ }
