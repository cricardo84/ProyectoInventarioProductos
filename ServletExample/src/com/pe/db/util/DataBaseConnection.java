package com.pe.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pe.bean.Producto;

public class DataBaseConnection {

	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    String url = "jdbc:mysql://localhost:3306/inventario_productos";
    String username = "admin";
    String password = "admin";
    
    private void inicializarConexion() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        connect = DriverManager.getConnection(url, username, password);
    }
    
	public List<Producto> obtenerTodosLosProductos() throws Exception {
        try {
        	inicializarConexion();
        	
            statement = connect.createStatement();
            
            resultSet = statement.executeQuery("select * from producto");
            
            List<Producto> listadoProductos = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                int cantidad = resultSet.getInt("cantidad");
                
                Producto producto = new Producto();
                producto.setId(id);
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setCantidad(cantidad);
                
                listadoProductos.add(producto);
            }
            
            return listadoProductos;
        } catch (Exception e) {
            throw e;
        } finally {
        	connect.close();
        }

    }
	
	public void insertarProducto(Producto producto) throws Exception{
		try {
			inicializarConexion();
			
			//Para insertar registros en la BD
			preparedStatement = connect.prepareStatement("insert into  producto (nombre, descripcion, cantidad) values ( ?, ?, ?)");
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setString(2, producto.getDescripcion());
			preparedStatement.setInt(3, producto.getCantidad());
			
			//Para la ejecucion
			preparedStatement.executeUpdate();

		} catch (Exception e) {
            throw e;
        } finally {
        	 connect.close();
        }
	}
	
	public void eliminarProducto(String idProducto) throws Exception{
        try {
        	inicializarConexion();
			preparedStatement = connect.prepareStatement("delete from producto where id= ?");
			preparedStatement.setString(1, idProducto);
			preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
        	 connect.close();
        }
	}
}
