<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@include file="../include/top.jsp" %>

<script>
var  path='${pageContext.request.contextPath}';
function ins() {
	 location.href =path+"/book/insert.jsp";
}
</script>


<section>
<div align="center">
<h2> 책 소 개</h2>

</div>
<table align="center">
 <c:set var="i" value="0" />
 <c:set var="j" value="4" />


	
	

	
	
	
	<c:forEach items="${li}"  var="m" >
	<c:if test="${i%j == 0}">
	<tr>
	</c:if>
	<td align="center">
			<a href="<%=path %>/bookboard.do?seq=${m.seq}&idx=${m.idx}">
			<img src="<%=path%>/book/files/${m.updatefilestr }" width="150" height="250" class="img"> 
			</a>
			<br>
			<b>${m.bname }(${m.writer })</b>
			<br>
			${m.id }
			<br>
			조회수: ${m.cnt }
			<br>
			등록일: ${m.regdate}
			<br>
			
			
			</td>
			
		<c:if test="${i%j == j-1 }"> 
		</tr>
		</c:if>
		<c:set  var="i" value="${i+1 }" /> <!--증감-->
		</c:forEach>
</table>


<%if(id!=null){ %>
<div align="right">
<input type="button" onclick="ins()" value="글 쓰 기">
</div>
<%} %>
</section>
<%@include file="../include/bottom.jsp" %>
