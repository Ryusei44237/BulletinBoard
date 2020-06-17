<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, Bean.BoardBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿後のページ</title>
</head>
<body>
<!--投稿フォーム開始-->
  <form action="/BulletinBoard/InsertServlet" method="get" >
    投稿者名<br>
    <input type="text" name="Name"><br>
    投稿文<br>
    <input type="text" name="Value"><br>
    <input type="submit" value="投稿" onclick="submit()">
  </form>
<!--投稿フォーム終了-->
<!--投稿内容表示エリア開始-->
    <p	align="center">掲示板</p>
    <table border="1" width="100" bgcolor="lavenderblush" align="center">
			<tr>
				<th>id</th>
				<th>投稿者名</th>
				<th>投稿内容</th>
				<th>投稿日時</th>

			</tr>
		<%
		ArrayList<BoardBean> list = (ArrayList<BoardBean>)request.getAttribute("list");
		for(int i = 0 ; i < list.size() ; i++){
			BoardBean Board = list.get(i);
		%>
			<tr>
				<td><%=Board.getId() %></td>
				<td><%=Board.getName() %></td>
				<td><%=Board.getValue() %></td>
				<td><%=Board.getTime() %></td>

			</tr>
		<%
		}
		%>
		</table>
<!--投稿内容表示エリア終了-->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js">
    </script>
<!--ここからスクリプト-->
    <script>
    function submit(){
      //投稿者名と投稿内容をlogに表示
      var Name = $("#user_name").val();
      var value = $("#post_value").val();
      console.log(Name);
      console.log(value);
      //submitを押したときの時間を設定
      var weeks = new Array('日','月','火','水','木','金','土');
      var now = new Date();
      var year = now.getYear(); // 年
      var month = now.getMonth() + 1; // 月
      var day = now.getDate(); // 日
      var week = weeks[ now.getDay() ]; // 曜日
      var hour = now.getHours(); // 時
      var min = now.getMinutes(); // 分
      var sec = now.getSeconds(); // 秒

      if(year < 2000) { year += 1900; }
      // 数値が1桁の場合、頭に0を付けて2桁で表示する指定
      if(month < 10) { month = "0" + month; }
      if(day < 10) { day = "0" + day; }
      if(hour < 10) { hour = "0" + hour; }
      if(min < 10) { min = "0" + min; }
      if(sec < 10) { sec = "0" + sec; }

      console.log(now,year,month,day,week,hour,min,sec);
    }
    </script>


</body>
</html>
