package GPPM.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.BusinessDAO;
import GPPM.Entity.Business;


/**
 * Servlet implementation class SelectBusinessByAdminid
 */
@WebServlet("/admin/SelectBusinessByBusinessidServlet")
public class SelectBusinessByBusinessidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBusinessByBusinessidServlet() {
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
		int Businessid = (int)session.getAttribute("businessid");
		System.out.println(Businessid);
		
		BusinessDAO bdao = new BusinessDAO();
		Business business = bdao.SelectBusinessByBusinessid(Businessid);
		System.out.println(business.getBusinessname());
//		HttpSession session = request.getSession();
		session.setAttribute("business", business);
		response.sendRedirect("BusinessView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

