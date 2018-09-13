package com.pe.service.impl;

import com.pe.bean.Producto;
import com.pe.db.util.DataBaseConnection;
import com.pe.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	@Override
	public void registrarProducto(Producto producto) throws Exception {
		try {
			DataBaseConnection db = new DataBaseConnection();
			db.insertarProducto(producto);
		} catch (Exception e) {
			 throw e;
		}
	}

}
