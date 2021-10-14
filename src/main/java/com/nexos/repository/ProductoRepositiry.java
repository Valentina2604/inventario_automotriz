package com.nexos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nexos.entity.ProductosEntity;

public interface ProductoRepositiry extends JpaRepository<ProductosEntity, Integer>{
	
	List<ProductosEntity> findByIdproducto(Integer idproducto);
	
}
