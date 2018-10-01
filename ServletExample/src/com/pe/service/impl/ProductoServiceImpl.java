package com.pe.service.impl;

import java.util.List;

import com.pe.bean.Producto;
import com.pe.db.util.DataBaseConnection;
import com.pe.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	@Override
	public void registrarProducto(Producto producto) throws Exception {
			DataBaseConnection db = new DataBaseConnection();
			db.insertarProducto(producto);
	}

	@Override
	public List<Producto> buscarProductos() throws Exception {
		DataBaseConnection db = new DataBaseConnection();
		return db.obtenerTodosLosProductos();
	}

	@Override
	public void cambiarEstadoProduto(int productoId) throws Exception {
		DataBaseConnection db = new DataBaseConnection();
		db.cambiarEstadoProducto(productoId);
	}

	@Override
	public Producto obtenerProducto(int productoId) throws Exception {
		DataBaseConnection db = new DataBaseConnection();
		return db.obtenerProducto(productoId);
	}
	

}
