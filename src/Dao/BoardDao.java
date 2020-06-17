package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.BoardBean;



public class BoardDao {

	private static final String url = "jdbc:mysql://localhost:3306/BulletinBoard?serverTimezone=JST";
	private static final String user = "root";
	private static final String pw = "44237";



	public static ArrayList<BoardBean> selectAll(){

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "SELECT * FROM Board;";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<BoardBean> Boardlist = new ArrayList<BoardBean>();

			while( rs.next() ){
				int Id = rs.getInt("id");
				String Name = rs.getString("Name");
				String value = rs.getString("value");
				String mail = rs.getString("mail");
				String create_time = rs.getString("create_time");
				String editing_time = rs.getString("editing_time");
				String add = rs.getString("address");
				String picture = rs.getString("picture");
				BoardBean result = new BoardBean(Id,Name,value,mail,create_time,editing_time,add,picture);
				Boardlist.add(result);
			}

			System.out.println("⚠️ 参照：全部");

			return Boardlist;

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
		return null;
	}



	public static BoardBean insert(BoardBean boardbean){

		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "INSERT INTO Board VALUES(?,?,?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, boardbean.getId());
			pstmt.setString(2, boardbean.getName());
			pstmt.setString(3, boardbean.getValue());
			pstmt.setString(4, boardbean.getMail());
			pstmt.setString(5, boardbean.getTime());
			pstmt.setString(6, boardbean.getTime2());
			pstmt.setString(7, boardbean.getAdd());
			pstmt.setString(8, boardbean.getPicture());

			System.out.println("実行できてる");

			int result= pstmt.executeUpdate();

			System.out.println("⚠️ 挿入：" + result + "件");

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
		return boardbean;
	}



	public static BoardBean update(BoardBean boardbean){

		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "UPDATE board SET value=?,editing_time=? WHERE id = ? ";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,boardbean.getValue());
			pstmt.setString(2, boardbean.getTime2());
			pstmt.setString(3,new Integer(boardbean.getId()).toString());

			int result = pstmt.executeUpdate();

			System.out.println("⚠️ 更新：" + result + "件");

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
		return null;
	}



	public static void delete(String id){

		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "DELETE FROM board WHERE id = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,id);

			int result = pstmt.executeUpdate();

			System.out.println("⚠️ 削除：" + result + "件");

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
	}
}
