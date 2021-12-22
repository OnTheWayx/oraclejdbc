package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.websocket.Session;

import org.apache.catalina.connector.Response;

import po.User;
import service.UserService;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**+
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = null;
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		if (uname == null || uname.equals("") || password == null || password.equals("")) {
			response.sendRedirect("login.jsp");
			return;
		}
		else {
			System.out.println(uname + " " + password);
			UserService userService = new UserService();
			user = userService.CheckUser(uname, password);
			if (user == null) {
				response.sendRedirect("login.jsp");
			}else {
				response.sendRedirect("usermessage.jsp");
				session.setAttribute("login", "success");
			}
		}
	}

}
