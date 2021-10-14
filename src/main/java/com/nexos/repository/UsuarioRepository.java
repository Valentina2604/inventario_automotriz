package com.nexos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexos.entity.UsuariosEntity;

public interface UsuarioRepository extends JpaRepository<UsuariosEntity, Integer>{
	
	
}
