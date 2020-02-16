package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.db.DBHelper;


@WebServlet("/addgoods.action")
@MultipartConfig   /* 注解表示此servlet可以接受文件，在这个注解中还可以设置文件上传的一些配置 */
public class AddgoodsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddgoodsAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] types = { ".jpg", ".JPG",".jpeg", ".png", ".bmp", ".gif" };
		
	 	String goodname = request.getParameter("goodsname");
	 	String gprice = request.getParameter("gprice");
	 	String sort = request.getParameter("sort");
	 	String intro = request.getParameter("intro");
	 	String descri = request.getParameter("descri");
	 


		// 获取文件
		Part part = request.getPart("file");
		if (null == part) {
			request.setAttribute("msg", "请选择参考图");
			// 请求转发
			request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
			return;
		}
		//从请求头获取文件类型
		String headerName = part.getHeader("content-disposition").split(";")[2];
		int index = headerName.lastIndexOf(".");
		String fileType = headerName.substring(index, headerName.length() - 1);

		//判断文件是否是图片
		boolean flag = false;
		for (int i = 0; i < types.length; i++) {
			if (fileType.equalsIgnoreCase(types[i])) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			request.setAttribute("msg", "文件格式不正确，请上传.jpg/.png的图片");
			// 请求转发
			request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
			return;
		}
		
		  //验证用户名和密码
		  DBHelper db = new DBHelper();
			//获取文件名
		  
			String fileName = part.getSubmittedFileName();
		  	//String realPath=request.getSession().getServletContext().getRealPath("/") ;
		  	String realPath=this.getServletContext().getRealPath("images"); 


		 // 文件保存路径
		  	String filePath = realPath + "\\" + fileName;
			part.write(filePath); //服务端保存
		  String insertsql = "insert into goods(goodsname,price,img,intro,description,sort)" + 
		  		"VALUES ( ?,?,?,?,?,?)";
		  HttpSession session = request.getSession();
		  try {
		  	int n = db.executeUpdate(insertsql, goodname,gprice, "images/"+fileName,intro,descri,sort);//相对路径
		  	if(n>0) {
		  		
		  		request.setAttribute("msg", "添加成功");
		  		System.out.println("添加成功");
		  		//response.sendRedirect("register.jsp");
		  		request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
		  		
		  	}else {
		  		request.setAttribute("msg", "添加失败");
		          //请求转发
		  		request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
		  	}
		  } catch (SQLException e) {
		  	e.printStackTrace();
			request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
		  }


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
