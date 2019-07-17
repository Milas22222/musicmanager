package cn.aura.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.aura.dao.UserDao;
import cn.aura.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//第一步：设置中文编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
				
		//第二步：获取前端页面提交数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		//第三步：调用Dao对象进行操作
		UserDao loginDao = new UserDao();
		User user = loginDao.login(username, password);
				
		//第四步：判断是否登录成功
		if(user != null){
			//登录成功
			response.sendRedirect("/MusicManagement/index.jsp");
		}else {
			//登录失败
			response.sendRedirect("/MusicManagement/login.jsp");
		}
	}
}
