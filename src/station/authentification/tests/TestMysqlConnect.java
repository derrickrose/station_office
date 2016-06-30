package station.authentification.tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class testMysqlConnect
 */
@WebServlet("/testMysqlConnect")
public class TestMysqlConnect extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestMysqlConnect() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	PrintWriter out = response.getWriter();
	String url = "jdbc:mysql://localhost:3306/test";
	String user = "root";
	String password = "";
	Connection mysqlConnect = null;
	Statement state = null;
	ResultSet result = null;
	try {

	    Class.forName("com.mysql.jdbc.Driver");

	} catch (Exception e) {
	    out.append("class not found");

	}

	try {
	    mysqlConnect = (Connection) DriverManager.getConnection(url, user, password);

	    state = (Statement) mysqlConnect.createStatement();

	    result = state.executeQuery("select * from userdetails");

	    while (result.next()) {
		int id = result.getInt("id");
		String firstName = result.getString("firstname");
		out.append("<div>Id: " + id + "<br/>Nom: " + firstName + "<br/>  </div>");
	    }

	} catch (Exception e) {
	    out.append("Connection impossible");
	} finally {
	    if (mysqlConnect != null) {
		try {
		    result.close();
		    state.close();
		    mysqlConnect.close();
		} catch (Exception e) {
		    out.append("Close connection impossible");
		}
	    }
	}
	out.append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
