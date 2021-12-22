package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import po.User;
import service.UserService;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DoDelete")
public class DoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String name =  request.getParameter("id");
		if (name == null) {
			System.out.println("删除失败");
			response.sendRedirect("error404.jsp");
			return;
		}else {
			if (userService.DeleteUser(name)) {
				System.out.println("删除成功！");
				response.sendRedirect("usermessage.jsp");
				session.setAttribute("delete", "success");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
