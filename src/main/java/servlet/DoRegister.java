package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.User;
import service.UserService;

/**
 * Servlet implementation class DoRegister
 */
@WebServlet("/DoRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = null;
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String tel = request.getParameter("tel");
		int age = Integer.valueOf(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String yesorno = request.getParameter("yesorno");
		String password = request.getParameter("password");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = null;
		HttpSession session = request.getSession();
		try {
			date = simpleDateFormat.parse(request.getParameter("birth"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 
		 * System.out.println(name); System.out.println(tel); System.out.println(age);
		 * System.out.println(email); System.out.println(address);
		 * System.out.println(yesorno); System.out.println(password);
		 * System.out.println(date);
		 */
		if (name == null || name.equals("") || tel == null || tel.equals("") || email == null || email.equals("")
				|| address == null || address.equals("") || yesorno == null || yesorno.equals("") || password == null
				|| password.equals("") || date == null) {
			response.sendRedirect("register.jsp");
		} else {
			UserService userService = new UserService();
			user = new User(name, tel, age, email, address, yesorno, password, date);
			if (userService.AddUser(user)) {
				response.sendRedirect("usermessage.jsp");
				session.setAttribute("register", "success");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
