package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pokemon;

/**
 * Servlet implementation class navigationServelt
 */
@WebServlet("/navigationServelt")
public class navigationServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PokemonHelper ph = new PokemonHelper();
		Integer tempID = Integer.parseInt(request.getParameter("id"));
		Pokemon pokemonToEdit = ph.searchForPokemonById(tempID);
		System.out.println(pokemonToEdit);
		request.setAttribute("pokemonToEdit", pokemonToEdit);
		getServletContext().getRequestDispatcher("/editPokemon.jsp").forward(request,response);
	}

}
