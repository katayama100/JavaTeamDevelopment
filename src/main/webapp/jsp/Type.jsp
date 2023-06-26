<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
    <%
    
    String name = (String) request.getAttribute("name");
    String kanji = (String) request.getAttribute("kanji");
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="../css/Type.css" rel="stylesheet" type="text/css">


</head>
<body>
<h2>自己紹介の内容を記入して下さい</h2>


<form action="../Validate" method="POST" name="validataion">

<div class="box">
Your Name: 
<input type="text" style="width: 500px;" value="" name ="g_name" id="name">
</div>


<div class="box">
<p>フリガナ</p>
<input type="text" style="width: 500px;" value="">
</div>

<div class="box">
<p>性別</p>
<input type="text" style="width: 500px;" value="">
</div>

<div class="box">
<p>趣味</p>
<input type="text" style="width: 500px;" value="">
</div>

<div class="box">
<p>一言</p>
<input type="text" style="height: 200px; width: 500px ;" value="">
</div>

<div class="box">

<input type="submit" value="戻る" onClick="history.back()" class="but"></input>
<input type="submit" value="完了" class="but"></input>
</div>





<%
        if(request.getAttribute("error_msg")!=null){%>
                <%=request.getAttribute("error_msg") %>
        <%}
%>
</form>
</body>

</html>