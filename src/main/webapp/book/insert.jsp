<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/top.jsp" %>
<section>
<div align="center">
<h2> 책 소 개</h2>
</div>

<form  action="<%=path %>/bookinsert.do"
	  method="post" enctype="multipart/form-data" >

<table align="center">
  <input type="hidden" name="id" value="<%=id %>">
	<tr><td>책 이름</td><td><input type="text" name="bname"></td></tr>
	<tr><td>저 자</td><td><input type="text" name="writer"></td></tr>
	<tr><td>책 내용</td><td><textarea name="tag" cols="50" rows="20"></textarea></td></tr>	
	<tr><td>사 진</td><td><input type="file" name="updatefile"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="글 쓰 기"></td></tr>
	
</table>
</form>
</section>
<%@include file="../include/bottom.jsp" %>
