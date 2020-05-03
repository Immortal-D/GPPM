package GPPM.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.GoodDAO;
import GPPM.DAO.OrderlistDAO;

/**
 * Servlet implementation class DeleteGoodByGoodidServlet
 */
@WebServlet("/admin/DeleteGoodByGoodidServlet")
public class DeleteGoodByGoodidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGoodByGoodidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int businessid = Integer.parseInt(request.getParameter("adminid"));
		int goodid = Integer.parseInt(request.getParameter("goodid"));
		System.out.println(222222);
		GoodDAO gdao = new GoodDAO();
		gdao.delGood(goodid);
		HttpSession session = request.getSession();
		session.setAttribute("businessid", businessid);
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
