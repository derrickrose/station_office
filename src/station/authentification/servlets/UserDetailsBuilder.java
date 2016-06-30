package station.authentification.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import station.authentification.controlers.DefaultHandler;
import station.authentification.controlers.UserDetailsHandler;

@WebServlet(description = "Building user details", urlPatterns = { "/BuildUserDetails" })
public class UserDetailsBuilder extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String BUILD_USER_DETAILS_VIEW = "/buildUserDetails.jsp";

    /**
     * Default constructor.
     */
    public UserDetailsBuilder() {

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	this.getServletContext().getRequestDispatcher(BUILD_USER_DETAILS_VIEW).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	UserDetailsHandler userDetailsHandler = UserDetailsHandler.getUserDetailsHandler();
	userDetailsHandler.validateUserDetails(request);
	request.setAttribute(DefaultHandler.ERROR_MAP_FIELD, userDetailsHandler.getError());
	request.setAttribute(DefaultHandler.MESSAGE_FIELD, userDetailsHandler.getMessage());
	doGet(request, response);
    }

}
