package com.nexos.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.entity.ProductosEntity;
import com.nexos.entity.UsuariosEntity;
import com.nexos.service.ProductosService;
import com.nexos.service.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/inventario")
public class Controller {
	
	@Autowired
	private ProductosService prodService;
	@Autowired
	private UsuarioService usuService;
	
	@PostMapping("/registrarMercancia")
	public ResponseEntity<ProductosEntity> registrar(@RequestBody ProductosEntity prod) throws ParseException{
		return prodService.registarMercancia(prod);
	}
	
	
	@PostMapping("/editarMercancia")
	public ResponseEntity<ProductosEntity> editar(@RequestBody ProductosEntity prod) {
		return prodService.editarMercancia(prod);
	}
	
	@GetMapping("/listarUsuarios")
	public List<UsuariosEntity> listar() {
		return usuService.lista();
	}
	
	@GetMapping("/listarProductos")
	public List<ProductosEntity> listarProductos() {
		return prodService.listarProd();
	}
}
