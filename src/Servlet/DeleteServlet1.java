package Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DeleteDao;
/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/DeleteServlet1")
public class DeleteServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//formに入力された検索キー(パラメータ)を取得
				request.setCharacterEncoding("UTF-8");
				String Id =request.getParameter("id");
				DeleteDao I= new Dao.DeleteDao();
				I.DeleteDao(Id);
				System.out.println(Id);
					//結果画面へフォワード
				response.sendRedirect("/BulletinBoard/DeleteServlet");
//localhost:8080 http://192.168.140.128:8080/BulletinBoard/TopPage,http://localhost:8080
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
