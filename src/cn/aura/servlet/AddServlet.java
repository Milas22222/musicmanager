package cn.aura.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.aura.dao.MusicDao;
import cn.aura.domain.Music;
import cn.aura.utils.PinYinUtils;

/**
 * 添加音乐文件
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String mname;
	private String author;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置中文乱码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
        	//获取到前端页面上传文件
			List<FileItem> files = upload.parseRequest(request);
			for (FileItem fileItem : files) {
				//判断表单中数据是否是文件
				if(fileItem.isFormField()){
					if(fileItem.getFieldName().equals("mname")){
						mname = fileItem.getString("UTF-8");
					}
					if(fileItem.getFieldName().equals("author")){
						author = fileItem.getString("UTF-8");
					}
					
				}else{
					
					//设置本地地址，通过对象动态获取。
					String path = request.getServletContext().getRealPath("/music");
					//将中文，修改为拼音
					String fName = PinYinUtils.ToPinyin(mname) + ".mp3";
					//定义上传文件的完整路径
	                String filePath = String.format("%s/%s",path,fName);
	                File storeFile = new File(filePath);
	                //进行文件复制
	                InputStream is = fileItem.getInputStream();
	                FileOutputStream fos = new FileOutputStream(storeFile);
	                byte[] buffer = new byte[1024];
	                int len = 0;
	                while ((len = is.read(buffer)) != -1) {
						fos.write(buffer, 0, len);
						fos.flush();
					}
	                is.close();
	                fos.close();
	                
	                //创建对象存储信息
	                Music music = new Music();
	                music.setMname(mname);
	                music.setAuthor(author);
	                music.setMurl(fName);
	                
	                //创建Dao存储
	                MusicDao musicDao = new MusicDao();
	                musicDao.add(music);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
        //跳转到首页
        response.sendRedirect("/MusicManagement/index.jsp");
	}
}
