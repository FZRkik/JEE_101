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
import javax.servlet.http.HttpSession;

import Dao.EtudiantManager;
import model.Etudiant;

@WebServlet("/CheckEtudiant")
public class CheckEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Etudiant et;
       EtudiantManager mgr; 
  
    public CheckEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		et= new Etudiant() ;
		mgr = new EtudiantManager(); 
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			et =  mgr.verifierEtudiant(request.getParameter("login"),request.getParameter("password"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (et ==null)  {
		
			response.sendError(404,"le login ou le mot de passe est incorrect");
		}
		else {
			HttpSession s= request.getSession();
		    s.setAttribute("etudiant",et );
			response.sendRedirect("Recherche.jsp");
			
	}
	
	}
}
