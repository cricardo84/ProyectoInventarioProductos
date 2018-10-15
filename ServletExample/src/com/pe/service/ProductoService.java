package com.pe.service;

import java.util.List;

import com.pe.bean.Producto;

public interface ProductoService {
	
	void registrarProducto(Producto producto) throws Exception;
	List<Producto> buscarProductos() throws Exception;
	void cambiarEstadoProduto(int productoId) throws Exception;
	Producto obtenerProducto(int productoId) throws Exception;
	void modificarProducto(Producto producto) throws Exception;
	List<Producto> obtenerProductosActivos() throws Exception;
}
