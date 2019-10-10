package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllPokemonServlet
 */
@WebServlet("/ViewAllPokemonServlet")
public class ViewAllPokemonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllPokemonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PokemonHelper ph = new PokemonHelper();
		//Sending a list of all the pokemon over to the pokemon.jsp
		request.setAttribute("allPokemon", ph.showAllPokemon());
		
		//If the list is empty it sends the jsp page a empty string to display nothing
		if(ph.showAllPokemon().isEmpty()) {
			request.setAttribute("allPokemon", " ");
		}
		
		//Sending it off to the page
		getServletContext().getRequestDispatcher("/pokemon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
