package it.polito.tdp.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnagrammiDAO {

	public String parolaEsistente(String p){
		
		Connection conn = connectDB.getConnection();
		
		String sql = "SELECT nome FROM parola WHERE nome = ?";
		
		
		PreparedStatement st;
		try{//Statement st = conn.createStatement();
			st = conn.prepareStatement(sql);
			st.setString(1, p);
			
			ResultSet res = st.executeQuery();
			if(res.next()){
				
				String fin = res.getString("nome");
				
				conn.close();
				res.close();
				return fin;
			}
			else{ 
				conn.close();
				res.close();
				return null;
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root";
	
	public String cerca(String nome){
		
		try {
			
			Connection conn = DriverManager.getConnection(jdbcURL);
		
			Statement st = conn.createStatement();
		
			String sql = "select nome from parola where nome=\"" + nome +"\"";
			
			ResultSet res = st.executeQuery(sql);
			
			if(res.next()){
				//found
				String nuova = res.getString("nome");
				
				res.close();
				conn.close();
				
				return nuova;
			} else{
				//not found
				res.close();
				conn.close();
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	*/
}
