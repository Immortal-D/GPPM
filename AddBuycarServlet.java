package GPPM.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.BuycarDAO;
import GPPM.Entity.BuyCar;

/**
 * Servlet implementation class AddBuycarServlet
 */
@WebServlet("/admin/AddBuycarServlet")
public class AddBuycarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBuycarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int goodid = Integer.parseInt(request.getParameter("goodid"));
		//System.out.println(goodid);
		int num = Integer.parseInt(request.getParameter("num"));
		//System.out.println(num);
		int customerid = (int)session.getAttribute("userid");
		int price = Integer.parseInt(request.getParameter("goodprice"));
		BuycarDAO buycardao = new BuycarDAO();
		buycardao.addBuycar(customerid,goodid,num,price);
		response.sendRedirect("BuyCar.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
