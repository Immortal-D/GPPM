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
 * Servlet implementation class QueryGoodServlet
 */
@WebServlet("/admin/QueryGoodServlet")
public class QueryGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryGoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//瑙ｅ喅浼犲洖鍊间腑鏂囬棶棰�
		request.setCharacterEncoding("UTF-8");
		String min ;
		String max ;
		String type ;
		String adaptsex ;
		
		HttpSession session = request.getSession();
		if(request.getParameter("minprice") == null)
			min = "null";
		else min = request.getParameter("minprice");
		if(request.getParameter("maxprice") == null)
			max = "null";
		else max = request.getParameter("maxprice");
		if(request.getParameter("type") == null)
			type = "null1";
		else type = request.getParameter("type");
		if(request.getParameter("adaptsex") == null)
			adaptsex = "null1";
		else adaptsex = request.getParameter("adaptsex");
		
		int minprice = 0;
		int maxprice = 9999999;
		//澶勭悊鏈�夋嫨绛涢�夋潯浠�
		if(min.equals("null")||min==null) {min="0";}
		minprice = Integer.parseInt(min);
		if(max.equals("null")||max==null) {max = "99999999";}
		maxprice = Integer.parseInt(max);
		
		GoodDAO gooddao = new GoodDAO();
		ArrayList glist = gooddao.queryGood(minprice,maxprice,type,adaptsex);
		
		session.setAttribute("glist", glist);
		response.sendRedirect("default.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
