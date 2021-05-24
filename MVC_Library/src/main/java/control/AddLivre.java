package control;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LivreManager;
import model.Livre;


@WebServlet("/AddLivre")
public class AddLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private Livre l;  
     private LivreManager lm ;
    public AddLivre() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException {
      l=new Livre();
      lm=new LivreManager() ;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		l.setNom(request.getParameter("nom"));
		l.setAuteur(request.getParameter("auteur"));
		l.setDatePub(request.getParameter("pub"));
		l.setCategory(request.getParameter("cat"));
		
	 int nb=  lm.addLivre(l);
	   if (nb==1)
	   response.sendRedirect("Recherche.jsp");
	   else 
       response.sendError(505,"Ajout n'est pas effectué");	   
	   
	}

}
