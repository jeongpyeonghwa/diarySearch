<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
<!-- <link rel="stylesheet" href="css/signUp.css"> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- <script src="js/selectTest.js"></script> -->
<script src="<c:url value="/resources/js/selectTest.js" />"></script>

</head>         
<body>
<div class="container">
	<h1>ȸ������</h1>
	
	<div class="label">�̸�</div>
	<div class="form">
		<input type="text" id="userNm" placeholder="�̸��� �Է����ּ���"/>	
	</div>
	
	<div class="label">���̵�</div>
	<div class="form">
		<input type="text" id="userId" placeholder="���̵� �Է����ּ���"/>	
	</div>	
	
	<div class="label">��й�ȣ</div>
	<div class="form">
		<input type="password" id="userPw" placeholder="��й�ȣ�� �Է����ּ���"/>	
	</div>
	
	<div class="label">��й�ȣȮ��</div>
	<div class="form">
		<input type="password" id="userCheckPw" placeholder="��й�ȣ�� �Է����ּ���"/>	
	</div>	
	
	<button id="signUp">�����ϱ�</button>
</div>
</body>
</html>