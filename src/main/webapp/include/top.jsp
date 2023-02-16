<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@	taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    

    <%
    String path=request.getContextPath();
    String id =(String)session.getAttribute("id");
    String id1 =(String)session.getAttribute("id1"); 
	%>
  
    



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table{
 border-spacing: 0 20px;
  
}
#loginck{
 border-radius: 10px;
    line-height: 20px;
    font-size: 20px;
     
    padding-left: 50px;
    padding-right: 50px;
    text-align:center;
    display: block;
    margin: 4px 79px 0 10px;

}



input{
    
    border-radius: 10px;
    line-height: 20px;
    font-size: 20px;
     
    padding-left: 50px;
    padding-right: 50px;
    text-align:center;
    display: block;
    margin: 4px 79px 0 10px;

}
file{
 border-radius: 10px;
    line-height: 20px;
    font-size: 20px;
     
    padding-left: 50px;
    padding-right: 50px;
    text-align:center;
    display: block;
    margin: 4px 79px 0 10px;
}


body{
width: 80%; margin: auto;
}
header {
	font-style: oblique;
}
nav{
height:40px;  line-height: 40px; background:#ffffcc;
 text-align: left;
}

section{

	min-height:500px; 
	 
}

footer{


}

.img{
 	margin:30px 30px;

}


.t.1{
 background:#cccccc
}

hr{
 height: 5px;
 background: #ccc;
}
#ch1,#ch{
  border-radius: 5px;
    line-height: 10px;
    font-size: 10px;
     
    padding-left: 10px;
    padding-right: 10px;
    text-align:center;
    display: block;
    margin: 4px 10px 0 10px;
}
.tab{
border-spacing: 0 1px;

}

.td.1{
 border-left: none;
 border-right: none;

}

table.table1{
	 border-collapse: separate;
  	 border-spacing: 1px;
 	 text-align: left;
  	 line-height: 1.5;
  	 border-top: 1px solid #ccc;
 	 margin : 20px 10px;

}

table.table1 th {
  width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-bottom: 1px solid #ccc;

}

table.table1 td {
  width: 350px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;

}
#e1,#e2,#e3{
border-radius: 5px;
    line-height: 10px;
    font-size: 10px;
     
    padding-left: 1px;
    padding-right: 1px;
    text-align:center;
    display: block;
    margin: 4px 10px 0 10px;
}



</style>

<body>
<header>

<div align="center">
	<h1><b>독 서 왕</b></h1>
	<%if(id!=null){%>
		<h2>(<%=id %>)님</h2>
	
	<%} %>
	
	<br>
</div>
 <div align="right">


   <%if(id!=null){%>
		<a href="<%=path %>/logout.do">로그아웃</a>&emsp;
  		<a href="<%=path%>/edit.do?id=<%=id%>">내정보</a>&emsp;
	
	<%}else{%>
		
	<a href="<%=path %>/Login/Login.jsp">로그인</a>&emsp;
 	<a href="<%=path %>/Login/insertLogin.jsp">회원가입</a>&emsp;
	<%}%>
  
 </div>

</header>
<nav>

&emsp;<a href="">스터디 모집</a>
&emsp;<a href="?">자유 게시판</a>
&emsp;<a href="<%=path%>/bookselect.do">책 소개</a>

 
</nav>

