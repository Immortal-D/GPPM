package GPPM.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.BusinessDAO;
import GPPM.DAO.CustomerDAO;
import GPPM.Entity.Business;
import GPPM.Entity.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//1.获取数据
		request.setCharacterEncoding("utf-8");
		int userid =  Integer.parseInt(request.getParameter("adminname"));
		String password = request.getParameter("adminpwd");
		
	int level = Integer.parseInt(request.getParameter("level"));
		if(level==1) 
		{
			CustomerDAO cdao = new CustomerDAO();
			if(cdao.login(userid, password)) 
			{
			HttpSession session = request.getSession();
		
			session.setAttribute("userid", userid);
		
			//3.跳转
			response.sendRedirect("/GPPM/admin/QueryGoodServlet");
			}
		     else {
			response.sendRedirect("/GPPM/Login.jsp");
		     }
	      }
	   
		////商家登录
		
	else if(level==2)
	   {
		BusinessDAO bdao = new BusinessDAO();
			if(bdao.login(userid, password)) 
			{
			HttpSession session = request.getSession();
		
			session.setAttribute("adminid", userid);
			//3.跳转
			response.sendRedirect("/GPPM/admin/BusinessFirstView.jsp");
			}
		     else {
			response.sendRedirect("/GPPM/Login.jsp");
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
