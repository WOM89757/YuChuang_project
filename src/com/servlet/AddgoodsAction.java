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
@MultipartConfig   /* ע���ʾ��servlet���Խ����ļ��������ע���л����������ļ��ϴ���һЩ���� */
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
	 


		// ��ȡ�ļ�
		Part part = request.getPart("file");
		if (null == part) {
			request.setAttribute("msg", "��ѡ��ο�ͼ");
			// ����ת��
			request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
			return;
		}
		//������ͷ��ȡ�ļ�����
		String headerName = part.getHeader("content-disposition").split(";")[2];
		int index = headerName.lastIndexOf(".");
		String fileType = headerName.substring(index, headerName.length() - 1);

		//�ж��ļ��Ƿ���ͼƬ
		boolean flag = false;
		for (int i = 0; i < types.length; i++) {
			if (fileType.equalsIgnoreCase(types[i])) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			request.setAttribute("msg", "�ļ���ʽ����ȷ�����ϴ�.jpg/.png��ͼƬ");
			// ����ת��
			request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
			return;
		}
		
		  //��֤�û���������
		  DBHelper db = new DBHelper();
			//��ȡ�ļ���
		  
			String fileName = part.getSubmittedFileName();
		  	//String realPath=request.getSession().getServletContext().getRealPath("/") ;
		  	String realPath=this.getServletContext().getRealPath("images"); 


		 // �ļ�����·��
		  	String filePath = realPath + "\\" + fileName;
			part.write(filePath); //����˱���
		  String insertsql = "insert into goods(goodsname,price,img,intro,description,sort)" + 
		  		"VALUES ( ?,?,?,?,?,?)";
		  HttpSession session = request.getSession();
		  try {
		  	int n = db.executeUpdate(insertsql, goodname,gprice, "images/"+fileName,intro,descri,sort);//���·��
		  	if(n>0) {
		  		
		  		request.setAttribute("msg", "��ӳɹ�");
		  		System.out.println("��ӳɹ�");
		  		//response.sendRedirect("register.jsp");
		  		request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
		  		
		  	}else {
		  		request.setAttribute("msg", "���ʧ��");
		          //����ת��
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
