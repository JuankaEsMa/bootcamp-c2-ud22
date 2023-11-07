package UD22_Cliente.UD22_Cliente.connection.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConexionSQL{
	
	
	public Connection conexion;
	public String dataBase;
	private String port = "3306";;
	private String username = "root";
	private String password = "root";
	public ConexionSQL(){

	}
	public ConexionSQL(String port, String username, String password){
		if(!port.isEmpty()) {
			this.port = port;
		}
		if(!username.isEmpty()) {
			this.username = username;
		}
		if(!password.isEmpty()) {
			this.password = password;
		}
	}
	
	public boolean conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:"+port, username, password);
			return true;
		}catch(SQLException | ClassNotFoundException ex) {
			return false;
		}
	}
	
	public boolean conectarDb(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("jdbc:mysql://localhost:"+port);
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:"+port+"/"+name, username, password);
			return true;
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage() + "Fallo al connectar");
			return false;
		}
	}	
	public void desconectar() {
		try {
			conexion.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean createDB(String name) {
		try {
			String query = "CREATE DATABASE " + name;
			Statement st = conexion.createStatement();
			st.execute("drop database if exists "+ name);
			st.executeUpdate(query);
			desconectar();
			conectarDb(name);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo al crear");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean createTable(String table, String atributos) {
		try {
			String query = "create table " + table + " (" + atributos + ");";
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo al crear");
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean insertIntoTable(String table,String campos, String tuplas) {
		try {
			String query = "insert into " + table + campos + " values " + tuplas;
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo al crear");
			System.out.println(e.getMessage());
			return false;
		}
	}
	public ArrayList<String> getAllTable(String table, int numCampos){
		try {
			ArrayList<String> campos = new ArrayList<String>();
			String query = "select * from "+table;
			Statement statement = conexion.createStatement();
			ResultSet st = statement.executeQuery(query);
			while(st.next()){
				for (int i = 1; i <= numCampos; i++) {
					campos.add(st.getString(i));
				}
			}
			return campos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}
	public ArrayList<String> getAllTableWithWhere(String table, int numCampos, String where){
		try {
			ArrayList<String> campos = new ArrayList<String>();
			String query = "select * from " + table + " where " + where;
			Statement statement = conexion.createStatement();
			ResultSet st = statement.executeQuery(query);
			while(st.next()){
				for (int i = 1; i <= numCampos; i++) {
					campos.add(st.getString(i));
				}
			}
			return campos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}
	public boolean updateTableWithId(String table, String queryUpdate, String id) {
		try {
			String query = "update " + table + " set " + queryUpdate + " where id=" + id;
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			System.out.println("Updateado");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo al Updatear");
			System.out.println(e.getMessage());
			return false;
		}
	}
	public void deleteTableWithId(String table, String id) {
		try {
			String query = "delete from " + table + " where id=" + id;
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			System.out.println("Borrado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo al Borrar");
			System.out.println(e.getMessage());
		}
	}
}
