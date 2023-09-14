<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
	<h2>TEST2</h2>
	1. ${pageScope.msg }<br>
	2. ${requestScope.msg }<br> <!-- 리퀘스트 영역에서만 메시지 출력 즉, 리퀘스트 영역을 통해서만 가는군! -->
	3. ${sessionScope.msg }<br>
	4. ${applicationScope.msg }<br>
	5. ${msg }<br>
	
	
	${msg }
</body>
</html>