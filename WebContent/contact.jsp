<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除：編集要請ページ</title>
</head>
<body>
	<p>削除：編集してもらいたい内容の投稿番号と時間を指定してください</p>
  <form class="" action="/BulletinBoard/DeleteServlet" method="post">
    <input type="number" min="1" max="1000"　placeholder="投稿番号">
    <textarea name="name" rows="8" cols="80" placeholder="削除内容"></textarea>
  </form>

</body>
</html>
