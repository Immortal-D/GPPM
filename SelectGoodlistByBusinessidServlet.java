package GPPM.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.GoodDAO;

/**
 * Servlet implementation class SelectGoodlistByBusinessidServlet
 */
@WebServlet("/admin/SelectGoodlistByBusinessidServlet")
public class SelectGoodlistByBusinessidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectGoodlistByBusinessidServlet() {
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
		System.out.println("pupupupu");
		GoodDAO gdao = new GoodDAO();
		ArrayList list = new ArrayList();
		list = gdao.SelectGoodByBusinessid(businessid);
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		response.sendRedirect("GoodView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
