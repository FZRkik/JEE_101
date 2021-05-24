package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Livre;

public class LivreManager {
	
	public int addLivre(Livre liv) {
	   Db_interaction.connect();
	 String query= "INSERT INTO livres (nom,auteur,date_pub,categorie)"
	   		+ " VALUES('"+liv.getNom()+"','"+liv.getAuteur()+"','"+liv.getDatePub()+"','"+liv.getCategory()+"');";
	   
	  //  String query= "INSERT INTO livres (nom,auteur,date_pub,categorie) VALUES('bbbb','4444','44444','444444');";
	   
	    int i=Db_interaction.maj(query);
	    
	    Db_interaction.disconnect();
	    
	return(i );
	}
	
	public List<Livre> searchLivByAuteur (String auteur) {
		List<Livre> ls=new ArrayList();
		Livre l;
		Db_interaction.connect();
		String query="select * from livres where auteur='"+auteur+"';";
		ResultSet st=Db_interaction.select(query);
		try {
			while(st.next()) {
				  l=new Livre() ;
				  l.setId(st.getInt(1));
				  l.setNom( st.getString(2) );
				  l.setAuteur( st.getString(3));
				  l.setCategory( st.getString(5));
				  l.setDatePub(st.getString(4));
			ls.add(l);	  	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Db_interaction.disconnect();
		return ls ;
	}
	
	
	public List<Livre> searchLivByCategory(String cat) {
		
		List<Livre> ls=new ArrayList();
		Livre l;
		
		Db_interaction.connect();
		String query="select * from livres where categorie='"+cat+"';";
		ResultSet st=Db_interaction.select(query);
		try {
			while(st.next()) {
				   l=new Livre() ;
				  l.setId(st.getInt(1));
				  l.setNom( st.getString(2) );
				  l.setAuteur( st.getString(3));
				  l.setCategory( st.getString(5));
				  l.setDatePub(st.getString(4));
			ls.add(l);	
	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Db_interaction.disconnect();
		return ls ;
		}
	
	
	public List<Livre> livreList () {
		List<Livre> ls=new ArrayList();
		Livre l;
		Db_interaction.connect();
		String query="select * from livres ;";
		ResultSet st=Db_interaction.select(query);
		try {
			while(st.next()) {
				  l=new Livre() ;
				  l.setId(st.getInt(1));
				  l.setNom( st.getString(2) );
				  l.setAuteur( st.getString(3));
				  l.setCategory( st.getString(5));
				  l.setDatePub(st.getString(4));
			ls.add(l);	  	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Db_interaction.disconnect();
		return ls ;
	}
	
	
	public int deleteLivre(int i) {
		Db_interaction.connect();
		
		String query="DELETE FROM livres WHERE id="+i+"; ";
		
				int nb=Db_interaction.maj(query);
				
				Db_interaction.disconnect();
				return nb ;
	}
	
	

}
