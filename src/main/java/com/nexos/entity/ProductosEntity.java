package com.nexos.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class ProductosEntity {
	
	@Id
	@Column(name="idProducto")
	private Integer idproducto;
	
	@Column(name="nombreProducto")
	private String nombre;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="fechaIngreso")
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private UsuariosEntity usuario;
	
	@Column(name="fechaModificacion")
	private LocalDateTime fechaModificacion = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name="usuarioModificacion")
	private UsuariosEntity usuarioMod;

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public UsuariosEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuariosEntity usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public UsuariosEntity getUsuarioMod() {
		return usuarioMod;
	}

	public void setUsuarioMod(UsuariosEntity usuarioMod) {
		this.usuarioMod = usuarioMod;
	}

	
	
}
