package com.pe.db.util;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pe.bean.Producto;
import com.pe.bean.Usuario;

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
                boolean activo = resultSet.getBoolean("activo");
                
                Producto producto = new Producto();
                producto.setId(id);
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setCantidad(cantidad);
                producto.setActivo(activo);
                
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
			preparedStatement = connect.prepareStatement("insert into  producto (nombre, descripcion, cantidad, imagen) values ( ?, ?, ?, ?)");
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setString(2, producto.getDescripcion());
			preparedStatement.setInt(3, producto.getCantidad());
			preparedStatement.setBytes(4, producto.getImagen());
			
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
	
	public void registroUsuario(Usuario usuario) throws Exception {
		try {
			
			inicializarConexion();
			preparedStatement = connect.prepareStatement("insert into usuario (nombre,apellidos,usuario,contraseña) values (?, ?, ?, ?)");
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getApellidos());
			preparedStatement.setString(3, usuario.getUsuario());
			preparedStatement.setString(4, usuario.getContraseña());
			
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			connect.close();
		}
	}
	
	public boolean autenticacion(Usuario usuario) throws Exception {
			
		inicializarConexion();
		String consulta = "select * from usuario where usuario=? and contraseña=?";
		preparedStatement = connect.prepareStatement(consulta);
		preparedStatement.setString(1, usuario.getUsuario());
		preparedStatement.setString(2, usuario.getContraseña());
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.absolute(1)) {
			return true;
		}
		
		connect.close();
		return false;
	}

	public void cambiarEstadoProducto(int productoId) throws Exception{
		inicializarConexion();
		String cambiarEstadoProductoQuery = "UPDATE PRODUCTO set activo = (CASE activo WHEN false THEN true ELSE false END) where id = ?";
		preparedStatement = connect.prepareStatement(cambiarEstadoProductoQuery);
		preparedStatement.setInt(1, productoId);
		preparedStatement.executeUpdate();
		connect.close();
	}
	
	public Producto obtenerProducto(int productoId) throws Exception {

        	inicializarConexion();
        	
            statement = connect.createStatement();
            
            String consulta = "select * from producto where id=?";
            
            preparedStatement = connect.prepareStatement(consulta);
    		preparedStatement.setLong(1, productoId);

    		resultSet = preparedStatement.executeQuery();
    		
    		Producto producto = new Producto();
    		
    		while (resultSet.next()) {
	            Long id = resultSet.getLong("id");
	            String nombre = resultSet.getString("nombre");
	            String descripcion = resultSet.getString("descripcion");
	            int cantidad = resultSet.getInt("cantidad");
	            Blob imagen = resultSet.getBlob("imagen");
	            boolean activo = resultSet.getBoolean("activo");
	            
	            producto.setId(id);
	            producto.setNombre(nombre);
	            producto.setDescripcion(descripcion);
	            producto.setCantidad(cantidad);
	            
	            byte[] imagenProducto = imagen.getBytes(1, (int)imagen.length());
	            
	            producto.setImagen(imagenProducto);
	            producto.setActivo(activo);
    		}

            connect.close();
            return producto;
    }
	
	public void modificarProducto(Producto producto) throws Exception {
		
		inicializarConexion();
		String consulta = "UPDATE producto SET nombre=?, descripcion=?, cantidad=? WHERE id=?";
		preparedStatement = connect.prepareStatement(consulta);
		preparedStatement.setString(1, producto.getNombre());
		preparedStatement.setString(2, producto.getDescripcion());
		preparedStatement.setInt(3, producto.getCantidad());
		preparedStatement.setLong(4, producto.getId());
		
		preparedStatement.executeUpdate();
		connect.close();
	}
	
	public List<Producto> obtenerProductosActivos() throws Exception{
		
		inicializarConexion();
		
		statement = connect.createStatement();
        
        resultSet = statement.executeQuery("select * from producto where activo = 1");
		
		List<Producto> listadoProductos = new ArrayList<>();
		while(resultSet.next()) {
			
			 Long id = resultSet.getLong("id");
             String nombre = resultSet.getString("nombre");
             String descripcion = resultSet.getString("descripcion");
             int cantidad = resultSet.getInt("cantidad");
             boolean activo = resultSet.getBoolean("activo");
             
             Producto producto = new Producto();
             producto.setId(id);
             producto.setNombre(nombre);
             producto.setDescripcion(descripcion);
             producto.setCantidad(cantidad);
             producto.setActivo(activo);
             
             listadoProductos.add(producto);
		}
		
		return listadoProductos;
	}
	
}
