package station.authentification.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import station.authentification.controlers.DefaultHandler;
import station.authentification.controlers.UserAccountHandler;
import station.authentification.controlers.UserDetailsHandler;
import station.authentification.controlers.UserHandler;
import station.authentification.controlers.UserIdentityHandler;

@WebServlet(description = "Building user", urlPatterns = { "/BuildUser" })
public class UserBuilder extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String BUILD_USER_VIEW = "/buildUser.jsp";

    /**
     * Default constructor.
     */
    public UserBuilder() {

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// response.getWriter().append("Served at:
	// ").append(request.getContextPath());
	this.getServletContext().getRequestDispatcher(BUILD_USER_VIEW).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	UserHandler userHandler = UserHandler.getUserHandler(UserDetailsHandler.getUserDetailsHandler(),
		UserIdentityHandler.getUserIdentityHandler(), UserAccountHandler.getUserAccountHandler());
	userHandler.validateUser(request);
	request.setAttribute(DefaultHandler.ERROR_MAP_FIELD, userHandler.getError());
	request.setAttribute(DefaultHandler.MESSAGE_FIELD, userHandler.getMessage());
	// if (userHandler.getError() == null ||
	// userHandler.getError().isEmpty()) {
	// this.getServletContext().getRequestDispatcher("/RefactorUserDetails").forward(request,
	// response);
	// } else
	doGet(request, response);
    }

}
