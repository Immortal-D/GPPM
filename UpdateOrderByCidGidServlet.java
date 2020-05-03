package GPPM.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.BusinessDAO;
import GPPM.DAO.OrderlistDAO;

/**
 * Servlet implementation class UpdateOrderByCidGidServlet
 */
@WebServlet("/admin/UpdateOrderByCidGidServlet")
public class UpdateOrderByCidGidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderByCidGidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取数据
			request.setCharacterEncoding("utf-8");
			int businessid = Integer.parseInt(request.getParameter("bid"));
			int customerid = Integer.parseInt(request.getParameter("cid"));
			int goodid = Integer.parseInt(request.getParameter("gid"));
			String situation = request.getParameter("transituation");
			System.out.println(businessid);
			System.out.println(customerid);
			System.out.println(goodid);
			System.out.println(situation);
			//2.处理数据
			OrderlistDAO odao = new OrderlistDAO();
			odao.UpdateOrderByCidGidServlet(businessid, customerid, goodid, situation);
			HttpSession session = request.getSession();
			session.setAttribute("businessid", businessid);
			//3.跳转
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
