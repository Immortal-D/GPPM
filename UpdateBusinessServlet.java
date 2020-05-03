package GPPM.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GPPM.DAO.BusinessDAO;


/**
 * Servlet implementation class UpdateBusinessServlet
 */
@WebServlet("/admin/UpdateBusinessServlet")
public class UpdateBusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBusinessServlet() {
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
		String businessname = request.getParameter("businessname");
		int businesstel = Integer.parseInt(request.getParameter("businesstel"));
		String businessaddress = request.getParameter("businessaddress");
		System.out.println(businessid);
		System.out.println(businessname);
		System.out.println(businesstel);
		System.out.println(businessaddress);
		//2.处理数据
		BusinessDAO bdao = new BusinessDAO();
		bdao.UpdateBusiness(businessid, businessname, businessaddress, businesstel);
		HttpSession session = request.getSession();
		session.setAttribute("businessid", businessid);
		//3.跳转
		response.sendRedirect("SelectBusinessByBusinessidServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
