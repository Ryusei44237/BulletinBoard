package Servlet;



import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@WebServlet("/InsertServlet")
@MultipartConfig(maxFileSize=10000000)
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//現在時刻の取得
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/mm/ss");
        String time = sdf.format(timestamp);
        System.out.println(time);
        //ここからDaoに挿入するデータ
				int id= 0;
				String name= request.getParameter("Name");
				if(name.equals("")){
					name="名無し";
					System.out.println(name);
				}
				String value= request.getParameter("Value");
				String create_time= time;
				String mail= request.getParameter("mail");
				if(mail.equals("")){
					mail="hogehoge@hoge.ac.jp";
				}
				String editing_time= null;
				String address=request.getRemoteAddr();
				System.out.println(address);
				String picture=null;
				BoardBean boardbean = new BoardBean(id,name,value,mail,create_time,editing_time,address,picture);
				BoardBean result = BoardDao.insert(boardbean);
		//取得した値をリクエストスコープへ保存
		request.setAttribute("BoardBean", result);
		//インサートサーブレットからURL:TopPageへリダイレクトする
		 response.sendRedirect("/BulletinBoard/TopPage");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//画像を取得
	}
}
