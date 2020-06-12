package Servlet;


import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.BoardBean;
import Dao.UpdateDao;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//formに入力された検索キー(パラメータ)を取得
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/mm/ss");
		        String time2 = sdf.format(timestamp);
		        System.out.println(time2);
				request.setCharacterEncoding("UTF-8");
				int Id = Integer.parseInt(request.getParameter("id"));
				String Value =request.getParameter("Value");
				String editing_time=time2;

				BoardBean s = new BoardBean(Id,Value,editing_time);
				//データベースから値を取得
				BoardBean result = UpdateDao.updateDao(s);
				//取得した値をリクエストスコープへ保存
				request.setAttribute("BoardBean", result);
				//結果画面へフォワード
				response.sendRedirect("/BulletinBoard/DeleteServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
