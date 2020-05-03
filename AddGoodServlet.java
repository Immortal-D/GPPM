package GPPM.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.BusinessDAO;
import GPPM.DAO.GoodBusinessDAO;
import GPPM.DAO.GoodDAO;

/**
 * Servlet implementation class AddGoodServlet
 */
@WebServlet("/admin/AddGoodServlet")
public class AddGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodServlet() {
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
				int businessid = Integer.parseInt(request.getParameter("businessid"));
				int goodid = Integer.parseInt(request.getParameter("goodid"));
				String goodname = request.getParameter("goodname");
				int goodprice = Integer.parseInt(request.getParameter("goodprice"));
				int number = Integer.parseInt(request.getParameter("number"));
				String type = request.getParameter("type");
				String adaptsex = request.getParameter("adaptsex");
				//2.处理数据
				GoodDAO gdao = new GoodDAO();
				gdao.addGood(goodid, goodname, goodprice, number, type, adaptsex);
				GoodBusinessDAO gbdao = new GoodBusinessDAO();
				gbdao.addGoodBusiness(businessid, goodid);
				
				HttpSession session = request.getSession();
				session.setAttribute("businessid", businessid);
				//3.跳转
				response.sendRedirect("SelectGoodByBusinessidServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
