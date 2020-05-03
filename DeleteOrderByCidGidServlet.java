package GPPM.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.OrderlistDAO;

/**
 * Servlet implementation class DeleteOrderByCidGidServlet
 */
@WebServlet("/admin/DeleteOrderByCidGidServlet")
public class DeleteOrderByCidGidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrderByCidGidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int customerid = Integer.parseInt(request.getParameter("cid"));
		int goodid = Integer.parseInt(request.getParameter("gid"));
		int businessid = Integer.parseInt(request.getParameter("bid"));
		System.out.println(1111111111);
		OrderlistDAO odao = new OrderlistDAO();
		odao.delOrderlist(customerid,goodid,businessid);
		HttpSession session = request.getSession();
		session.setAttribute("businessid", businessid);
		response.sendRedirect("SelectOrderlistByBidServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
