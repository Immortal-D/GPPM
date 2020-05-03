package GPPM.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.OrderlistDAO;
import GPPM.Entity.Orderlist;



/**
 * Servlet implementation class QueryOrderServlet
 */
@WebServlet("/admin/QueryOrderServlet")
public class QueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int goodid = Integer.parseInt(request.getParameter("goodid"));
		//从session中取得customerid;
		int customerid = (int)session.getAttribute("userid");
		OrderlistDAO orderdao = new OrderlistDAO();
		Orderlist order = orderdao.queryByidOrder(customerid,goodid);
		if(order==null) {
			response.sendRedirect("order.jsp");
		}else {
			session.setAttribute("order", order);
			response.sendRedirect("orderpage.jsp");
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
