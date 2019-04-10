<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>

	<style>
	
	#tbcss1 {
		align: center;
	}
	</style>
	<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
	<title>Home</title>
</head>
<body>


<form name="mainForm">

<input type="button" name="login" value="login">	


home 2 
<table id="tbcss1">
	<tr>
		<td>
			ID
		</td>
		<td>
			<input type="text" name="id">	<br>
		</td>
	</tr>	
	
	<tr>
		<td>
			PassWord
		</td>
		<td>
			<input type="text" name="pwd">		<br>
		</td>
	</tr>
	<input type="button" name="register" value="회원가입">	
</table>

</form>



</body>


</html>
