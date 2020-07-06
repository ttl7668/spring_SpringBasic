<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>점수결과화면</h2>
	<c:forEach var="vo" items="${list }" varStatus="num">
		번호:${vo.num}
		이름:${vo.name }<br>
		국어:${vo.kor }<br>
		영어:${vo.eng }<br>
		수학:${vo.math }<br>
		<button type="button" onclick="location.href='scoreDelete?num=${vo.num}'">삭제</button>
		
	</c:forEach>
	
	<a href="scoreRegist">점수추가 등록</a>
	
	<script>
		(function(){
			if('${num}'!==''){
				alert('${num}'+'가 삭제되엇다');
			}
		})()
	</script>
	
	</body>
</html>