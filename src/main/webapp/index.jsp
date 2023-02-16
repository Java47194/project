<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(function () {
	var t1= setInterval(function() {
		$('img').first().appendTo('#id1');
	}, 2000);
	
})





</script>
<section> 
<br>
<div align="center" id="id1">
<img src="files/카네기자기관리론.jpg" width="150" height="250">
<img src="files/부자아빠.jpg" width="150" height="250">
<img src="files/정주영.jpg" width="150" height="250">
<img src="files/부의추월차선.jpg" width="150" height="250">
<img src="files/그릇.jpg" width="150" height="250">
<img src="files/슈독.jpg" width="150" height="250">


<img src="files/해빗.jpg" width="150" height="250">
<img src="files/역행자.jpg" width="150" height="250">
<img src="files/이기는습관.jpg" width="150" height="250">
<img src="files/생각의비밀.jpg" width="150" height="250">
<img src="files/출근길.jpg" width="150" height="250">
<img src="files/게으른.jpg" width="150" height="250">
</div>
</section>
<%@ include file="../include/bottom.jsp" %>