package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.BoardBean;



public class InsertDao {
	//①DBアクセスに必要な情報の定数を定義

	//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
	private static final String url = "jdbc:mysql://localhost:3306/BulletinBoard?serverTimezone=JST";
	//ユーザ
	private static final String user = "root";
	//パスワード
	private static final String pw = "44237";


	//INSERT文を実行するメソッドのサンプル
	//引数は登録したい情報が格納されたBean
	public static BoardBean InsertPost(BoardBean s){
		//②アクセスに必要な変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			//③JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//④データベースと接続する(コネクションを取ってくる)
			//第1引数→接続先URL
			//第2引数→ユーザ名
			//第3引数→パスワード
			con = DriverManager.getConnection(url, user, pw);

			//⑤SQL文の元を作成する
			//?をプレースホルダと言います。
			//後の手順で?に値を設定します。
			String sql = "INSERT INTO Board VALUES(?,?,?,?,?,?,?,?)";

			//⑥SQLを実行するための準備(構文解析)
			pstmt = con.prepareStatement(sql);

			//⑦プレースホルダに値を設定
			//第1引数→何番目の?に設定するか(1から数える)
			//第2引数→?に設定する値
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getValue());
			pstmt.setString(4, s.getMail());
			pstmt.setString(5, s.getTime());
			pstmt.setString(6, s.getTime2());
			pstmt.setString(7, s.getAdd());
			pstmt.setString(8, s.getPicture());

			System.out.println("実行できてる");
			//⑧SQLを実行し、DBから結果を受領する
			int result= pstmt.executeUpdate();
			System.out.println(result + "件登録されました。");

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑨DBとの切断処理
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
		return s;
	}
}
