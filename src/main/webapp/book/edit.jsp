<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/top.jsp" %>
<section>
<div align="center">
<h2> 책 소 개</h2>
</div>
<%
System.out.println(path);
%>
<form  action="<%=path %>/bookupdate.do?seq=${m.seq}"
	  method="post" enctype="multipart/form-data" >

<table align="center">
 	<input type="hidden" name="seq" value="${m.seq }">
  
  	
  
	<tr><td>책 이름</td><td><input type="text" name="bname" value="${m.bname }"></td></tr>
	<tr><td>저 자</td><td><input type="text" name="writer" value="${m.writer }"></td></tr>
	<tr>
		<td>
			책 내용</td><td><textarea name="tag" cols="30" rows="20">${m.tag }</textarea>
			<img src="<%=path%>/book/files/${m.updatefilestr }" width="150" height="250" class="img"> 
		</td>
	</tr>	
	<tr><td>사 진</td><td><input type="file" name="updatefile"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="수 정"></td></tr>
	
</table>
</form>
</section>
<%@include file="../include/bottom.jsp" %>
