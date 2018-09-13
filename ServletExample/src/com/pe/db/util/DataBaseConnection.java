package com.pe.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    	// This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        // Setup the connection with the DB
        connect = DriverManager.getConnection(url, username, password);
    }
    
	public void obtenerTodosLosProductos() throws Exception {
        try {
        	inicializarConexion();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from producto");
            writeResultSet(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            cerrarConexion();
        }

    }
	
	public void insertarProducto(Producto producto) throws Exception{
		try {
			inicializarConexion();
			// PreparedStatements can use variables and are more efficient
			preparedStatement = connect.prepareStatement("insert into  producto (nombre, descripcion, cantidad) values ( ?, ?, ?)");

			// Parameters start with 1
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setString(2, producto.getDescripcion());
			preparedStatement.setInt(3, producto.getCantidad());
			preparedStatement.executeUpdate();

			//preparedStatement = connect.prepareStatement("SELECT * from producto");
			//resultSet = preparedStatement.executeQuery();
			//writeResultSet(resultSet);
		} catch (Exception e) {
            throw e;
        } finally {
            cerrarConexion();
        }
	}
	
	public void eliminarProducto(String idProducto) throws Exception{
        try {
        	inicializarConexion();
			preparedStatement = connect.prepareStatement("delete from producto where id= ?");
			preparedStatement.setString(1, idProducto);
			preparedStatement.executeUpdate();

			//resultSet = statement.executeQuery("select * from producto");
			//writeMetaData(resultSet);
        } catch (Exception e) {
            throw e;
        } finally {
            cerrarConexion();
        }
	}
	
	private void writeMetaData(ResultSet resultSet) throws SQLException {

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("id");
            String nombre = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");
            String cantidad = resultSet.getString("cantidad");
            
            System.out.println("id: " + id);
            System.out.println("nombre: " + nombre);
            System.out.println("descripcion: " + descripcion);
            System.out.println("cantidad: " + cantidad);
        }
    }

    private void cerrarConexion() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
