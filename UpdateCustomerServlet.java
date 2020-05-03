package GPPM.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GPPM.DAO.CustomerDAO;
import GPPM.Entity.Customer;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/admin/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
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
				int customerid= Integer.parseInt(request.getParameter("customerid"));
				String password = request.getParameter("password");
				String customername = request.getParameter("customername");
				int tel= Integer.parseInt(request.getParameter("tel"));
				String  location = request.getParameter("location");
				//2.处理数据
				CustomerDAO cdao = new CustomerDAO();
				cdao.UpdateCustomer(customerid,password,customername,tel,location);
				//
			
				
				//3.跳转
				response.sendRedirect("QueryCustomerServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
