<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
var  path='${pageContext.request.contextPath}';


jQuery.ajaxSetup({cache:false});

$(function(){
	  $('#ck').click( function(){
		 		
		 $.ajax({
				type : "GET",
				url : path +"/Login.do" ,
				data : {
					id : $('#id').val(),
					pwd : $('#pwd').val()
				} ,
				success : function (data) {
					if(data==0){
						alert("아이디 비밀번호를 다시 입력하세요");
						$('#id').val();
						$('#id').focus();
					}else{
						location.href=path +"/index.jsp"
						
						
					}
					
				}
		 
		 }) 
	  })
	  
}) 
</script>

<section>
<br>
<div align="center">
	<h2>Login</h2> 
</div>

<div align="center">
	<form action="insertLogin.jsp">
		<h3>ID</h3>
		<input type="text" name=id id="id">
	
		<h3>PASSWORD</h3>
		<input type="password" name=pwd id="pwd"  >
		<br><br>
		<input type="button" value="로그인" id="ck" size="1">
		<input type="submit" value="회원가입" size="1">
		</form>
	
</div>
</section>	



<%@ include file="../include/bottom.jsp" %>
