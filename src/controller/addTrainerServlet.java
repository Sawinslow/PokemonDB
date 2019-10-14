package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Party;
import model.Pokemon;
import model.Trainer;


/**
 * Servlet implementation class addTrainerServlet
 */
@WebServlet("/addTrainerServlet")
public class addTrainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTrainerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainerHelper th = new TrainerHelper();
		PokemonHelper ph = new PokemonHelper();
		String TrainerName = request.getParameter("TrainerName");
		System.out.println("Trainer name: " + TrainerName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		Integer numofBadges = Integer.parseInt(request.getParameter("numOfbadges"));
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedPokemon = request.getParameterValues("allPokemonToAdd");
		List<Pokemon> selectedPokemonInList = new ArrayList<Pokemon>();

		if (selectedPokemon != null && selectedPokemon.length > 0) {
			for (int i = 0; i < selectedPokemon.length; i++) {
				System.out.println(selectedPokemon[i]);
				Pokemon c = ph.searchForPokemonById(Integer.parseInt(selectedPokemon[i]));
				selectedPokemonInList.add(c);
			}
		}
		Trainer train = new Trainer (TrainerName, numofBadges,ld);
		Party Party = new Party();
		
		PartyHelper PartyHelper = new PartyHelper();
		
		Party.setTrainer(train);
		System.out.println(train);
		th.insertTrainer(train);
		System.out.println(train);
		Party.setPokemonParty(selectedPokemonInList);
		System.out.println(selectedPokemonInList);
		PartyHelper.insertParty(Party);
		System.out.println(Party);
		
		
		
		getServletContext().getRequestDispatcher("/ViewAllTrainersServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
