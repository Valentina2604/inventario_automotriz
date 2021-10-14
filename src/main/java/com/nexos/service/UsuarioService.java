package com.nexos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.entity.UsuariosEntity;
import com.nexos.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuRepo;
	
	public List<UsuariosEntity> lista(){
		List<UsuariosEntity> listarTodos = null;
		try {
			listarTodos =  usuRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listarTodos;
	}
}
