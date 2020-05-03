package GPPM.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.BusinessDAO;
import GPPM.DAO.OrderlistDAO;
import GPPM.Entity.Business;
import GPPM.Entity.Orderlist;

/**
 * Servlet implementation class SelectOrderByIdServlet
 */
@WebServlet("/admin/SelectOrderByIdServlet")
public class SelectOrderByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOrderByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setCharacterEncoding("utf-8");
		
		int businessid = Integer.parseInt(request.getParameter("businessid"));
		System.out.println(businessid);
		
		OrderlistDAO odao = new OrderlistDAO();
		ArrayList clist = odao.SelectOrderlistByBusinessid(businessid);
		
		for(int i=0;i<clist.size();i++) {
			Orderlist order = (Orderlist)clist.get(i);
			System.out.println(order.getBuytime());
			System.out.println(order.getSituation());
			System.out.println(order.getCustomerid());
		    }
		
		
		HttpSession session = request.getSession();
		session.setAttribute("list", clist);
		response.sendRedirect("HandleOrder.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}