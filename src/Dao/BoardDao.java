package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.BoardBean;



public class BoardDao {
	//①DBアクセスに必要な情報の定数を定義

	//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
	private static final String url = "jdbc:mysql://localhost:3306/BulletinBoard?serverTimezone=JST";
	//ユーザ
	private static final String user = "root";
	//パスワード
	private static final String pw = "44237";


	//全件検索するSELECT文を実行するメソッドのサンプル
	public static ArrayList<BoardBean> selectValue(){
		//アクセスに必要な変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			//JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//データベースと接続する(コネクションを取ってくる)
			//第1引数→接続先URL
			//第2引数→ユーザ名
			//第3引数→パスワード
			con = DriverManager.getConnection(url, user, pw);

			//SQL文の元を作成する
			String sql = "SELECT * FROM Board;";

			//SQLを実行するための準備(構文解析)
			pstmt = con.prepareStatement(sql);

			//SQLを実行し、DBから結果を受領する
			rs = pstmt.executeQuery();

			//return用のArrayList生成
			ArrayList<BoardBean> Boardlist = new ArrayList<BoardBean>();

			//next()の戻り値がfalseになるまでResultSetから
			//データを取得してArrayListに追加していく
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
			//中身の詰まったArrayListを返却する
			System.out.println(Boardlist);
			return Boardlist;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑫DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
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

		//途中でExceptionが発生した時はnullを返す。
		return null;
	}
}
