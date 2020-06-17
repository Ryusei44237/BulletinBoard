<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, Bean.BoardBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body ><!-- align="center" -->
	<header align="center">
		<p align="left"><a href="/BulletinBoard/contact.jsp" >削除：編集要請</a></p>
	    <h1>ローカル掲示板 </h1>
		<h2 align="right"><a href="https://w1589335795-r01675225.slack.com/home">（株）杉原コーポレーション</a></h2>
		<p align="right"><a href="/BulletinBoard/join.html" >(株)杉原コーポレーション採用ページ</a></p>
	</header>

	<table border="1" cellspacing="7" cellpadding="3" width="95%" bgcolor="#EFEFEF" align="center">
	<!--ここがタイトル-->
	<b> 1スレッド<font size="5" color="#FF0000">【掲示板ベータ】</font></b>
	<!--ここまで-->
	<%
	ArrayList<BoardBean> list = (ArrayList<BoardBean>)request.getAttribute("list");
	for(int i = 0 ; i < list.size() ; i++){
		BoardBean Board = list.get(i);
	%>
	  <dl class="thread" style="margin-top: 0px;"><dt class="net" title="">
	    <%=Board.getId() %><font color="green"><b><%=Board.getName() %>　:　<%=Board.getMail()%></b></font><%=Board.getTime() %>　　<%=Board.getTime2() %></dt>
	  <!--ここから本文-->
	  </style>
	  <dd class="net" style="white-space: pre-wrap;"><%=Board.getValue() %>
	  <% if (Board.getPicture() != null){ %>
	  <img id="img" src="<%=Board.getPicture() %>" style="max-width: 300px; max-height: 300px;">
	  <% } %>
	  <br>
	  </dd>
	<!--本文終了-->
	<%
	}
	%>
	<!-- ここまでが投稿エリア -->

	 	<dd title="" style="">
	      <form method="get" action="/BulletinBoard/InsertServlet" id="post" enctype="multipart/form-data">

	       <input type="submit" value="書き込む" name="submit"onclick="dotext()">
	        <label>名前：  <input name="Name" size="19" placeholder="杉原太郎"></label>
	        <label>E-mail：<input name="mail" size="19" placeholder="@morijyobi.ac.jp"></label><br>
	        <textarea rows="5" cols="64" wrap="OFF" name="Value" id="text" placeholder="投稿文を入力"></textarea>
	        <input type="submit" name="submit" value="画像を添付して送信"onclick="goServletUpload()" onclick="dotext()">
			<br><input type="file" name="file"/>
	      </form>
	      <form action="/BulletinBoard/DeleteServlet" name="key" method="get" align="right" >
				<input type="submit"value="管理者としてログイン" onclick="manage()">
			</form>
	    </dd>


	    <script src="https://code.jquery.com/jquery-3.5.1.min.js">
	    </script>

	    <script>

	    $('#post').submit(function(){
	        $('#post').hide();
	        var text = $('#text').val();
	        text = text.replace(/\n/g,'');
	        text = text.replace(/\s/g,'');
	        if(text == ''){
	            alert('入力されていません');
	            $('#post').show();
	            return false;
	        }else{
	            var escape_text = $('#text').val();
	            escape_text = escape_text.replace(/&/g,'&amp;');
	            escape_text = escape_text.replace(/'/g,"&#39;");
	            escape_text = escape_text.replace(/"/g,'&quot;');
	            escape_text = escape_text.replace(/>/g,'&gt;');
	            escape_text = escape_text.replace(/</g,'&lt;');
	            $('#text').val(escape_text);
	            return true;
	        }
	    });

	    function goServletUpload(){
	        document.getElementById('post').action = '/BulletinBoard/upload';
	        document.getElementById('post').method = 'post'
	    }
	    </script>


	  </dl>
	</table>
</body>
