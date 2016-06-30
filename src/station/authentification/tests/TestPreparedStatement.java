package station.authentification.tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/PreparedStatement" })
public class TestPreparedStatement extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	PrintWriter out = response.getWriter();
	out.append("PreparedStatement");

	String url = "jdbc:mysql://localhost:3306/test";
	String user = "root";
	String pass = "";

	Connection connection = null;
	PreparedStatement st = null;
	ResultSet res = null;

	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    connection = DriverManager.getConnection(url, user, pass);
	    st = connection.prepareStatement("select * from userdetails");
	    res = st.executeQuery();
	    while (res.next()) {
		int id = res.getInt("id");
		String firstName = res.getString("firstname");
		out.append("<div>Id: " + id + "<br/>Nom: " + firstName + "<br/>  </div>");
	    }

	} catch (Exception e) {
	    out.append("" + e.getMessage());
	} finally {
	    try {
		res.close();
		st.close();
		connection.close();
	    } catch (Exception e) {

	    }

	}

    }
}
