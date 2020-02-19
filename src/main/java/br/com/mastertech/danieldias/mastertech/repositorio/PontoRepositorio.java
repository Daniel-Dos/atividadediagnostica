package br.com.mastertech.danieldias.mastertech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mastertech.danieldias.model.Usuario;

public interface PontoRepositorio extends JpaRepository<Usuario, Integer>{ }
