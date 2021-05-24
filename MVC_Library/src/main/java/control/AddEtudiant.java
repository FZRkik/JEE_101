package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EtudiantManager;
import model.Etudiant;


@WebServlet("/AddEtudiant")

public class AddEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Etudiant et ;
	EtudiantManager aut ;
    public AddEtudiant() {
        super();
    }

    
	public void init(ServletConfig config) throws ServletException {
	    et= new Etudiant() ;
	    aut= new EtudiantManager() ;
	    
	 
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//	PrintWriter out = response.getWriter();
		  int u=0 ;
		 et.setLogin(request.getParameter("login"));
		et.setPassword(request.getParameter("password"));
		et.setRole( request.getParameter("role"));  
	
					try {
						u = aut.ajouterEtudiant(et);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
			if (u==1) {
				response.sendRedirect("Recherche.jsp");
			}
			else {
				response.sendError(500,"Ajout n'est pas effectué ");
			}
			
			
			
		
	}



}
