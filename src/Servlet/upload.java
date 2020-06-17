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
import javax.servlet.http.Part;

import Bean.BoardBean;
import Dao.BoardDao;

@WebServlet("/upload")
@MultipartConfig(maxFileSize=10485761) // 1Mまで
public class upload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF8");

    	Part part = request.getPart("file");

        String sample = this.getFileName(part);
        System.out.println("C:\\pleiades\\workspace\\BulletinBoard\\WebContent\\upload\\" + sample);

        part.write("C:\\pleiades\\workspace\\BulletinBoard\\WebContent\\upload\\" + sample);
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
				String editing_time= null;
				String address=request.getRemoteAddr();
				System.out.println(address);
				String picture="upload/"+sample;
				BoardBean s = new BoardBean(id,name,value,mail,create_time,editing_time,address,picture);
				BoardBean result = BoardDao.insert(s);
		//取得した値をリクエストスコープへ保存
		request.setAttribute("BoardBean", result);
		//インサートサーブレットからURL:TopPageへリダイレクトする
		 response.sendRedirect("/BulletinBoard/TopPage");
	}

    private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }
}
