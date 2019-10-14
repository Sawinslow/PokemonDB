package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Party;
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
		PartyHelper partyHelp = new PartyHelper();
		String action = request.getParameter("formAction");
		
		if(action.equals("edit Pokemon")) {
			Integer tempID = Integer.parseInt(request.getParameter("id"));
		Pokemon pokemonToEdit = ph.searchForPokemonById(tempID);
		System.out.println(pokemonToEdit);
		request.setAttribute("pokemonToEdit", pokemonToEdit);
		getServletContext().getRequestDispatcher("/editPokemon.jsp").forward(request,response);
		}
		
		else if(action.equals("delete trainer")) {
			try {
				//Getting the id the user selected
				Integer idToDelete = Integer.parseInt(request.getParameter("id"));
				//Searches for which list details it is in the database and assigns it to new list details
				Party trainerToDelete = partyHelp.searchForTrainerById(idToDelete);
				//Deletes it from the database
				partyHelp.deleteTrainer(trainerToDelete);
			}catch(NumberFormatException e) {
				System.out.println("Forgot to click button");
			}finally {
				//refreshes
				getServletContext().getRequestDispatcher("/ViewAllTrainersServlet").forward(request, response);
			}
		}
		
		else if(action.equals("delete Pokemon")) {
			try {
				Integer idToDelete = Integer.parseInt(request.getParameter("id"));
				Pokemon pokemonToDelete = ph.searchForPokemonById(idToDelete);
				ph.deletePokemon(pokemonToDelete);
				
			}catch(NumberFormatException e) {
				System.out.println("Didn't hit button");
			}finally {
				getServletContext().getRequestDispatcher("/ViewAllPokemonServlet").forward(request, response);
			}
		}
		
	}

}
