package br.com.mastertech.danieldias.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mastertech.danieldias.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{ }