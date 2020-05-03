package GPPM.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.CustomerDAO;
import GPPM.Entity.Customer;


/**
 * Servlet implementation class QueryCustomerServlet
 */
@WebServlet("/admin/QueryCustomerServlet")
public class QueryCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.处理数据
		HttpSession session = request.getSession();
	      // Customer cust=(Customer)session.getAttribute("cust");
		   int userid =(int)session.getAttribute("userid");
				CustomerDAO cdao = new CustomerDAO();
				
				Customer cust=cdao.queryCust(userid);//查询id为？的所有信息
				
				
				
				session.setAttribute("cust", cust);
				//3.跳转
				response.sendRedirect("Selectcustinf.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
