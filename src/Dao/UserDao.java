package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.UserBean;



public class UserDao {

	private static final String url = "jdbc:mysql://localhost:3306/BulletinBoard?serverTimezone=JST";
	private static final String user = "root";
	private static final String pw = "44237";


	public static UserBean UserInsert(UserBean userbean){

		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "INSERT INTO user VALUES(?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userbean.getName());
			pstmt.setString(2, userbean.getPass());

			System.out.println("実行できてる");

			int result= pstmt.executeUpdate();
			System.out.println(result + "件登録されました。");

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {

			try {

				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return userbean;
	}
}
