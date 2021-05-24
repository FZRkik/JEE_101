package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Etudiant;

public class EtudiantManager {
	
	
	public int ajouterEtudiant(Etudiant et ) throws SQLException, ClassNotFoundException {
		
		Db_interaction.connect();
		String query="INSERT INTO Library (login,pass_word,l_role) VALUES('"+et.getLogin()+"','"+et.getPassword()+"','"+et.getRole()+"');";
			int nb =Db_interaction.maj(query);
		Db_interaction.disconnect();
		return nb;
	}
	
	
	
	public Etudiant verifierEtudiant (String login, String password) throws SQLException, ClassNotFoundException {
		
		Etudiant et = null;
		Db_interaction.connect();
		String query="Select * from library where login='"+login+"'and pass_word='"+password+"';";
		ResultSet rs = Db_interaction.select(query);
		try {
			if(rs.next())
			{
				et = new Etudiant() ;
				et.setLogin(rs.getString(2));
				et.setPassword(rs.getString(3));
				et.setRole(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return et ; 
	}

}
