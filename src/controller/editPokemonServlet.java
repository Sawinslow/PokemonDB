package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pokemon;

/**
 * Servlet implementation class editPokemonServlet
 */
@WebServlet("/editPokemonServlet")
public class editPokemonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editPokemonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PokemonHelper ph = new PokemonHelper();
		String name = request.getParameter("pokemonName");
		String type = request.getParameter("pokemonType");

		Integer Level = Integer.parseInt(request.getParameter("pokemonLevel"));
		Integer Health = Integer.parseInt(request.getParameter("pokemonHealth"));

		Integer tempID = Integer.parseInt(request.getParameter("ID"));

		Pokemon PokemontoUpdate = ph.searchForMovieById(tempID);

		PokemontoUpdate.setName(name);
		PokemontoUpdate.setType(type);
		PokemontoUpdate.setHp(Health);
		PokemontoUpdate.setLevel(Level);

		ph.updatePokemon(PokemontoUpdate);

		getServletContext().getRequestDispatcher("/viewAllPokemonServlet").forward(request, response);

	}

}
