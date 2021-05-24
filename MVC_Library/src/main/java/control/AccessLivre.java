package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LivreManager;
import model.Livre;

@WebServlet("/AccessLivre")
public class AccessLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivreManager lm;
	
    public AccessLivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		lm=new LivreManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();  
		String rech=request.getParameter("recherche");
		String type=request.getParameter("type_rech");
		List<Livre> ls = null;
		
		
          /* if(request.getParameter("op").equals("delete")) {
			
			int id=Integer.parseInt(request.getParameter("id"));
			 int nb=lm.deleteLivre(id);}*/
		
		
		if(type.equals("Auteur")) {
			 ls=lm.searchLivByAuteur(rech); 
		}
		
		else {
			ls=lm.searchLivByCategory(rech);
		}
		
		if(ls== null) {
			response.sendError(404,"Aucun livre est compatible avec votre recherche");
		}
		
		else {
		out.print("<table width=60% bgcolor=#fff border=2> " );
		out.print("<thead> <th> Nom de Livre</th> <th> Nom de Auteur</th>"
				+ "<th>Date de Publication</th> <th> categorie</th> <th> <a href='Ajout.jsp'> Ajouter </a> </th> </thead> ");
		for(Livre l:ls) {
			out.print("<tbody>");
			out.print("<tr>");
			out.print("<td>"+l.getNom()+"</td>");
			out.print("<td>"+l.getAuteur()+" </td>");
			out.print("<td>"+l.getDatePub()+" </td>");
			out.print("<td>"+l.getCategory()+" </td>");
		// out.print("<td><a href='?op=delete&id="+l.getId()+"' >supprimer</a> </td>");
			out.print("</tbody>");
		}
		}
		

		
	
}

}
