package cn.aura.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.aura.dao.MusicDao;
import cn.aura.domain.Music;

/**
 * 删除音乐连接操作对象
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置中文乱码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//获取需要删除的id
		String id = request.getParameter("id");
		
		//进行删除操作
		MusicDao musicDao = new MusicDao();
		Music music = musicDao.selectOne(Integer.parseInt(id));
		if(music != null){
			//查询当前的音乐文件
			File file = new File(request.getServletContext().getRealPath("/music") + "/" + music.getMurl());
			file.delete();
			System.out.println(file.getPath());
		}
		musicDao.del(Integer.parseInt(id));
		
		response.getWriter().write("删除成功！");
	}

}
