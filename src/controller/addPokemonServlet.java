package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pokemon;

/**
 * Servlet implementation class addPokemonServlet
 */
@WebServlet("/addPokemonServlet")
public class addPokemonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addPokemonServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pokemonName = request.getParameter("name");
		String Type = request.getParameter("Type");
		int Level = Integer.parseInt(request.getParameter("level"));
		int HP = Integer.parseInt(request.getParameter("hp"));
		
		Pokemon po = new Pokemon(pokemonName,Type,Level,HP);
		PokemonHelper Poh = new PokemonHelper();
		Poh.insertPokemon(po);
		getServletContext().getRequestDispatcher("/index.html").forward(request,response);
		
	}

}
