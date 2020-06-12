package Servlet;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.BoardBean;
import Dao.BoardDao;

/**
 * Servlet implementation class TopServlet
 */
//①最初にアクセスされるURL
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address=request.getRemoteAddr();
		if(address.equals( "0:0:0:0:0:0:0:1")){
			//ArrayListを作ってListの中に全件検索のdaoのメソッドで得た値を代入する
			ArrayList<BoardBean> Boardlist = new ArrayList<BoardBean>();
			Boardlist = BoardDao.selectValue();
			request.setAttribute("list", Boardlist);
			//②サーブレットからJSPの呼び出し
			String view = "/WEB-INF/view/delete.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}else{
			request.setAttribute("false", null);
			response.sendRedirect("/BulletinBoard/TopPage");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
