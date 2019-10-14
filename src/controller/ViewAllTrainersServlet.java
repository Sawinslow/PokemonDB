package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Party;

/**
 * Servlet implementation class ViewAllTrainersServlet
 */
@WebServlet("/ViewAllTrainersServlet")
public class ViewAllTrainersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllTrainersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartyHelper ph = new PartyHelper();
		
		//Sending the list to the JSP to be displayed
		request.setAttribute("allParties", ph.showAllParty());
		
		//Sending an empty string to the JSP if there's no parties
		if(ph.showAllParty().isEmpty()) {
			request.setAttribute("allParties", " "); 
		}
		
		//Sending the user to the page
		getServletContext().getRequestDispatcher("/trainers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
