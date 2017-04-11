package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;




public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma){
		
		String sql = "SELECT id, nome " +
					"FROM parola " +
					"WHERE nome =?";

		try {
			Connection conn = ConnectDB.getConnection();          
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);

			ResultSet rs = st.executeQuery();

			
			while(rs.next()){
				String stringa = rs.getString("nome");
				if(stringa.equals(anagramma)){
					return true;
				}
			}
			conn.close();
			return false;
			
				
		}catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

}
