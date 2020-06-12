<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@ page import="Bean.BoardBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者画面</title>
</head>
<body>

<p>こちらは管理者ページ</p>
<!--投稿内容表示エリア開始-->
    <p align="center">掲示板</p>
    <table border="1" width="100" bgcolor="lavenderblush" align="center">
		<tr>
	        <th>投稿番号</th>
    			<th>投稿者名</th>
    			<th>投稿内容</th>
    			<th>e-mail</th>
	        <th>投稿日時</th>
	        <th>削除ボタン</th>
	        <th>投稿編集</th>
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
	        	<td><%=Board.getMail()%></td>
    			<td><%=Board.getTime() %></td>
          <td><form  action="/BulletinBoard/DeleteServlet1" method="get">
            <input type="hidden" name="id" value=<%=Board.getId() %>>
              <input type="submit"  value="削除"></form>
          </td>

          <td><form  action="/BulletinBoard/UpdateServlet" method="get">
            <input type="hidden" name="id" value=<%=Board.getId() %>>
            <textarea rows="5" cols="64" wrap="OFF" name="Value"></textarea>
              <input type="submit"  value="編集"></form>
          </td>

		</tr>
		<%
		}
		%>
		</table>
		<form  action="/BulletinBoard/TopPage" method="get">
              <input type="submit"  value="トップページに戻る"></form>
<!--投稿内容表示エリア終了-->
</body>
</html>
