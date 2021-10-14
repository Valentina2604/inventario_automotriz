package com.nexos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.nexos.entity.ProductosEntity;
import com.nexos.repository.ProductoRepositiry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductosService {
	
	@Autowired
	private ProductoRepositiry prodRepo;
	
	public ResponseEntity<ProductosEntity> registarMercancia(ProductosEntity productos) throws ParseException{
		List<ProductosEntity> busquedaId = prodRepo.findByIdproducto(productos.getIdproducto());
		String fechaActual = LocalDateTime.now().toString();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = formato.parse(fechaActual);
		Date fechaIngreso = formato.parse(productos.getFecha().toString());
		try {
			if (!busquedaId.isEmpty()) {
				  if (fechaIngreso.before(fecha) || fechaIngreso.equals(fecha)) {
					  if (!busquedaId.get(0).getNombre().equals(productos.getNombre())) {
							prodRepo.save(productos);
							log.info("Se registro mercancia con id " +  productos.getIdproducto() + "de manera correcta");
						}else {
							log.info("Ese producto ya se encuentra registrado");
						}
				  }else {
					  log.info("La fecha debe ser menor o igual a la actual");
				  }
			}else {
				if (fechaIngreso.before(fecha) || fechaIngreso.equals(fecha)) {
					prodRepo.save(productos);
					log.info("Se registro mercancia con id " +  productos.getIdproducto() + "de manera correcta");
				}else {
					  log.info("La fecha debe ser menor o igual a la actual");
				  }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ProductosEntity>(productos, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ProductosEntity> editarMercancia(ProductosEntity productos){
		try {
			List<ProductosEntity> busquedaId = prodRepo.findByIdproducto(productos.getIdproducto());
			if (!busquedaId.isEmpty()) {
				if (busquedaId.get(0).getUsuario().getIdusuario()==productos.getUsuario().getIdusuario()) {
					prodRepo.save(productos);
					log.info("Se actualizo mercancia con id " +  productos.getIdproducto() + "de manera correcta");
				}else {
					log.info("Usted no puede actualizar este producto");
				}
			}else {
				log.info("Este producto no existe en la base");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ProductosEntity>(productos, HttpStatus.OK);
	}
	
	public List<ProductosEntity> listarProd(){
		List<ProductosEntity> listaProductos = null;
		try {
			listaProductos = prodRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaProductos;
	}
}
