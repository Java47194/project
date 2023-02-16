<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../include/top.jsp"%>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
var  path='${pageContext.request.contextPath}';


jQuery.ajaxSetup({cache:false});

$(function(){
	 $('#del').click( function () {
		 
		 $.ajax({
			 type : "GET",
			 url : path +"/bookdelete.do" ,
			 data : {
				 seq : $('#seq').val()
			 },
			 success: function (data) {
				alert("삭제되었습니다.")
				location.href=path +"/bookselect.do"
			}
			 
		 })
	})
	$('#ch').click(function () {
		alert("로그인후 댓글 입력해주세요")
		location.href=path +"/Login/Login.jsp"
	})
	
	$('#e1').click(function () {
		
	})

	
})

	function ck1() {
		if(f1.tag.value==""){
			alert("댓글을 입력하세요");
			f1.tag.focus();
			return false;
		}
	}
	
	function del2(k1,k2) {
		// alert("삭제" + k1+","+k2) 
		var dataStr ={ idx: k1 , seq:k2 };
		
		 $.ajax({
			 type : "GET",
			 url : path +"/bookreplydelete.do" ,
			 data : dataStr ,
			 success: function (data) {
				alert("삭제되었습니다.")
				location.replace(path+"/bookboard.do?seq="+k2)
			}
		 })
	}



</script>
<section>

	<div align="center">
		<font size="15"><b> ${m.bname }</b> </font> <br> <b>${m.bname}</b>
		${m.id }
	</div>

	<form action="<%=path %>/bookedit.do" method="post"
		enctype="multipart/form-data">
		<table align="center">
			<input type="hidden" name="id" value="${m.id }">
			<input type="hidden" name="seq" id="seq" value="${m.seq }">


			<tr>
				<td align="center"><img
					src="<%=path%>/book/files/${m.updatefilestr }" width="350"
					height="450"> <textarea readonly="readonly" rows="30"
						cols="50">${m.tag }</textarea></td>
			</tr>
			
			<%if(id==null){ %>
	
			<%}else if(id.equals(id1)){%>
			<tr align="center">
				<td><input type="submit" value="수 정"> <input
					type="button" id="del" value="삭 제"></td>
			</tr>
			<%}%>



		</table>
		
		
		
<div align="center">
	<table class="table1"  width="1000" height="100" >

		<c:forEach items="${li }" var="m1">
			<input type="hidden" name="idx" id="idx" value="${m1.idx }"> 
			<input type="hidden" name="seq" id="m1seq" value="${m1.seq }"> 
			<tr >
			
				 
				<th align="center" >${m1.id }</th>
				 <td width="500" >${m1.tag} </td>
				
				 
				 <td align="center" width="100"><fmt:formatDate pattern="yyyy-MM-dd" value="${m1.replydate }" /></td>
				 
				 
				 
					<c:set var ="id1" value="${m1.id }"/>
					
				 <c:if test="${id eq id1}">
				 	<td >
				  		<input id="e1" type="button"  value="답글" >
				  		
				  		<input id="e3" type="button" onclick="del2('${m1.idx }','${m1.seq }')" value="삭제">
				  		
				  	</td>
				 </c:if>
				             
			</tr>
		
		</c:forEach>

	</table>		
</div>
		
	</form>

	<br> <br>
	<hr>
	<%if(id==null){
	id="비회원";	
	%>
	<div align="center">
		<table class="tab" width="400" height="100">
			<tr>
				<td><%=id%></td>
			</tr>
			<tr>
				<td><textarea rows="3" cols="100"></textarea></td>
			</tr>
			
			<tr>
				<td align="right"><input type="button" id="ch" value="댓 글 달 기"></td>
			</tr>
			
		</table>
	</div>
	<%}else{%>
	<form name=f1  onSubmit="return ck1()" action="<%=path%>/bookreplyinsert.do?idx=${m.idx}" >
	<div align="center" id="d1">
		<table class="tab" width="400" height="100">
			<tr>
				<td align="left"><%=id %></td>
			</tr>
			<tr><td><input type="hidden" name="id" value="<%=id%>"></td></tr>
			<tr><td><input type="hidden" name="seq" value="${m.seq}"></td></tr>
			<tr><td><input type="hidden" name="idx" value="${m.idx}"></td></tr>
			
			<tr>
				<td><textarea rows="3" cols="100" name="tag"></textarea></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" id="ch1" value="댓 글 달 기"></td>
			</tr>
		</table>
	</div>
	</form>
	<%} %>
</section>
<%@include file="../include/bottom.jsp"%>