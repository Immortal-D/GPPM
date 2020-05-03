package GPPM.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GPPM.DAO.BusinessDAO;
import GPPM.DAO.CustomerDAO;
import GPPM.Entity.Business;
import GPPM.Entity.Customer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		int level = Integer.parseInt(request.getParameter("level"));
		//System.out.println(level);
		if(level==1)
		{
			//顾客注册
			//1.获取数据
			

			int id=Integer.parseInt(request.getParameter("adminid"));
			String password = request.getParameter("adminpsw");
			String name = request.getParameter("adminname");
			int tel=Integer.parseInt(request.getParameter("admintel"));
			String  location = request.getParameter("adminaddress");
			//2.处理数据
			Customer cust = new Customer(id,password,name,location,tel);
			CustomerDAO cdao= new CustomerDAO();
			cdao.addCustomer(cust);
			//3.跳转
			 
			response.sendRedirect("/GPPM/Login.jsp");
			
	}
		
		else if(level==2){
			
			//System.out.println("shangjaizhuce!");
			
			

			int id=Integer.parseInt(request.getParameter("adminid"));
			String password = request.getParameter("adminpsw");
			String name = request.getParameter("adminname");
			int tel=Integer.parseInt(request.getParameter("admintel"));
			String  location = request.getParameter("adminaddress");
			//2.处理数据
			Business busin = new Business(id,password,name, tel,location);
			BusinessDAO bdao= new BusinessDAO();
			bdao.addBusiness(busin);
			//3.跳转
		

			response.sendRedirect("/GPPM/Login.jsp");
			//商家注册
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
