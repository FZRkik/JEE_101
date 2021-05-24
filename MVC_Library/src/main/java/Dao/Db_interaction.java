package Dao;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	
	public class Db_interaction {
		static String url;
		static Connection con;
		static Statement st;
		
		public static void connect()
		{
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						 url = "jdbc:mysql://localhost/mydb";
						 con = DriverManager.getConnection(url,"root","a1k2f3m4@fatima");
						 st = con.createStatement();
					
					
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
		}
		public static int maj(String query)
		{
			int nb = 0;
			try {
				nb=st.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nb;
			
		}
		
		
		public static ResultSet select(String query)
		{
			ResultSet res=null;
			try {
				res=st.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return res;
		}
		
		
		public static void disconnect()
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 

}
