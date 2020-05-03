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
import GPPM.Entity.Good;

/**
 * Servlet implementation class SelectGoodByGoodidjspServlet
 */
@WebServlet("/admin/SelectGoodByGoodidjspServlet")
public class SelectGoodByGoodidjspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectGoodByGoodidjspServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		int Goodid = Integer.parseInt(request.getParameter("goodid"));
		
		GoodDAO gdao = new GoodDAO();
		Good good = new Good();
		good = gdao.SelectGoodByGoodid(Goodid);
		
		session.setAttribute("good", good);
		response.sendRedirect("UpdateGoodView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
