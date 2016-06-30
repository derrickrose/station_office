package station.authentification.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import station.authentification.controlers.DefaultHandler;
import station.authentification.controlers.UserAccountHandler;

@WebServlet(description = "Building user account", urlPatterns = { "/BuildUserAccount" })
public class UserAccountBuilder extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String BUILD_USER_ACCOUNT_VIEW = "/buildUserAccount.jsp";

    /**
     * Default constructor.
     */
    public UserAccountBuilder() {

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// response.getWriter().append("Served at:
	// ").append(request.getContextPath());
	this.getServletContext().getRequestDispatcher(BUILD_USER_ACCOUNT_VIEW).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	UserAccountHandler userAccountHandler = UserAccountHandler.getUserAccountHandler();
	userAccountHandler.validateUserAccount(request);
	request.setAttribute(DefaultHandler.ERROR_MAP_FIELD, userAccountHandler.getError());
	request.setAttribute(DefaultHandler.MESSAGE_FIELD, userAccountHandler.getMessage());
	doGet(request, response);
    }

}
