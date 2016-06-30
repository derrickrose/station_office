package station.authentification.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import station.authentification.controlers.DefaultHandler;
import station.authentification.controlers.UserIdentityHandler;

@WebServlet(description = "Building user identity", urlPatterns = { "/BuildUserIdentity" })
public class UserIdentityBuilder extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String BUILD_USER_IDENTITY_VIEW = "/buildUserIdentity.jsp";

    /**
     * Default constructor.
     */
    public UserIdentityBuilder() {

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// response.getWriter().append("Served at:
	// ").append(request.getContextPath());
	this.getServletContext().getRequestDispatcher(BUILD_USER_IDENTITY_VIEW).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserIdentityHandler userIdentityHandler = UserIdentityHandler.getUserIdentityHandler();
	userIdentityHandler.validateUserIdentity(request);
	request.setAttribute(DefaultHandler.ERROR_MAP_FIELD, userIdentityHandler.getError());
	request.setAttribute(DefaultHandler.MESSAGE_FIELD, userIdentityHandler.getMessage());
	doGet(request, response);
    }

}
